package cn.yinjiahui.group_purchase.controller;

import cn.yinjiahui.group_purchase.common.Result;
import cn.yinjiahui.group_purchase.po.Merchant;
import cn.yinjiahui.group_purchase.service.MerchantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api/merchant")
public class MerchantController {

    @Autowired
    MerchantService merchantService;

    @PostMapping("/register")
    public Result registerMerchant(String image, String name, String description) {
        Integer merchantId = merchantService.registerMerchant(image, name, description);
        return Result.success(merchantId);
    }

    @PostMapping("/get")
    public Result getMerchant(Integer merchantId) {
        Merchant merchant = merchantService.getMerchant(merchantId);
        return Result.success(merchant);
    }

    @PostMapping("/search")
    public Result searchMerchant(String name) {
        List<Merchant> merchantList = merchantService.searchMerchant(name);
        return Result.success(merchantList);
    }

    @PostMapping("/mget")
    public Result mgetMerchant() {
        List<Merchant> merchantList = merchantService.mget();
        return Result.success(merchantList);
    }
}
