package com.xiaoc.sdktest;

import com.xiaoc.sdktest.client.XiaoCClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;

@SpringBootTest
public class test {
    @Resource
    XiaoCClient xiaoCClient;

    @Test
    void test(){
        String res = xiaoCClient.test();
        System.out.println(res);
    }
}
