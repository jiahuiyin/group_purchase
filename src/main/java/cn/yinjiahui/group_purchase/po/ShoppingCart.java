package cn.yinjiahui.group_purchase.po;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;


@Data
@TableName("shopping_cart")
public class ShoppingCart {
    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField(value = "user_id")
    private String userId;

    @TableField(value = "goods_id")
    private Integer goodsId;

    private Integer num;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;

    private Goods goodsEntity;
}
