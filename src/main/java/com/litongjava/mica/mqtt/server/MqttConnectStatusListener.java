package com.litongjava.mica.mqtt.server;

import net.dreamlu.iot.mqtt.core.server.event.IMqttConnectStatusListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;

/**
 * mqtt 连接状态
 */
public class MqttConnectStatusListener implements IMqttConnectStatusListener {
  private static final Logger logger = LoggerFactory.getLogger(MqttConnectStatusListener.class);

  @Override
  public void online(ChannelContext context, String clientId, String username) {
    logger.info("Mqtt clientId:{} username:{} online.", clientId, username);
  }

  @Override
  public void offline(ChannelContext context, String clientId, String username, String reason) {
    logger.info("Mqtt clientId:{} username:{} offline reason:{}.", clientId, username, reason);
  }

}