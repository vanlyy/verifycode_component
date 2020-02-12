package com.how2java;
 
import java.io.IOException;
import java.io.InputStream;
 
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
 
import com.how2java.pojo.Category;
 
public class TestMybatis {
 
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session1 = sqlSessionFactory.openSession();
 
        Category c1 = session1.selectOne("getCategory", 6);
        System.out.println(c1);
        Category c2 = session1.selectOne("getCategory", 6);
        System.out.println(c2);
 
        session1.commit();
        session1.close();
         
        SqlSession session2 = sqlSessionFactory.openSession();
        Category c3 = session2.selectOne("getCategory", 6);
        System.out.println(c3);    
        session2.commit();
        session2.close();
         
    }
 
}