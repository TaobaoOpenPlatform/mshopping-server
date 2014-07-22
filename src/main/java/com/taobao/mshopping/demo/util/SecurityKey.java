package com.taobao.mshopping.demo.util;

import com.taobao.mshopping.demo.constant.MshoppingConstant;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <p>利用AppKey等信息生成安全密钥，用户服务端验证身份</p>
 * User: <a href="mailto:xinyuan.ymm@alibaba-inc.com">心远</a>
 * Date: 14/7/22
 * Time: 下午4:26
 */
public class SecurityKey {

    public static String getKey() {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            String origin = MshoppingConstant.APP_KEY.concat(MshoppingConstant.APP_SECRET);
            md5.update(origin.getBytes());
            byte[] m = md5.digest();//加密
            return getString(m);
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }

    private static String getString(byte[] b) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            sb.append(b[i]);
        }
        return sb.toString();
    }
}
