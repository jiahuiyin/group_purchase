package cn.yinjiahui.group_purchase.service.impl;

import cn.yinjiahui.group_purchase.common.BaseException;
import cn.yinjiahui.group_purchase.mapper.OrderMapper;
import cn.yinjiahui.group_purchase.po.Goods;
import cn.yinjiahui.group_purchase.po.Order;
import cn.yinjiahui.group_purchase.service.GoodsService;
import cn.yinjiahui.group_purchase.service.OrderService;
import cn.yinjiahui.group_purchase.service.UserService;
import cn.yinjiahui.group_purchase.vo.OrderGoods;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

import static cn.yinjiahui.group_purchase.common.SystemErrorType.NO_QTY_STOCK;

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
        return orders;
    }


    private void getOrderGoods(List<Order> orders) {
        for (Order order : orders) {
            String goodsStr = order.getGoodsList();
            List<Integer> goodsIds = JSON.parseArray(goodsStr).toJavaList(Integer.class);
            List<Goods> goods = goodsService.mGetGoods(goodsIds);
            //order.setGoods(goods);
        }
    }

    @Override
    public Integer buy(OrderGoods orderGoods) {
        Order order = new Order();
        Integer uid = userService.getCurrentUserId();
        order.setUserId(uid);
        List<Goods> goodsList = goodsService.mGetGoods(List.of(orderGoods.getGoodsId()));
        Goods goods = goodsList.get(0);
        if (goods.getStockQty() >= orderGoods.getNum()) {
            goods.setStockQty(goods.getStockQty() - orderGoods.getNum());
            goods.setSoldQty(goods.getSoldQty() + orderGoods.getNum());
            goodsService.saveGoods(goods);
            order.setTotalPrice(goods.getPrice() * orderGoods.getNum());
            order.setAddressId(orderGoods.getAddressId());
            order.setMerchantId(goods.getMerchantId());
            order.setGoodsList(JSON.toJSONString(goods));
            orderMapper.insert(order);
            return order.getId();
        } else {
            throw new BaseException(NO_QTY_STOCK);
        }
    }
}
