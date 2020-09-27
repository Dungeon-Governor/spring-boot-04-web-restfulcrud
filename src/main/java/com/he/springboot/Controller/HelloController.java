package com.he.springboot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String Hello(){
        return "Hello World";
    }

    @RequestMapping("/success")
    public String Success(Map<String,Object> map){
        map.put("success","成功");
        return "success";
    }

}
