package cn.yinjiahui.group_purchase.mapper;

import cn.yinjiahui.group_purchase.po.Merchant;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MerchantMapper extends BaseMapper<Merchant> {
    @Select("SELECT * FROM merchant WHERE name LIKE '${name}%'")
    List<Merchant> searchMerchant(@Param("name") String name);
}
