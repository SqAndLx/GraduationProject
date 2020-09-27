package com.shiqing.myshiro.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * md5工具类
 * @author
 */
public class Md5Util {

    /**
     * 生成加密后的密码
     * @param str
     * @param salt
     * @return
     */
    private static String getMd5Str(String str,String salt){
        Md5Hash md5Hash = new Md5Hash(str,salt,2048);
        System.out.println("str = [" + str + "], salt = [" + salt + "],最后的散列结果是："+ md5Hash);
        return  md5Hash.toHex();
    }

    public static void main(String[] args) {
        getMd5Str("666","李四");
    }
}
