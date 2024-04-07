package com.xaioc.xiaocinterface.utils;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;



/**
 * 生成签名
 */
public class SignUtils {
    public static String genSign(String body,String secretKry){
        Digester md5 = new Digester(DigestAlgorithm.SHA256);
        //用数据和secretKey拼接
        String str=body+"."+secretKry;
       return md5.digestHex(str);
    }
}
