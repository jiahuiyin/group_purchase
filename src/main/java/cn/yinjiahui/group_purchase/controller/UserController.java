package cn.yinjiahui.group_purchase.controller;

import cn.yinjiahui.group_purchase.common.Result;
import cn.yinjiahui.group_purchase.po.UserInfo;
import cn.yinjiahui.group_purchase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;


    @GetMapping("/get_user_info")
    public Result getUserInfo() {
        return Result.success(userService.getUserById(userService.getCurrentUserId()));
    }

    @PutMapping("/update_user_info")
    public Result updateUserInfo(UserInfo userInfo) {
        userService.updateUserInfo(userInfo);
        return Result.success(getUserInfo());
    }

}
