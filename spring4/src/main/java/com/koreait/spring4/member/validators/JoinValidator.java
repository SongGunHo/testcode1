package com.koreait.spring4.member.validators;

import com.koreait.spring4.member.controller.RequestJoin;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;


public class JoinValidator {
    public void validate(@Valid RequestJoin form, Error error) {
    }
}
