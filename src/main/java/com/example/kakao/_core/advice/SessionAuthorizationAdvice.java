package com.example.kakao._core.advice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.example.kakao._core.errors.exception.Exception400;
import com.example.kakao._core.errors.exception.Exception401;
import com.example.kakao.user.User;

@Aspect
@Component
public class SessionAuthorizationAdvice {

    @Autowired
    private HttpSession session;

    @Pointcut("execution(* com.example.kakao.order.OrderRestController.save()) || execution(* com.example.kakao.order.OrderRestController.findAllByUser())")
    public void sessionCheck() {
    }

    @Before("sessionCheck()")
    public void sessionAuthorizationAdvice(JoinPoint jp) {
       User sessionUser = (User) session.getAttribute("sessionUser");
        if (sessionUser == null) {
            throw new Exception401("인증되지 않았습니다");
        }
    }
}
