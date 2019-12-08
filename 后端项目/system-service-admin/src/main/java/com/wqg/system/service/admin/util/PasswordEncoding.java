package com.wqg.system.service.admin.util;

import org.apache.commons.codec.binary.Base64;

/*
* 自定义编码解码类
* */
public  class PasswordEncoding {
    /**
     * Base64加密
     * @param password 明文密码
     * @return String
     */
    public static String Base64encode(String password) {
        byte[] bytes = Base64.encodeBase64(password.getBytes(), true);
        return new String(bytes);
    }
    /**
     * Base64解密
     * @param enPassword 密钥
     * @return String
     */
    public static String Base64decode(String enPassword) {
        byte[] bytes = Base64.decodeBase64(enPassword.getBytes());
        return new String(bytes);
    }
}
