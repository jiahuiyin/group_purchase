package cn.yinjiahui.group_purchase.po;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@TableName("order")
public class Order {

    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("user_id")
    private Integer userId;

    @TableField("address_id")
    private Integer addressId;

    @TableField("total_price")
    private Integer totalPrice;

    private String goodsList;

    private List<Goods> goods;
    /**
     * 0 待支付 1已支付 2已送达
     */
    private Integer status = 0;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;
}
