package cn.yinjiahui.group_purchase.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("goods")
public class Goods {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String title;

    @TableField("category_id")
    private Integer categoryId;

    @TableField("merchant_id")
    private Integer merchantId;


    private String desc;

    private Integer price;

    private String image;
    @TableField("stock_qty")
    private Integer stockQty;

    @TableField("sold_qty")

    private Integer soldQty;
    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;
}