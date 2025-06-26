package com.koreait.spring4.glbal.validators;



public interface Mobilevalidator {



    default boolean checkMobile(String mobile){
        mobile = mobile.replaceAll("\\D", "");
        String pattern = "^010[016]\\d[3,4]\\d[4]$";
        return mobile.matches(pattern);
    }









}
