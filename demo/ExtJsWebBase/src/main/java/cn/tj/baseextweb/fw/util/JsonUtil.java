package cn.tj.baseextweb.fw.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
    private static ObjectMapper mapper;

    /**
     * <pre>
     * 获取ObjectMapper实例
     * @param createNew 方式：true，新实例；false,存在的mapper实例
     * @return
     * </pre>
     */
    public static synchronized ObjectMapper getMapperInstance(boolean createNew) {
        if (createNew) {
            return new ObjectMapper();
        } else if (mapper == null) {
            mapper = new ObjectMapper();
        }
        return mapper;
    }

    /**
     * <pre>
     * 将java对象转换成json字符串
     * @param obj准备转换的对象
     * @return json字符串
     * @throws Exception
     * </pre>
     */
    public static String beanToJson(Object obj) throws Exception {
        try {
            ObjectMapper objectMapper = getMapperInstance(false);
            String json = objectMapper.writeValueAsString(obj);
            return json;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     * <pre>
     * 将java对象转换成json字符串
     * @param obj 准备转换的对象
     * @param createNew ObjectMapper实例方式:true，新实例;false,存在的mapper实例
     * @return json字符串
     * @throws Exception
     * </pre>
     */
    public static String beanToJson(Object obj, Boolean createNew) throws Exception {
        try {
            ObjectMapper objectMapper = getMapperInstance(createNew);
            String json = objectMapper.writeValueAsString(obj);
            return json;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     * <pre>
     * 将json字符串转换成java对象
     * @param json 准备转换的json字符串
     * @param cls 准备转换的类
     * @return
     * @throws Exception
     * </pre>
     */
    public static <T> T jsonToBean(String json, Class<T> cls) throws Exception {
        try {
            ObjectMapper objectMapper = getMapperInstance(false);
            T vo = objectMapper.readValue(json, cls);
            return vo;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     * <pre>
     * 将json字符串转换成java对象
     * @param json准备转换的json字符串
     * @param cls准备转换的类
     * @param createNewObjectMapper实例方式:true，新实例;false,存在的mapper实例
     * @return
     * @throws Exception
     * 
     * <pre>
     */
    public static <T> T jsonToBean(String json, Class<T> cls, Boolean createNew) throws Exception {
        try {
            ObjectMapper objectMapper = getMapperInstance(createNew);
            T vo = objectMapper.readValue(json, cls);
            return vo;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}