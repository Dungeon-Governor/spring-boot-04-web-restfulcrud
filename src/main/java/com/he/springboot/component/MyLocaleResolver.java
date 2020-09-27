package com.he.springboot.component;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
//        接收前端国际化参数l
        String l = httpServletRequest.getParameter("l");
//        默认情况下就按照操作系统的语言信息来
        Locale locale = Locale.getDefault();
//        判断参数是否为空
        if(!StringUtils.isEmpty(l)){
//            把参数的值按照‘_’分割
            String[] ls = l.split("_");
//            创建Locale对象，第一个参数是语言代码，第二个参数是国家或地区代码
            locale = new Locale(ls[0],ls[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
