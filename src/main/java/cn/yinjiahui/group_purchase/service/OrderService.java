package cn.yinjiahui.group_purchase.service;

import cn.yinjiahui.group_purchase.po.Order;
import cn.yinjiahui.group_purchase.vo.OrderGoods;

import java.util.List;

public interface OrderService {

    List<Order> mGetOrder();

    Integer buy(OrderGoods orderGoods);
}
