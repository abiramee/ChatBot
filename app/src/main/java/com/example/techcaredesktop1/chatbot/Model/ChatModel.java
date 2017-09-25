package com.example.techcaredesktop1.chatbot.Model;

/**
 * Created by TechCare Desktop 1 on 9/18/2017.
 */

public class ChatModel {
    private String message;
    private boolean isSend;

    public ChatModel() {
    }

    public ChatModel(String message, boolean isSend) {
        this.message = message;
        this.isSend = isSend;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSend() {
        return isSend;
    }

    public void setSend(boolean send) {
        isSend = send;
    }
}
