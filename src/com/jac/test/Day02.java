package com.jac.test;

import com.jac.mapper.UserMapper;
import com.jac.model.User;
import com.jac.model.User_order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Day02 {
    SqlSession sqlSession;
    UserMapper mapper;
    @Before
    public void before() throws IOException {
        //      读取配置文件
        InputStream inputStream= Resources.getResourceAsStream("SqlMapConfig.xml");
//      通过SqlSessionFactoryBuilder创建SqlSessionFactory会话工厂
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(inputStream);
//      通过SqlSessionFactory创建SqlSession
        sqlSession = ssf.openSession();
        mapper = sqlSession.getMapper(UserMapper.class);
    }
    @After
    public void after(){
        //      关闭会话
//        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void test1(){
        User user=sqlSession.selectOne("selectUser",1);
        System.out.println(user);
    }
    @Test
    public void test2(){
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findById(1);
        System.out.println(user);
    }
    @Test
    public void test3(){
        User user = new User();
        user.setUsername("张");
        List<User> 张 = mapper.findByName(user);
        张.forEach(System.out::println);
    }
    @Test
    public void test4(){
        User user = new User();
        user.setId(1);
        User byUserId = mapper.findByUserId(new User_order(user));
        System.out.println(byUserId);
    }
    @Test
    public void test5(){
        User user = new User();
//        user.setSex("1");
        user.setUsername("王");
        List<User> users = mapper.findByAny(user);
        users.forEach(user1 -> System.out.println(user1));
    }
}
