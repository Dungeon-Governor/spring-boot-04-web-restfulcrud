package com.he.springboot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

//    @PostMapping就是接收Post请求的@RequestMapping
    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Map<String,Object> map, HttpSession session){
        if(!StringUtils.isEmpty(username) && "123".equals(password)){
//            向session中添加用户名，用来判断是否登陆和显示用户名
            session.setAttribute("username",username);
//            防止表单重复提交和样式路径问题，使用重定向
            return "redirect:/main.html";
        }
//        添加登陆失败信息
        map.put("info","登陆失败");
        return "login";
    }

}
