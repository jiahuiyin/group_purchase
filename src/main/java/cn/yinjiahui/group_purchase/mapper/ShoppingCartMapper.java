package cn.yinjiahui.group_purchase.mapper;

import cn.yinjiahui.group_purchase.po.ShoppingCart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface ShoppingCartMapper extends BaseMapper<ShoppingCart> {

    @Select("select * from shopping_cart where user_id = #{userId}")
    @Results({
            @Result(property = "goodsEntity", column = "goods_id", one = @One(select = "cn.yinjiahui.group_purchase.mapper.GoodsMapper.selectById"))
    })
    List<ShoppingCart> getMyShoppingCart(Integer userId);

    @Select("select * from shopping_cart where user_id = #{userId} and goods_id=#{goodsId}")
    List<ShoppingCart> getShoppingCart(String userId, Integer goodsId);

    @Insert("INSERT INTO shopping_cart(user_id,goods_id,num) " +
            "VALUES(#{userId},#{goodsId},#{num})")
    void insertOne(ShoppingCart shoppingCart);
}
