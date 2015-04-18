package cn.tj.baseextweb.fw.service;

import java.util.Map;

import javax.annotation.Resource;

//import cn.tj.baseextweb.fw.dao.GenericDao;

public abstract class ExtService<R> extends MapParamHelper implements GenericService<Map<String, Object>, R> {

    protected String module = ExtService.class.getName();

//    @Resource
//    private GenericDao dao;
//
//    protected GenericDao getDao() {
//        return dao;
//    }

    public abstract R execute(Map<String, Object> param);

}
