package com.jkudacity.lesson4final.controller;

import com.jkudacity.lesson4final.model.ChatForm;
import com.jkudacity.lesson4final.model.ChatMessage;
import com.jkudacity.lesson4final.service.MassageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {

    MassageService massageService;

    public ChatController(MassageService massageService) {
        this.massageService = massageService;
    }

    @GetMapping
    public String getHomePage(@ModelAttribute("chatForm") ChatForm chatForm, Model model) {
        model.addAttribute("messages", this.massageService.getChatMessages());
        return "chat";
    }

    @PostMapping
    public String addMessage(@ModelAttribute("chatForm") ChatForm chatForm, Model model) {
        massageService.addMessage(chatForm);
        model.addAttribute("messages", massageService.getChatMessages());
        chatForm.setMessageText("");
        chatForm.setUserName("");
        return "chat";
    }

    @ModelAttribute("allMessageTypes")
    public String[] allMessageTypes(){
        return new String[] {"Say", "Shout", "Whisper"};
    }
}
