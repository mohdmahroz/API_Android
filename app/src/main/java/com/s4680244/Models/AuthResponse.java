package com.s4680244.Models;

public class AuthResponse {
    String keypass;
    public AuthResponse(String keypass){
        this.keypass = keypass;
    }
    public String getKeypass(){
        return this.keypass;
    }
    public void setKeypass(String keypass){
        this.keypass = keypass;
    }
}
