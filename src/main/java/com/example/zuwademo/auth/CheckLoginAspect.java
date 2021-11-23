package com.example.zuwademo.auth;

import cn.hutool.crypto.digest.MD5;
import com.example.zuwademo.exception.SystemException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class CheckLoginAspect {
    @Around("@annotation(com.example.zuwademo.auth.CheckLogin)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        checkLogin();
        return joinPoint.proceed();
    }

    public void checkLogin() {
        //1.从request的Header中获取token（签名信息）
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        //对签名进行验证
        String token = request.getHeader("token");
        String x = (String) request.getParameter("phoneNumber");
        String hex16 = MD5.create().digestHex16(x);
        if (!hex16.equals(token)) {
            throw new SystemException("用户没有登录");
        }
    }
}

























