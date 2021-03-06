package cn.yinjiahui.group_purchase.service.impl;

import cn.teaey.apns4j.Apns4j;
import cn.teaey.apns4j.network.ApnsChannel;
import cn.teaey.apns4j.network.ApnsChannelFactory;
import cn.teaey.apns4j.network.ApnsGateway;
import cn.yinjiahui.group_purchase.service.ApnsService;
import cn.yinjiahui.group_purchase.util.ApnsPayloadCompat;
import com.farsunset.cim.sdk.server.model.Message;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class JavaApnsServiceImpl implements ApnsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(JavaApnsServiceImpl.class);

	@Value("${apple.apns.p12.password}")
	private String password;
	@Value("${apple.apns.p12.file}")
	private String p12Path;
	@Value("${apple.apns.debug}")
	private boolean isDebug;

	@SuppressWarnings("deprecation")
	@Override
	public void push(Message message, String deviceToken) {

		if (StringUtils.isBlank(deviceToken)) {
			return;
		}

		InputStream stream = getClass().getResourceAsStream(p12Path);
		ApnsChannelFactory apnsChannelFactory = Apns4j.newChannelFactoryBuilder()
				.keyStoreMeta(stream)
				.keyStorePwd(password)
				.apnsGateway(isDebug ? ApnsGateway.DEVELOPMENT : ApnsGateway.PRODUCTION)
				.build();

		ApnsChannel apnsChannel = apnsChannelFactory.newChannel();

		try {
			ApnsPayloadCompat apnsPayload = new ApnsPayloadCompat();
			apnsPayload.setAction(message.getAction());
			apnsPayload.setContent(message.getContent());
			apnsPayload.setSender(message.getSender());
			apnsPayload.setFormat(message.getFormat());
			apnsPayload.setReceiver(message.getReceiver());
			apnsChannel.send(deviceToken, apnsPayload);

			LOGGER.info(deviceToken + "\r\ndata: {}", apnsPayload.toJsonString());
		} catch (Exception exception) {
			LOGGER.error("Apns has error", exception);
		} finally {
			apnsChannel.close();
			IOUtils.closeQuietly(stream);
		}
	}
}
