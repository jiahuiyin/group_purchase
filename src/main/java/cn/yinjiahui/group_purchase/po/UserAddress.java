package cn.yinjiahui.group_purchase.po;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("user_address")
public class UserAddress {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer user_id;

    private Integer phone;

    private String name;

    private String address;
    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;
}
