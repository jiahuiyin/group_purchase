package cn.yinjiahui.group_purchase.controller;

import cn.yinjiahui.group_purchase.common.Result;
import cn.yinjiahui.group_purchase.po.Goods;
import cn.yinjiahui.group_purchase.service.GoodsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/goods")
@Api(value = "GoodsController")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @PostMapping("/mget_goods")
    public Result mGetGoods(@RequestParam List<Integer> goodsIdList) {

        List<Goods> goods = goodsService.mGetGoods(goodsIdList);
        return Result.success(goods);
    }
}
