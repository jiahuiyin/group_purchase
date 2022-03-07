package cn.yinjiahui.group_purchase.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("goods")
public class Goods {

    @TableId
    private Integer id;

    private String title;

    @TableField("category_id")
    private Integer categoryId;

    @TableField("account_id")
    private Integer accountId;

    private Integer status;

    private String images;

    @TableField("desc_images")
    private String descImages;

    @TableField("sold_start_time")
    private Date soldStartTime;

    @TableField("sold_end_time")
    private Date soldEndTime;
    @TableField("origin_amount")
    private Integer originAmount;

    @TableField("actual_amount")
    private Integer actualAmount;

    @TableField("stock_qty")
    private Integer stockQty;

    @TableField("frozen_qty")
    private String frozenQty;

    @TableField("sold_qty")

    private String soldQty;
    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;
}