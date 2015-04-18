package cn.tj.baseextweb.fw.helper;

import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

//import cn.tj.baseextweb.fw.util.Base64Util;

/**
 * @author 闫世峰
 * 
 */
public class PropertyConfigurer extends PropertyPlaceholderConfigurer {

    /** 需要解密处理的属性 */
    private String keyWord = ".enc";

    protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props) throws BeansException {

        for (Object key : props.keySet()) {
            String property = key.toString();
            if (property.endsWith(keyWord)) {
                String var = props.getProperty(property);
                if (var != null) {
                    //String strDes = Base64Util.dec(var);
                    //props.setProperty(property, strDes);
//                    props.setProperty(replaceEnc(property), strDes);
                }
            }
        }

        super.processProperties(beanFactory, props);
    }

    protected String resolvePlaceholder(String placeholder, Properties props) {
        String prop = null;
        prop = props.getProperty(placeholder);
        return prop;
    }

    private String replaceEnc(String property) {
        property = property.replace(keyWord, "");
        return property;
    }
}
