package com.atp.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Description
 * @Author: fengxiuchuan
 * @Date : 2018/7/20 14 15
 */
public class MD5Util {

    private static Logger logger = LoggerFactory.getLogger(MD5Util.class);

    private MD5Util() {
    }

    /**
     * MD5加密，返回非null值表示加密成功，否则失败。
     *
     * @param str
     *            原文（明文）
     * @return
     * @author fengxiuchuan
     */
    public static String encrypt(final String str) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            logger.error("MD5初始化失败。", e);
        }
        if (md5 == null) {
            return null;
        } else {
            return new BigInteger(1, md5.digest(str.getBytes())).toString(16).toUpperCase();
        }

    }
}
