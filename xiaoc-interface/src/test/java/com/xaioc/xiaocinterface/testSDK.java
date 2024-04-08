package com.xaioc.xiaocinterface;


import com.xiaoc.sdktest.client.XiaoCClient;

import com.xiaoc.sdktest.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class testSDK {

    @Resource
    private XiaoCClient xiaoCClient;

    @Test
    public void test(){

        String res1 = xiaoCClient.getNameByGet("XiaoC");
        System.out.println(res1);

        String res2 = xiaoCClient.getNameByPost("曹栋");
        System.out.println(res2);

        User user = new User();
        user.setName("zhangsan");
        String res3 = xiaoCClient.getUsernameByPost(user);
        System.out.println(res3);
    }

}
