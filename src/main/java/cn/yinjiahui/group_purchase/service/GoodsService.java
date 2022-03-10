package cn.yinjiahui.group_purchase.service;

import cn.yinjiahui.group_purchase.po.Goods;

import java.util.List;


public interface GoodsService {

    List<Goods> mGetGoods(List<Integer> goodsIdList);

    Goods mGetGoodsById(Integer id);

    void mInsertNewGoods(String[] tittle, Integer[] num, float[] price);

    List<Goods> mGetGoodsByTitleLike(String keyWord);
}
