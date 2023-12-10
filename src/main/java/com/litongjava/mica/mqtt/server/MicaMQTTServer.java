package com.litongjava.mica.mqtt.server;


import com.litongjava.utils.config.ProjectConfig;
import net.dreamlu.iot.mqtt.core.server.MqttServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;


public class MicaMQTTServer {
  private static final Logger logger = LoggerFactory.getLogger(MicaMQTTServer.class);

  public static void main(String[] args) {
    ProjectConfig projectConfig = new ProjectConfig();
    String serverIp = projectConfig.getStr("server.ip", "0.0.0.0");
    Integer serverPort = projectConfig.getInt("server.port", 1883);
    Integer serverWebPort = projectConfig.getInt("server.webPort", 8083);
    String serverUsername = projectConfig.getStr("server.username", "mica");
    String serverPassword = projectConfig.getStr("server.password", "mica");
    String httpAuthUsername = projectConfig.getStr("http.auth.username", "mica");
    String httpAuthPassword = projectConfig.getStr("http.auth.password", "mica");


    // 注意：为了能接受更多链接（降低内存），请添加 jvm 参数 -Xss129k
    MqttServer mqttServer = MqttServer.create()
      // 服务端 ip 默认为空，0.0.0.0，建议不要设置
      .ip(serverIp)
      // 默认：1883
      .port(serverPort)
      .webPort(serverWebPort)
      // mqtt 用户名密码
      .usernamePassword(serverUsername, serverPassword)
      // 默认为： 8192（mqtt 默认最大消息大小），为了降低内存可以减小小此参数，如果消息过大 t-io 会尝试解析多次（建议根据实际业务情况而定）
      .readBufferSize(8192)
      //最大包体长度
      //.maxBytesInMessage(1024 * 100)
      //mqtt 3.1 协议会校验 clientId 长度。
      //.maxClientIdLength(64)
      .messageListener((context, clientId, topic, qos, message) -> {
        logger.info("clientId:{} payload:{}", clientId, new String(message.payload(), StandardCharsets.UTF_8));
      })
      // 客户端连接状态监听
      .connectStatusListener(new MqttConnectStatusListener())
      // 自定义消息拦截器
      //.addInterceptor(new MqttMessageInterceptor())
      // 开启 http
      .httpEnable(true)
      // http basic 认证，自定义认证，实现 HttpFilter， 注册到 MqttHttpRoutes 即可
      .httpBasicAuth(httpAuthUsername, httpAuthPassword)
      // 开启 websocket
      .websocketEnable(true)
      // 开始 stat 监控
      .statEnable()
      // 开启 debug 信息日志
      // .debug()
      .start();
  }
}
