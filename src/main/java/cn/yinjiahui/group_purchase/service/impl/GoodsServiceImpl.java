package cn.yinjiahui.group_purchase.service.impl;

import cn.yinjiahui.group_purchase.mapper.GoodsMapper;
import cn.yinjiahui.group_purchase.po.Goods;
import cn.yinjiahui.group_purchase.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public List<Goods> mGetGoods(List<Integer> goodsIdList) {
        return goodsMapper.selectBatchIds(goodsIdList);
    }
}
