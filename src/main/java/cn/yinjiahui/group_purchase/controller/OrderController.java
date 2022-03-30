package cn.yinjiahui.group_purchase.controller;

import cn.yinjiahui.group_purchase.common.Result;
import cn.yinjiahui.group_purchase.service.OrderService;
import cn.yinjiahui.group_purchase.vo.OrderGoods;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/order")
@Api(value = "OrderController")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/get_order")
    public Result mGetOrder() {
        return Result.success(orderService.mGetOrder());
    }

    @PostMapping("/buy")
    public Result buy(@RequestBody OrderGoods orderGoods) {
        return null;
    }
}
