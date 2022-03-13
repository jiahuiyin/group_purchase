package cn.yinjiahui.group_purchase.service.impl;

import cn.yinjiahui.group_purchase.mapper.OrderMapper;
import cn.yinjiahui.group_purchase.po.Goods;
import cn.yinjiahui.group_purchase.po.Order;
import cn.yinjiahui.group_purchase.service.GoodsService;
import cn.yinjiahui.group_purchase.service.OrderService;
import cn.yinjiahui.group_purchase.service.UserService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    UserService userService;
    @Autowired
    GoodsService goodsService;

    @Override
    public List<Order> mGetOrder() {
        Integer uid = userService.getCurrentUserId();
        List<Order> orders = orderMapper.selectByMap(new HashMap<>() {
            {
                put("user_id", uid);
            }
        });
        getOrderGoods(orders);
        return orders;
    }


    private void getOrderGoods(List<Order> orders) {
        for (Order order : orders) {
            String goodsStr = order.getGoodsList();
            List<Integer> goodsIds = JSON.parseArray(goodsStr).toJavaList(Integer.class);
            List<Goods> goods = goodsService.mGetGoods(goodsIds);
            order.setGoods(goods);
        }
    }

    @Override
    public Integer buy() {
        Order order = new Order();
        Integer uid = userService.getCurrentUserId();
        order.setId(uid);
        //todo
        return null;
    }
}
