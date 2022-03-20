package cn.yinjiahui.group_purchase.push;

import cn.yinjiahui.group_purchase.service.ApnsService;
import cn.yinjiahui.group_purchase.service.CIMSessionService;
import cn.yinjiahui.group_purchase.service.MessageService;
import com.farsunset.cim.sdk.server.model.CIMSession;
import com.farsunset.cim.sdk.server.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

/*
 * 消息发送实现类
 *
 */
@Component
public class DefaultMessagePusher implements CIMMessagePusher {

	@Autowired
	MessageService messageService;
	@Value("${server.host}")
	private String host;
	@Resource
	private CIMSessionService cimSessionService;
	@Resource
	private ApnsService apnsService;


	/*
	 * 向用户发送消息
	 *
	 * @param message
	 */
	@Override
	public void push(Message message) {
		CIMSession session = cimSessionService.get(message.getReceiver());

		if (session == null) {
			messageService.addMessage(message, 0);
			return;
		}


		if (session.isConnected() && Objects.equals(host, session.getHost())) {
			session.write(message);
			messageService.addMessage(message, 1);
		}


	}

}
