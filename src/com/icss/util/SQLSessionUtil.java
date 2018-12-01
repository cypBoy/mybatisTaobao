package com.icss.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SQLSessionUtil {

    private static SqlSessionFactory  factory=null;
    // static
    static Reader read=null;

    static{
        String config="mybatis-config.xml";
        try {
            read= Resources.getResourceAsReader(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return
     * 单例设计模式，只得到一个工厂对象
     */
    private static  SqlSessionFactory  getSqlSessionFacory(){
        if(factory==null){
            factory =new SqlSessionFactoryBuilder().build(read);
        }
        return factory;
    }


    /***
     *  封装一个得到 SqlSession的对象
     *
     */

    public  static  SqlSession getSqlSession(){
        return getSqlSessionFacory().openSession();
    }

}
