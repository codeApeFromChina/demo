package cn.tj.fnzi.webservice.dao;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import cn.tj.fnzi.its.model.User;
import cn.tj.fnzi.its.model.UserExample;

@WebService
public interface IUserDaoWebService {
    @WebMethod
    public List<User> selectUser(@WebParam(name = "example") UserExample example);
}
