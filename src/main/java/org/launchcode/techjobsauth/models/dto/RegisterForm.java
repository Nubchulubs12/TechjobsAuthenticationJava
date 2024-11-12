package org.launchcode.techjobsauth.models.dto;

public class RegisterForm extends LoginForm{

    private String verifypassword;

    public String getVerifypassword(){
        return verifypassword;
    }

    public void setVerifypassword(String verifypassword) {
        this.verifypassword = verifypassword;
    }
}
