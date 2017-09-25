package com.example.techcaredesktop1.chatbot.Model;

/**
 * Created by TechCare Desktop 1 on 9/18/2017.
 */

public class Model {
    private String response;
    private String id;
    private int result;
    private String msg;

    public Model() {

    }

    public Model(String response, String id, int result, String msg) {
        this.response = response;
        this.id = id;
        this.result = result;
        this.msg = msg;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
