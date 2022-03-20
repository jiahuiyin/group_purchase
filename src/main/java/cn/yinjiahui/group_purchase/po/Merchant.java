package cn.yinjiahui.group_purchase.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@TableName("merchant")
public class Merchant {
    @TableId
    private Integer id;

    private Integer userId;

    private String image;

    private String name;

    private String description;

    private String phone;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;
}
