package cn.yinjiahui.group_purchase.service;

import cn.yinjiahui.group_purchase.po.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    List<ShoppingCart> getMyShoppingCart();

    void insertShoppingCart(ShoppingCart s);

}
