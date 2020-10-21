package com.jkudacity.lesson4final.service;

import com.jkudacity.lesson4final.model.ChatForm;
import com.jkudacity.lesson4final.model.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MassageService {
    List<ChatMessage> chatMessages;

    @PostConstruct
    public void postConstruct() {
        this.chatMessages = new ArrayList<>();
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
        chatMessages.add(chatMessage);
    }

    public List<ChatMessage> getChatMessages() {
        return new ArrayList<>(this.chatMessages);
    }
}
