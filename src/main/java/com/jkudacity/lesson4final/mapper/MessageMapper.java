package com.jkudacity.lesson4final.mapper;

import com.jkudacity.lesson4final.model.ChatMessage;
import com.jkudacity.lesson4final.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MessageMapper {
    @Select("SELECT * FROM MESSAGES WHERE messageId = #{messageId}")
    ChatMessage getMessage(String messageId);

    @Insert("INSERT INTO MESSAGES (userName, messageText) VALUES(#{messageText}, #{messageText})")
    @Options(useGeneratedKeys = true, keyProperty = "messageId")
    int insert(ChatMessage chatMessage);
}
