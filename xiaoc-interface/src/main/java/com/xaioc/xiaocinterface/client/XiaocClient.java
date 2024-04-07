package com.xaioc.xiaocinterface.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.xaioc.xiaocinterface.model.User;
import com.xaioc.xiaocinterface.utils.SignUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class XiaocClient {

    private String accessKey;
    private String secretKey;

    public XiaocClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public String getNameByGet(String name){
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result= HttpUtil.get("http://localhost:8123/api/name/", paramMap);
        return result;
    }

    public String getNameByPost(String name){
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result= HttpUtil.post("http://localhost:8123/api/name/", paramMap);
        return result;
    }

    /**
     * 获取请求头
     * @return
     */
    private Map<String,String> getHeader(String body){
        HashMap<String, String> map = new HashMap<>();
        map.put("accessKey",accessKey);
        map.put("secretKey",secretKey);
//        随机数 四位数
        map.put("nonce", RandomUtil.randomNumbers(4));
//        请求体
        map.put("body",body);
//        时间戳
        map.put("timestamp", String.valueOf(System.currentTimeMillis()/1000));
//        签名
        String genSign = SignUtils.genSign(body, secretKey);
        map.put("sign",genSign);
        return map;
    }

    public String getUsernameByPost(User user){
        String json = JSONUtil.toJsonStr(user);
        HttpResponse response = HttpRequest.post("http://localhost:8123/api/name/user")
                .body(json)
                .addHeaders(getHeader(json))   //添加请求头
                .execute();
        System.out.println(response.getStatus());
        return response.body();
    }
}
