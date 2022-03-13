package cn.yinjiahui.group_purchase.controller;


import cn.yinjiahui.group_purchase.common.Result;
import cn.yinjiahui.group_purchase.po.ShoppingCart;
import cn.yinjiahui.group_purchase.service.ShoppingCartService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/shopping_cart")
@Api(value = "ShoppingCartController")
public class ShoppingCartController {
    @Autowired
    ShoppingCartService shoppingCartService;

    @PostMapping("/get_my_shopping_cart")
    public Result getShoppingCart() {
        try {
            List<ShoppingCart> l = shoppingCartService.getMyShoppingCart();
            return Result.success(l);
        } catch (Exception e) {
            return Result.fail(e.toString());
        }
    }

    @PostMapping("/insert_shopping_cart")
    public Result saveShoppingCart(@RequestParam ShoppingCart shoppingCart) {
        try {
            shoppingCartService.insertShoppingCart(shoppingCart);
            return Result.success("添加成功");
        } catch (Exception e) {
            return Result.fail(e.toString());
        }
    }

}
