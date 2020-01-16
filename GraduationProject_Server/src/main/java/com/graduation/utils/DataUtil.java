package com.graduation.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DataUtil {

    private static final Logger logger = LoggerFactory.getLogger(DataUtil.class);

    private DataUtil() {}

    /**
     * Date类型转String类型
     * @param date
     * @return
     */
    public static String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return sdf.format(date);
    }

    /**
     * String类型转Date类型
     * @param strDate
     * @return
     */
    public static Date parse(String strDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.parse(strDate);
    }

    /**
     * 返回String类型的系统时间
     * @return
     */
    public static String currentDateStr() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return sdf.format(new Date());
    }

    /**
     * 标准时间转北京时间
     * @param dataStr
     * @return
     */
    public static Date transform(String dataStr) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSSZ");
        Date date = null;
        try {
            date = df.parse(dataStr);
        } catch (ParseException e) {
            logger.error("转换时间错误", e);
        }
        return date;
    }
}
