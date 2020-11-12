package net.xdclass.online_xdclass.utils;

import java.security.MessageDigest;

/**
 * MD5加密工具类
 *
 * @author suning
 */
public class Md5Utils {
    public static String Md5(String data) {
        try {
            java.security.MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(data.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte item : array) {
                sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString().toUpperCase();
        } catch (Exception e) {
            //todo:异常处理
            e.printStackTrace();
        }
        return null;
    }

}
