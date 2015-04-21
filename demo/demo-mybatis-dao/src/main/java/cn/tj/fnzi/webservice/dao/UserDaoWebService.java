package cn.tj.fnzi.webservice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.tj.fnzi.its.dao.UserMapper;
import cn.tj.fnzi.its.model.User;
import cn.tj.fnzi.its.model.UserExample;

public class UserDaoWebService implements IUserDaoWebService {

    @Autowired
    UserMapper dao;

    @Override
    public List<User> selectUser(UserExample example) {
        return dao.selectByExample(example);
    }

    public void setDao(UserMapper dao) {
        this.dao = dao;
    }

}
