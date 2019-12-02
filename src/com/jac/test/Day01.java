package com.jac.test;

import com.jac.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.tools.ant.types.Resource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

public class Day01 {
    SqlSession sqlSession;
    @Before
    public void before() throws IOException {
        //      读取配置文件
        InputStream inputStream= Resources.getResourceAsStream("SqlMapConfig.xml");
//      通过SqlSessionFactoryBuilder创建SqlSessionFactory会话工厂
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(inputStream);
//      通过SqlSessionFactory创建SqlSession
        sqlSession = ssf.openSession();
    }
    @After
    public void after(){
        //      关闭会话
//        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test1() {

//      调用SqlSession的操作数据库方法
        User user = sqlSession.selectOne("findUserByName1", "张三");
        System.out.println(user);

//        List<User> users = sqlSession.selectList("findUserByName", "张");
//        users.forEach(user-> System.out.println(user));


    }
    @Test
    public void test2(){
        User user = new User("xiaoming",new Date(), "1",  "河南");
        sqlSession.insert("insertUser",user);
    }
    @Test
    public void test3(){
        sqlSession.delete("deleteUser","xiaoming");
    }
    @Test
    public void test4(){
        User user = new User();
        user.setId(38);
        user.setAddress("盐城");
        user.setSex("m");
        sqlSession.update("updateUser",user);
    }
    @Test
    public void test5(){
        User user = new User("xiaoming",new Date(), "1",  "河南");
        sqlSession.insert("insertUser",user);
        sqlSession.commit();
        System.out.println(user.getId());
    }
    @Test
    public void test6(){
//        sqlSession.getMapper(BlogMapper.class);
    }
}
