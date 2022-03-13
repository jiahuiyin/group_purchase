package cn.yinjiahui.group_purchase.controller;

import cn.yinjiahui.group_purchase.common.Result;
import cn.yinjiahui.group_purchase.po.UserAddress;
import cn.yinjiahui.group_purchase.service.UserAddressService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user_address")
@Api(value = "UserAddressController")
public class UserAddressController {
    @Autowired
    UserAddressService userAddressService;

    @PostMapping("/mget_user_address")
    public Result mGetUserAddress() {
        List<UserAddress> userAddresses = userAddressService.selectByUId();
        return Result.success(userAddresses);
    }

    @PostMapping("/save_user_address")
    public Result saveUserAddress(@RequestParam UserAddress userAddress) {
        userAddressService.save(userAddress);
        return Result.success();
    }

    @PostMapping("/save_user_address")
    public Result delUserAddress(@RequestParam Integer userAddressId) {
        userAddressService.deleteById(userAddressId);
        return Result.success();
    }
}
