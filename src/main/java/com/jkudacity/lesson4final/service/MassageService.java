package com.jkudacity.lesson4final.service;

import com.jkudacity.lesson4final.mapper.MessageMapper;
import com.jkudacity.lesson4final.model.ChatForm;
import com.jkudacity.lesson4final.model.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class MassageService {
    MessageMapper messageMapper;

    public MassageService(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Create MassageService");
    }

    public void addMessage(ChatForm chatForm) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setUserName(chatForm.getUserName());

        switch(chatForm.getMessageType()) {
            case "Shout":
                chatMessage.setMessageText(chatForm.getMessageText().toUpperCase());
                break;
            case "Whisper":
                chatMessage.setMessageText(chatForm.getMessageText().toLowerCase());
                break;
            case "Say":
                chatMessage.setMessageText(chatForm.getMessageText());
        }
        messageMapper.insert(chatMessage);
    }

    public List<ChatMessage> getChatMessages() {
        return messageMapper.getAllMessages();
    }
}
