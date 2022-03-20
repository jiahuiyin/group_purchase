package cn.yinjiahui.group_purchase.po;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

@Data
public class MessageInfo {

    private Integer id;
    private String action;
    private String content;
    private String sender;
    private String receiver;
    @TableField("create_time")
    private Date createTime;
}
