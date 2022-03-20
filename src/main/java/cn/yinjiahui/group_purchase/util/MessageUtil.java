package cn.yinjiahui.group_purchase.util;

import cn.yinjiahui.group_purchase.po.MessageInfo;
import com.farsunset.cim.sdk.server.model.Message;

import java.util.Date;

public class MessageUtil {

    public static MessageInfo getMessageInfo(Message message) {
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setAction(message.getAction());
        messageInfo.setContent(message.getContent());
        messageInfo.setReceiver(message.getReceiver());
        messageInfo.setSender(message.getSender());
        messageInfo.setCreateTime(new Date(message.getTimestamp()));
        return messageInfo;
    }
}
