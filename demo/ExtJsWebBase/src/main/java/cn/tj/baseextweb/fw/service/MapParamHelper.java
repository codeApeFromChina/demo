package cn.tj.baseextweb.fw.service;

import java.util.Map;

import cn.tj.baseextweb.fw.action.ActionSupport;

public class MapParamHelper {

    protected static final String SESSION_KEY = ActionSupport.SESSION_KEY;
    
    protected <P> P getParam(Map<String, Object> param, String key) {
        return (P) param.get(key);
    }
}
