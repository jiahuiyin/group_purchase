package cn.yinjiahui.group_purchase.service.impl;

import cn.yinjiahui.group_purchase.mapper.ShoppingCartMapper;
import cn.yinjiahui.group_purchase.po.ShoppingCart;
import cn.yinjiahui.group_purchase.service.ShoppingCartService;
import cn.yinjiahui.group_purchase.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ShoppingCartServiceImp implements ShoppingCartService {
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;
    @Autowired
    private UserService userService;

    /**
     * 返回此账号所有购物车条目
     *
     * @return 购物车类型中包括一个商品 这个会返回商品
     */
    @Override
    public List<ShoppingCart> getMyShoppingCart() {
        return shoppingCartMapper.getMyShoppingCart(userService.getCurrentUserId());
    }

    /**
     * 添加到购物车
     *
     * @param s 先查询是否有 有的话购物车该条目数量+1 没有的话保存到购物车
     */
    @Override
    public void insertShoppingCart(ShoppingCart s) {
        if (s.getId() == null) {
            List<ShoppingCart> shoppingCarts = shoppingCartMapper.getShoppingCart(s.getUserId(), s.getGoodsId());

            if (shoppingCarts.size() > 0) {
                shoppingCarts.get(0).setNum(s.getNum() + shoppingCarts.get(0).getNum());
                shoppingCartMapper.updateById(shoppingCarts.get(0));
            } else {
                shoppingCartMapper.insertOne(s);
            }
        } else {
            shoppingCartMapper.updateById(s);
        }
    }

}
