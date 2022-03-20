package cn.yinjiahui.group_purchase.service.impl;

import cn.yinjiahui.group_purchase.mapper.MessageMapper;
import cn.yinjiahui.group_purchase.po.MessageInfo;
import cn.yinjiahui.group_purchase.service.MessageService;
import cn.yinjiahui.group_purchase.service.UserService;
import cn.yinjiahui.group_purchase.util.MessageUtil;
import com.farsunset.cim.sdk.server.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageMapper messageMapper;

    @Autowired
    UserService userService;

    @Override
    public void addMessage(Message message, Integer visited) {
        MessageInfo messageInfo = MessageUtil.getMessageInfo(message);
        messageMapper.addMessage(messageInfo, visited);
    }


    @Override
    public List getMessage(Integer id) {
        Integer currentUserId = userService.getCurrentUserId();
        List<MessageInfo> send = messageMapper.getMessage(currentUserId, id);
        return send;
    }
}
