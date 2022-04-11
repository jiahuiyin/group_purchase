package cn.yinjiahui.group_purchase.util;

import cn.yinjiahui.group_purchase.po.Message;

import java.util.Date;

public class MessageUtil {

    public static Message getMessageInfo(com.farsunset.cim.sdk.server.model.Message message) {
        Message messageInfo = new Message();
        messageInfo.setAction(message.getAction());
        messageInfo.setContent(message.getContent());
        messageInfo.setReceiver(message.getReceiver());
        messageInfo.setSender(message.getSender());
        messageInfo.setCreateTime(new Date(message.getTimestamp()));
        return messageInfo;
    }
}
