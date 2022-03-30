package cn.yinjiahui.group_purchase.controller;

import cn.yinjiahui.group_purchase.common.Result;
import cn.yinjiahui.group_purchase.po.Category;
import cn.yinjiahui.group_purchase.po.Goods;
import cn.yinjiahui.group_purchase.service.GoodsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goods")
@Api(value = "GoodsController")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    /**
     * 通过商品id list得到系列商品
     *
     * @param goodsIdList
     * @return
     */
    @PostMapping("/mget_goods")
    public Result mGetGoods(@RequestParam List<Integer> goodsIdList) {

        List<Goods> goods = goodsService.mGetGoods(goodsIdList);
        return Result.success(goods);
    }


    /**
     * 通过商家得到商品
     *
     * @param merchantId 分类
     * @return 商品列表
     */
    @PostMapping("/mget_goods_by_merchant")
    public Result mGetGoodsByMerchant(@RequestParam Integer merchantId) {
        List<Goods> goods = goodsService.mGetGoodsByMerchant(merchantId);
        return Result.success(goods);
    }

    /**
     * 通过分类得到商品
     *
     * @param categoryId 分类
     * @return 商品列表
     */
    @PostMapping("/mget_goods_by_category")
    public Result mGetGoodsByClassify(@RequestParam Integer categoryId) {
        List<Goods> goods = goodsService.mGetGoodsByCategory(categoryId);
        return Result.success(goods);
    }


    /**
     * 添加商品
     *
     * @return 结果
     */
    @PostMapping("/save_goods")
    public Result saveGoods(@RequestBody Goods goods) {
        try {
            goodsService.saveGoods(goods);
            return Result.success("添加成功！");
        } catch (Exception e) {
            return Result.fail(e.toString());
        }
    }


    @PostMapping("/msearch")
    public Result mSearchByKeyWord(@RequestParam String keyWord) {
        try {
            List<Goods> list = goodsService.mGetGoodsByTitleLike("%" + keyWord + "%");
            return Result.success(list);
        } catch (Exception e) {
            System.out.println(e);
            return Result.fail(e.toString());
        }
    }

    @PostMapping("/mget_category")
    public Result mGetCategory() {
        try {
            List<Category> list = goodsService.mGetCategory();
            return Result.success(list);
        } catch (Exception e) {
            System.out.println(e);
            return Result.fail(e.toString());
        }
    }

}
