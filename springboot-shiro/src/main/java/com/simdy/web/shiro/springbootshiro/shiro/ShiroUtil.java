package com.simdy.web.shiro.springbootshiro.shiro;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.StringUtils;

import java.util.Random;

/**
 * @Author: Simdy
 * @Date: Created on 2020/1/21 9:09
 * @Version: 0.0.1
 * @Modified By:
 * @Description:
 */
public class ShiroUtil {

    private static final String NAMES_DELIMETER = ",";

    /**

     加盐参数
     */
    public final static String hashAlgorithmName = "MD5";
    /**

     循环次数
     */
    public final static int hashIterations = 1024;

    /**
     shiro密码加密工具类
     @param credentials 密码
     @param saltSource 密码盐
     @return
     */
    public static String md5(String credentials, String saltSource) {
        ByteSource salt = new Md5Hash(saltSource);
        return new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations).toString();
    }

    /**
     获取随机盐值
     @param length
     @return
     */
    public static String getRandomSalt(int length){
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(3);
            long result=0;
            switch(number){
                case 0:
                    result=Math.round(Math.random()*25+65);
                    sb.append(String.valueOf((char)result));
                    break;
                case 1:
                    result=Math.round(Math.random()*25+97);
                    sb.append(String.valueOf((char)result));
                    break;
                case 2:
                    sb.append(String.valueOf(new Random().nextInt(10)));
                    break;
            }


        }
        return sb.toString();
    }

}
