package cn.yinjiahui.group_purchase.service;

import java.util.List;

public interface ClassifyService {
    List<Integer> mGet_GoodsId_inClassify(String classify);

    void insertClassify(String[] classify, Integer[] goodsId);
}
