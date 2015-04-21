package cn.tj.fnzi.its.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.tj.fnzi.its.model.User;
import cn.tj.fnzi.its.model.UserExample;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class UserDaoTest {

    @Autowired
    UserMapper userDao;

    @Test
    public void test001() {

        List<User> users = userDao.selectByExample(new UserExample());

        System.out.println(users.size());
        for (User user : users) {
            System.out.println(user.getUid());
            System.out.println(user.getUname());
        }
    }

    @Test
    public void test002() {

        User u = new User();

        u.setUname("qwer");
        u.setPassword("qwer");
        u.setAddress("tj");

        userDao.insert(u);
    }

    // @Test
    // public void test004() {
    //
    // AddUserThread addUser1 = new AddUserThread("t_1", userDao);
    // AddUserThread addUser2 = new AddUserThread("t_2", userDao);
    // AddUserThread addUser3 = new AddUserThread("t_3", userDao);
    //
    // addUser1.start();
    // addUser2.start();
    // addUser3.start();
    //
    // try {
    // Thread.sleep(1000 * 60 * 1);
    // } catch (InterruptedException e) {
    // e.printStackTrace();
    // }
    // }

    // class AddUserThread extends Thread {
    // private int ticket = 10;
    // String name;
    // UserMapper service;
    //
    // AddUserThread(String name, UserMapper service) {
    // super(name);
    // this.name = name;
    // this.service = service;
    // }
    //
    // public void run() {
    // while (ticket > 0) {
    // synchronized (service) {
    // User u = new User();
    // u.setUname("qwer_" + ticket);
    // u.setPassword("123");
    //
    // UserExample example = new UserExample();
    // UserExample.Criteria criteria = example.createCriteria();
    // criteria.andUnameEqualTo(u.getUname());
    // criteria.andPasswordEqualTo(u.getPassword());
    //
    // List<User> list = service.selectByExample(example);
    //
    // if (list != null && list.size() > 0) {
    // System.out.println(name + "_不准许插入： " + ticket);
    // } else {
    // System.out.println(name + "_准许插入： " + ticket);
    // service.insert(u);
    // }
    //
    // ticket--;
    // }
    // }
    // // User u = new User();
    // // u.setUname("qwer123234");
    // //
    // // this.service.insert(u);
    // // System.out.println("00000------");
    // }
    // }
}