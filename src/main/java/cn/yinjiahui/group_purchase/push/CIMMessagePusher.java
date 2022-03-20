package cn.yinjiahui.group_purchase.push;

import com.farsunset.cim.sdk.server.model.Message;

/*
 * 消息发送实接口
 *
 */
public interface CIMMessagePusher {

	void push(Message msg);

}
