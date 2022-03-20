package cn.yinjiahui.group_purchase.service.impl;

import cn.yinjiahui.group_purchase.mapper.CategoryMapper;
import cn.yinjiahui.group_purchase.mapper.GoodsMapper;
import cn.yinjiahui.group_purchase.po.Category;
import cn.yinjiahui.group_purchase.po.Goods;
import cn.yinjiahui.group_purchase.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Goods> mGetGoods(List<Integer> goodsIdList) {
        return goodsMapper.selectBatchIds(goodsIdList);
    }

    @Override
    public void saveGoods(Goods goods) {
        if (goods.getId() == null) {
            goodsMapper.insert(goods);
        }
        goodsMapper.updateById(goods);
    }

    @Override
    public List<Goods> mGetGoodsByTitleLike(String keyWord) {
        return goodsMapper.selectGoodsByTitleLike(keyWord);
    }

    @Override
    public List<Goods> mGetGoodsByCategory(Integer categoryId) {
        return goodsMapper.selectByMap(new HashMap<>() {
            {
                put("category_id", categoryId);
            }
        });
    }

    @Override
    public List<Goods> mGetGoodsByMerchant(Integer merchantId) {
        return goodsMapper.selectByMap(new HashMap<>() {
            {
                put("merchant_id", merchantId);
            }
        });
    }

    @Override
    public List<Category> mGetCategory() {
        return categoryMapper.selectList(null);
    }
}
