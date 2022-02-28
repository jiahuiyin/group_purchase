package cn.yinjiahui.group_purchase.mapper;

import cn.yinjiahui.group_purchase.po.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;

public interface UserMapper extends BaseMapper<UserInfo> {
    @Insert("INSERT INTO `voa_file` (filename,filesize,teamid,truename)" +
            " VALUES(#{fileName},#{fileSize},#{teamId},#{trueName})")
    void addFile(UserInfo fileInfo);
}
