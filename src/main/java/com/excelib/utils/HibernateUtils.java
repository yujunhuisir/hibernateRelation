package com.excelib.utils;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	
    private static SessionFactory sessionFactory;
    private static Session session;

    private HibernateUtils(){
    }

//    交给Spring管理后, 不需要进行hibernate的sessionFactory的管理
//    否则用一下的代码对hibernate进行初始化
    static {
        Configuration cfg = new Configuration().configure("hibernate.xml");
        sessionFactory = cfg.buildSessionFactory();
    }

    /**
     * 获取数据库Session对象
     */
    public static Session getSession(){
        //如果当前线程有session则返回该session
        //如果没有则创建，且自动关闭session，必须要代码中显式关闭session
        return sessionFactory.openSession();
    }

    /**
     * 关闭数据库Session对象
     */
    public static void closeSession(){
        if (session != null && session.isOpen())
            session.close();
    }

    /***
     * 关闭传入的数据库Session对象
     */
    public static void closeSession(Session session){
        if (session != null && session.isOpen())
            session.close();
    }

    /**
     * 关闭整个hibernate的sessionFactory
     */
    public static void close(){
        if(sessionFactory !=null)
            sessionFactory.close();
    }

}
