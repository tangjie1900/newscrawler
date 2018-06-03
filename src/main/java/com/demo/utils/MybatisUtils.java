package com.demo.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {

    static {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            isInitSuccess = true;
        } catch (IOException ex) {
            isInitSuccess = false;
        }
    }

    private static boolean isInitSuccess = false;

    public static boolean isIsInitSuccess() {
        return isInitSuccess;
    }

    


}
