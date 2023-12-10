package com.litongjava.mica.mqtt.server;

import net.dreamlu.iot.mqtt.codec.MqttMessage;
import net.dreamlu.iot.mqtt.core.server.interceptor.IMqttMessageInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;
import org.tio.core.Node;

/**
 * mqtt 消息拦截器
 */
public class MqttMessageInterceptor implements IMqttMessageInterceptor {
  private static final Logger logger = LoggerFactory.getLogger(MqttMessageInterceptor.class);

  @Override
  public void onAfterReceivedBytes(ChannelContext context, int receivedBytes) throws Exception {
    // 注意：此时 clientId 可能为空
    String clientId = context.getBsId();
    Node clientNode = context.getClientNode();
    // ChannelStat channelStat = context.stat;
    // 自定义规则，超限是可用 Tio.remove(context, "xxx超限"); 断开连接。
    logger.info("===接收 client:{} clientId:{} data:{}b", clientNode, clientId, receivedBytes);
  }

  @Override
  public void onAfterDecoded(ChannelContext context, MqttMessage message, int packetSize) {
    // 注意：此时 clientId 可能为空
    String clientId = context.getBsId();
    Node clientNode = context.getClientNode();
    logger.info("===解码 client:{} clientId:{} message:{}", clientNode, clientId, message);
  }

  @Override
  public void onAfterHandled(ChannelContext context, MqttMessage message, long cost) throws Exception {
    String clientId = context.getBsId();
    Node clientNode = context.getClientNode();
    logger.info("===处理完成 ip:{} clientId:{} message:{} 耗时:{}", clientNode, clientId, message, cost);
  }
}