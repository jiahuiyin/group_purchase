package cn.yinjiahui.group_purchase.service;

import cn.yinjiahui.group_purchase.po.Goods;

import java.util.List;


public interface GoodsService {

    List<Goods> mGetGoods(List<Integer> goodsIdList);

    void saveGoods(Goods goods);

    List<Goods> mGetGoodsByTitleLike(String keyWord);

    List<Goods> mGetGoodsByCategory(Integer categoryId);

    List<Goods> mGetGoodsByMerchant(Integer merchantId);
}
