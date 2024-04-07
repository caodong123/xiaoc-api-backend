package com.xaioc.xiaocinterface.controller;

import com.xaioc.xiaocinterface.model.User;
import com.xaioc.xiaocinterface.utils.SignUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/name")
public class NameController {

    @GetMapping("/")
    public String getNameByGet(String name){
        return "Get 你的名字是"+name;
    }

    @PostMapping("/")
    public String getNameByPost(@RequestParam String name){
        return "Post 你的名字是"+name;
    }

    @PostMapping("/user")
    public String getUsernameByPost(@RequestBody User user, HttpServletRequest request){
//        1 在请求头中获取参数
        String accessKey = request.getHeader("accessKey");
        String nonce = request.getHeader("nonce");
        String timestamp = request.getHeader("timestamp");
        String body = request.getHeader("body");
        String sign = request.getHeader("sign");
//       2 进行校验  应该查询数据库
        if(!accessKey.equals("caodong")){
            throw new RuntimeException("无权限");
        }
//       3 nonce判断
        if(Long.parseLong(nonce)>10000){
            throw new RuntimeException("无权限");
        }
//       4  时间戳判断
        //判断距离现在的时间即可

//        5生成签名  需要在数据库中查出来secretKey
        String genSign = SignUtils.genSign(body, "abcdefg");
        if(!genSign.equals(sign)){
            throw new RuntimeException("无权限");
        }

        return "Post 用户名字是"+user.getName();
    }


}
