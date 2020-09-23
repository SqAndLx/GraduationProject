package com.shiqing.myshiro.utils;

import org.apache.commons.lang.StringUtils;

public class HttpUtil {

    public static String getURlFirstParagraph(String url){
        if (!StringUtils.isEmpty(url)) {
            String[] split = url.split("/");
            return split[1];
        }
        return url;
    }
}
