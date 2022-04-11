package cn.yinjiahui.group_purchase.controller;

import cn.yinjiahui.group_purchase.common.Result;
import cn.yinjiahui.group_purchase.push.DefaultMessagePusher;
import cn.yinjiahui.group_purchase.service.MessageService;
import com.farsunset.cim.sdk.server.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/message")
public class MessageController {
    @Autowired
    MessageService messageService;
    @Resource
    private DefaultMessagePusher defaultMessagePusher;

    @PostMapping(value = "/send")
    public Result send(@RequestBody Message message) {
        defaultMessagePusher.push(message);
        return Result.success(message.getId());
    }

    @PostMapping("/get")
    public Result getMessage(@RequestParam String receiverId) {
        List message = messageService.getMessage(Integer.valueOf(receiverId));
        return Result.success(message);
    }
}
