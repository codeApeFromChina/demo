package cn.tj.baseextweb.fw.data;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcUtils extends JdbcDaoSupport {

    private static JdbcUtils instance;

    private JdbcUtils() {
    }

    public static JdbcUtils newInstance() {
        if (instance == null) {
            instance = new JdbcUtils();
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://172.16.4.115:3306/monitorsystem");
            dataSource.setUsername("root");
            dataSource.setPassword("123456");

            instance.setDataSource(dataSource);
        }
        return instance;
    }
}
