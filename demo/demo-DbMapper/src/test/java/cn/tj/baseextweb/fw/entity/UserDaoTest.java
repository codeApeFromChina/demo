package cn.tj.baseextweb.fw.entity;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.Restrictions;
import org.junit.Assert;
import org.junit.Test;

import cn.tj.baseextweb.fw.dao.GenericDao;
import cn.tj.baseextweb.fw.entity.User;
import cn.tj.baseextweb.fw.test.BaseTest;

public class UserDaoTest extends BaseTest {

    @Resource
    GenericDao userDao;

    @Test
    public void test001() {
        // clear db
        userDao.executeHql("delete from User u where u.username = ? and u.password = ?", "fnzi", "123");
        userDao.executeHql("delete from User u where u.username = ? and u.password = ?", "user001", "123");
        
        User u = new User();
        u.setUsername("fnzi");
        u.setPassword("123");
        userDao.save(u);

        // case 0
        User u0 = userDao.load(u.getUid(), User.class);
        System.out.println(u0.getUsername());

        // case 1
        List<Object[]> users = (List<Object[]>) userDao.getListBySQL("select username, password from tab_user where username = 'fnzi'");
        assertEquals(1, users.size());

        assertEquals("fnzi", users.get(0)[0]);

        // case 2
        List<User> users1 = userDao.getListByHQL("select u from User u");
        assertEquals(1, users1.size());

        assertEquals("fnzi", users1.get(0).getUsername());

        // case 3
        User u3 = userDao.getByHQL("select u from User u");
        assertEquals("fnzi", u3.getUsername());

        // case 4
        Object[] u4 = (Object[]) userDao.getBySQL("select username, password from tab_user");
        assertEquals("fnzi", u4[0]);

        // case 5
        Object u5 = (Object) userDao.getBySQL("select username from tab_user");
        assertEquals("fnzi", u5);

        User u001 = new User();
        u001.setUsername("user001");
        u001.setPassword("123");
        userDao.save(u001);

        // case 6
        Iterator<User> userIterator = userDao.getIterate("select u from User u");
        while (userIterator.hasNext()) {
            User u006 = userIterator.next();
            System.out.println(u006.getUsername());
        }

        // case 7
        Long len = userDao.countByHql("select count(u) from User u");
        assertEquals(new Long(2), len);

    }

    @Test
    public void test002() {
     // clear db
        userDao.executeHql("delete from User u where u.username = ? and u.password = ?", "fnzi", "123");
        userDao.executeHql("delete from User u where u.username = ? and u.password = ?", "user001", "123");
        
        User u = new User();
        u.setUsername("fnzi");
        u.setPassword("123");
        userDao.save(u);

        User u001 = new User();
        u001.setUsername("user001");
        u001.setPassword("123");
        userDao.save(u001);

        // case 1
        User u1 = userDao.get(u.getUid(), User.class);
        assertEquals("fnzi", u1.getUsername());

        // case 2
        List<User> users002 = userDao.createCriteria(User.class).add(Restrictions.eq("username", "fnzi")).list();
        assertEquals(1, users002.size());
        assertEquals("fnzi", users002.get(0).getUsername());

        // case 3
        User user3 = (User) userDao.createCriteria(User.class).add(Restrictions.eq("username", "fnzi")).add(Restrictions.eq("password", "123")).uniqueResult();
        assertEquals("fnzi", user3.getUsername());

        // case 4
        User pu4 = new User();
        pu4.setUsername("user001");
        pu4.setPassword("123");
        List<User> users4 = userDao.findEqualByEntity(pu4, "username", "password");
        assertEquals(1, users4.size());
        assertEquals("user001", users4.get(0).getUsername());

    }

    @Test
    public void test003() {
     // clear db
        userDao.executeHql("delete from User u where u.username = ? and u.password = ?", "fnzi", "123");
        userDao.executeHql("delete from User u where u.username = ? and u.password = ?", "user001", "123");
        
        User u = new User();
        u.setUsername("fnzi");
        u.setPassword("123");
        userDao.save(u);

        User u001 = new User();
        u001.setUsername("user001");
        u001.setPassword("123");
        userDao.save(u001);

        // case 1
        u.setUsername("fnzi123");
        userDao.update(u);

        User user1 = (User) userDao.createCriteria(User.class).add(Restrictions.eq("id", u.getUid())).uniqueResult();
        assertEquals("fnzi123", user1.getUsername());

        // case 2
        userDao.deleteById(u.getUid(), User.class);

        User user20 = (User) userDao.createCriteria(User.class).add(Restrictions.eq("id", u.getUid())).uniqueResult();
        Assert.assertNull(user20);

        User user21 = (User) userDao.createCriteria(User.class).add(Restrictions.eq("username", u.getUsername())).uniqueResult();
        Assert.assertNull(user21);

        // case 3
        userDao.delete(u001);

        User user30 = (User) userDao.createCriteria(User.class).add(Restrictions.eq("id", u001.getUid())).uniqueResult();
        Assert.assertNull(user30);

        User user31 = (User) userDao.createCriteria(User.class).add(Restrictions.eq("username", u001.getUsername())).uniqueResult();
        Assert.assertNull(user31);

    }
    
    @Test
    public void test004() {
        User u = new User();
        u.setUsername("fnzi");
        u.setPassword("123");
        userDao.save(u);
    }
}
