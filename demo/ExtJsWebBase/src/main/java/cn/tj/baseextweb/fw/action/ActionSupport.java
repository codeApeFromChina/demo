package cn.tj.baseextweb.fw.action;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.tj.baseextweb.fw.bean.ResultMap;

public class ActionSupport {

  public static final String SESSION_KEY = "__session_key__";
  
  public void setModelMap(ResultMap result, ModelMap model) {
    for (String key : result.keySet()) {
      model.addAttribute(key, result.get(key));
    }
  }

  public Map<String, Object> getRequstMap() {
    Map<String, Object> map = new HashMap<String, Object>();
    Enumeration<String> _enum = this.getRequest().getParameterNames();
    while (_enum.hasMoreElements()) {
      String paramName = (String) _enum.nextElement();
      String paramValue = this.getRequest().getParameter(paramName);

      // 形成键值对应的map
      map.put(paramName, paramValue);
    }
    map.put(SESSION_KEY, getSession());
    return map;
  }

  /**
   * 获取session
   * 
   * @return 返回session
   */
  public HttpSession getSession() {

    return getRequest().getSession();
  }

  /**
   * 向session中添加值
   * 
   * @param key 主键
   * @param value 值
   */
  public void setSession(String key, Object value) {
    getRequest().getSession().setAttribute(key, value);
  }

  /**
   * 在session中获取值
   * 
   * @param key 主键
   * @return 返回值
   */
  public Object getSessionValue(String key) {
    return getRequest().getSession().getAttribute(key);
  }

  /**
   * 获取request
   * 
   * @return 返回request
   */
  public HttpServletRequest getRequest() {
    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
        .getRequestAttributes()).getRequest();
    return request;
  }

  /**
   * 获取根目录
   * 
   * @return 返回根目录
   */
  public String getRealPath() {
    return getSession().getServletContext().getRealPath("/");
  }

}
