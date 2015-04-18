package cn.tj.fnzi.mis.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import cn.tj.baseextweb.fw.bean.GridList;
import cn.tj.baseextweb.fw.service.GridListService;

@Service("getUsers")
public class GetUsers extends GridListService<User> {

    @Override
    public GridList<User> doExecute(Map<String, Object> param) {
        GridList<User> grid = new GridList<User>();

        List<User> users = new ArrayList<User>();
        User u1 = new User();
        u1.setUserId(1);
        u1.setUserName("qwrt");
        u1.setUserRemark("123");
        u1.setUserDate("2015-01-01");
        users.add(u1);
        User u2 = new User();
        u2.setUserId(2);
        u2.setUserName("qwrt1");
        u2.setUserRemark("1232");
        u2.setUserDate("2015-01-01");
        users.add(u2);

        grid.setData(users);
        grid.setTotal(users.size());
        return grid;
    }
}
