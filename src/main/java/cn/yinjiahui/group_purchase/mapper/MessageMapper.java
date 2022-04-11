package cn.yinjiahui.group_purchase.mapper;

import cn.yinjiahui.group_purchase.po.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MessageMapper {

    @Options(useGeneratedKeys = true, keyProperty = "message.id", keyColumn = "id")
    @Insert("INSERT INTO `message` (action,content,sender,receiver,is_visited) " +
            "VALUES (#{message.action},#{message.content},#{message.sender},#{message.receiver},#{visited})")
    void addMessage(@Param("message") Message message, @Param("visited") Integer visited);


    @Select("SELECT action,content,sender,receiver  FROM message WHERE (sender=#{senderId} AND receiver=#{receiverId})OR (sender=#{receiverId} AND receiver=#{senderId})")
    List<Message> getMessage(Integer senderId, Integer receiverId);


}
