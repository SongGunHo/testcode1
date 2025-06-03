package com.koreait.spring4.glbal.validators;

public interface PasswordValidator {

    default boolean checkAlpha(String password, boolean caseInsensitive) {
        if (caseInsensitive) { //  대소문자 구분 없는 알파벳 1자 이상
            return password.matches(".*[a-zA-Z]+.*");
        }
        // 대소문자 1개 이상 소문자 1개 이상
        return password.matches(".*[a-z]+.*]") && password.matches(".*[A-Z]+.*");
    }
    default boolean checkNumber(String password){
        return password.matches(".*\\d+.*");
    }
    default boolean checkSpcialChars(String password){
        String pattern =".*[^0-9a-zA-zㄱ-ㅎ가-힣]+.*";
        return password.matches(pattern);
    }
}
