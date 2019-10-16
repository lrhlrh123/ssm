package com.gyf.test;

import com.gyf.mapper.OrderMapper;
import com.gyf.mapper.UserMapper;
import com.gyf.model.Order;
import com.gyf.model.OrderDetail;
import com.gyf.model.OrderExt;
import com.gyf.model.User;
import com.gyf.vo.UserQueryVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo01 {
    SqlSession sqlSession;

    @Before
    public void Before() throws IOException {
        //        a)	读取配置文件；
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
//        b)	通过SqlSessionFactoryBuilder创建SqlSessionFactory会话工厂。
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
//        c)	通过SqlSessionFactory创建SqlSession。
        sqlSession = sqlSessionFactory.openSession();
        System.out.println("开启sqlSession");
    }

    @After
    public void After() {
        //        e)	关闭SqlSession。
        sqlSession.close();
        System.out.println("关闭sqlSession");
    }

    @Test
    public void test1() throws IOException {
        //保存数据
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserQueryVO query=new UserQueryVO();
        User user=new User();
        user.setSex("1");
        query.setUser(user);
        int count = userMapper.findUserCount(query);
        System.out.println(count);
    }
    @Test
    public void test2() throws IOException {
        //保存数据
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> user = userMapper.findUserByIdResultMap(1);
        System.out.println(user);
    }
    @Test
    public void test3() throws IOException {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserQueryVO query=new UserQueryVO();
        User user =new User();
        user.setSex("1");
        user.setUsername("张");
        query.setUser(user);
        List<User> count = userMapper.findUserList(query);
        System.out.println(count);
    }
    @Test
    public void test4() throws IOException {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserQueryVO query=new UserQueryVO();
        List<Integer>ids= new ArrayList<>();
        ids.add(1);
        ids.add(10);
        ids.add(16);
        query.setIds(ids);
        List<User> users = userMapper.findUserByIds(query);
        System.out.println(users);
    }
    @Test
    public void test5() throws IOException {
        OrderMapper mapper=sqlSession.getMapper(OrderMapper.class);
        OrderExt orderById = mapper.findOrderById(3);
        System.out.println(orderById);
    }
    @Test
    public void test6() throws IOException {
        OrderMapper mapper=sqlSession.getMapper(OrderMapper.class);
        Order orderById2 = mapper.findOrderById2(3);
        System.out.println(orderById2);
    }
    @Test
    public void test7() throws IOException {
        OrderMapper mapper=sqlSession.getMapper(OrderMapper.class);
        Order order = mapper.findOrderById3(3);
        System.out.println(order);
    }
    @Test
    public void test8() throws IOException {
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.findUserAndOrderInfo();
        for (User user:users ){
            System.out.println("用户信息："+user);
            for (Order order:user.getOrderList()) {
                System.out.println("订单信息：" + order);
                System.out.println("订单详情：" );
                for (OrderDetail orderDetail : order.getOrderDetails()) {
                    System.out.println(orderDetail+":"+orderDetail.getItems());
                }
                System.out.println("=======================================");
            }
        }
    }



}
