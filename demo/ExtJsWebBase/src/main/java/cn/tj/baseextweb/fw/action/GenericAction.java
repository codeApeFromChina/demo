package cn.tj.baseextweb.fw.action;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tj.baseextweb.fw.helper.LogUtil;
import cn.tj.baseextweb.fw.helper.SpringUtil;
import cn.tj.baseextweb.fw.service.ExtService;
import cn.tj.baseextweb.fw.util.JsonUtil;

@Controller
public class GenericAction extends ActionSupport {

    private String module = GenericAction.class.getName();

    @RequestMapping("/doJson/{serviceName}")
    public void doJsonService(@PathVariable String serviceName, HttpServletResponse response) {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();

            Map<String, Object> param = getRequstMap();

            ExtService<?> service = (ExtService<?>) SpringUtil.getBean(serviceName);
            Object ret = service.execute(param);
            String retJson = JsonUtil.beanToJson(ret);

            out.print(retJson);
            out.flush();
        } catch (Exception e) {
            LogUtil.logError(e.getMessage(), module, e);
        }
    }

    @RequestMapping("/toPage/{pageName}")
    public String toPage(@PathVariable String pageName) {

        /**
         * 请不要使用"_"作为jsp文件的名字
         */
        if (pageName.contains("_")) {
            pageName = pageName.replaceAll("_", "/");
        }

        return pageName;
    }

    // @RequestMapping("/toPage/{pageName:.*}")
    // public String toPage(@PathVariable String pageName) {
    //
    // System.out.println(pageName);
    //
    // return pageName;
    // }
}
