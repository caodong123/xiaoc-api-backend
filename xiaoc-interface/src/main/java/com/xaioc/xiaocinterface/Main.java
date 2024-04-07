package com.xaioc.xiaocinterface;

import com.xaioc.xiaocinterface.client.XiaocClient;
import com.xaioc.xiaocinterface.model.User;

public class Main {
    public static void main(String[] args) {
        XiaocClient client = new XiaocClient("caodong","abcdefg");
        String res1 = client.getNameByGet("XiaoC");
        System.out.println(res1);

        String res2 = client.getNameByPost("曹栋");
        System.out.println(res2);

        User user = new User();
        user.setName("zhangsan");
        String res3 = client.getUsernameByPost(user);
        System.out.println(res3);
    }
}
