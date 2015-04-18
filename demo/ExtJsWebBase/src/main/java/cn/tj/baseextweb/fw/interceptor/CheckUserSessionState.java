package cn.tj.baseextweb.fw.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class CheckUserSessionState extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        String path = request.getServletPath();
//        if (path.matches(Const.INTERCEPTOR_PATH) && !path.matches(Const.NO_INTERCEPTOR_PATH)) {
//
//            HttpSession session = request.getSession();
//            User user = (User) session.getAttribute(Const.USER_KEY);
//            if (user != null) {
//                return true;
//            } else {
//                response.sendRedirect(request.getContextPath() + "/timeout.jsp");
//                return false;
//            }
//        } else {
            return true;
//        }
    }

}
