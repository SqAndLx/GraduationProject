package com.graduation.utils;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.UUID;

public final class UserUtil {
	
	private UserUtil() {}
	/**
	 * 
	 * @Description: 从session中获取当前用户Id
	 * @return 用户Id
	 */
	public static String getCurrentUserId() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		String userid = (String) request.getSession().getAttribute("id");
        if (userid == null) {
            return StringUtils.EMPTY;
        }
        return userid;
	}

	/**
	 * 生成32位uuid
	 * @return
	 */
	public static String getUUID(){
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replace("-", "");
		return uuid;
	}
}
