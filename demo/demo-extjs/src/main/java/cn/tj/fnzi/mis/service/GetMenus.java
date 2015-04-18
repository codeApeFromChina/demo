package cn.tj.fnzi.mis.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import cn.tj.baseextweb.fw.service.ListService;

@Service("getMenus")
public class GetMenus extends ListService<MenuBean> {

    @Override
    public List<MenuBean> doExecute(Map<String, Object> param) {

        List<MenuBean> menuBeans = new ArrayList<MenuBean>();

        String node = (String) param.get("node");

        if (node.equals("1")) {
            MenuBean menuBean11 = new MenuBean();
            menuBean11.setId(11);
            menuBean11.setLeaf(0);
            menuBean11.setMenuParentId(1);
            menuBean11.setMenuUrl("/");
            menuBean11.setText("功能");
            menuBean11.setMenuIcon("");
            menuBeans.add(menuBean11);

            MenuBean menuBean13 = new MenuBean();
            menuBean13.setId(13);
            menuBean13.setLeaf(0);
            menuBean13.setMenuParentId(1);
            menuBean13.setMenuUrl("/");
            menuBean13.setText("系统维护");
            menuBean13.setMenuIcon("");
            menuBeans.add(menuBean13);

            MenuBean menuBean14 = new MenuBean();
            menuBean14.setId(14);
            menuBean14.setLeaf(1);
            menuBean14.setMenuParentId(1);
            menuBean14.setMenuUrl("toPage/search.do");
            menuBean14.setText("综合查询");
            menuBean14.setMenuIcon("job");
            menuBeans.add(menuBean14);

            MenuBean menuBean15 = new MenuBean();
            menuBean15.setId(15);
            menuBean15.setLeaf(1);
            menuBean15.setMenuParentId(1);
            menuBean15.setMenuUrl("toPage/print.do");
            menuBean15.setText("报表打印");
            menuBean15.setMenuIcon("job");
            menuBeans.add(menuBean15);
        }

        if (node.equals("11")) {
            MenuBean menuBean111 = new MenuBean();
            menuBean111.setId(111);
            menuBean111.setLeaf(0);
            menuBean111.setMenuParentId(1);
            menuBean111.setMenuUrl("");
            menuBean111.setText("功能1");
            menuBean111.setMenuIcon("");
            menuBeans.add(menuBean111);

            MenuBean menuBean112 = new MenuBean();
            menuBean112.setId(112);
            menuBean112.setLeaf(0);
            menuBean112.setMenuParentId(1);
            menuBean112.setMenuUrl("");
            menuBean112.setText("功能2");
            menuBean112.setMenuIcon("");
            menuBeans.add(menuBean112);

            MenuBean menuBean113 = new MenuBean();
            menuBean113.setId(113);
            menuBean113.setLeaf(0);
            menuBean113.setMenuParentId(1);
            menuBean113.setMenuUrl("");
            menuBean113.setText("功能3");
            menuBean113.setMenuIcon("");
            menuBeans.add(menuBean113);
        }

        if (node.equals("13")) {

            MenuBean menuBean132 = new MenuBean();
            menuBean132.setId(132);
            menuBean132.setLeaf(1);
            menuBean132.setMenuParentId(1);
            menuBean132.setMenuUrl("toPage/userInfo.do");
            menuBean132.setText("用户管理");
            menuBean132.setMenuIcon("job");
            menuBeans.add(menuBean132);

        }

        if (node.equals("111")) {
            MenuBean menuBean1111 = new MenuBean();
            menuBean1111.setId(1111);
            menuBean1111.setLeaf(1);
            menuBean1111.setMenuParentId(1);
            menuBean1111.setMenuUrl("toPage/function.do");
            menuBean1111.setText("功能");
            menuBean1111.setMenuIcon("job");
            menuBeans.add(menuBean1111);
        }

        if (node.equals("112")) {
            MenuBean menuBean1121 = new MenuBean();
            menuBean1121.setId(1121);
            menuBean1121.setLeaf(1);
            menuBean1121.setMenuParentId(1);
            menuBean1121.setMenuUrl("toPage/function.do");
            menuBean1121.setText("功能");
            menuBean1121.setMenuIcon("job");
            menuBeans.add(menuBean1121);
        }

        if (node.equals("113")) {
            MenuBean menuBean1131 = new MenuBean();
            menuBean1131.setId(1131);
            menuBean1131.setLeaf(1);
            menuBean1131.setMenuParentId(1);
            menuBean1131.setMenuUrl("toPage/function.do");
            menuBean1131.setText("功能");
            menuBean1131.setMenuIcon("job");
            menuBeans.add(menuBean1131);
        }

        return menuBeans;
    }

}
