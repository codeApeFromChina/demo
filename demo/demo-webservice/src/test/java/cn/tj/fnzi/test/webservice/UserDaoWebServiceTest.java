package cn.tj.fnzi.test.webservice;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.tj.fnzi.its.model.User;
import cn.tj.fnzi.its.model.UserExample;
import cn.tj.fnzi.webservice.dao.IUserDaoWebService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
public class UserDaoWebServiceTest {

    @Autowired
    IUserDaoWebService userDao;

    @Test
    public void test001() {
        UserExample example = new UserExample();
        example.createCriteria().andUnameEqualTo("qwer");

        List<User> users = userDao.selectUser(example);

        System.out.println(users.size());
        for (User user : users) {
            System.out.println(user.getUid());
            System.out.println(user.getUname());
        }
    }
}
