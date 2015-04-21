package cn.tj.baseextweb.fw.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;

public interface GenericDao {

    /**
     * <pre>
     * <保存实体>
     * <完整保存实体>
     * @param t 实体参数
     * </pre>
     */
    public abstract <T> void save(T t);

    /**
     * <pre>
     * <保存或者更新实体> 
     * @param t 实体
     * </pre>
     */
    public abstract <T> void saveOrUpdate(T t);

    /**
     * <pre>
     * <load> 
     * <加载实体的load方法> 
     * @param id 实体的id 
     * @return 查询出来的实体
     * </pre>
     */
    public abstract <T, ID extends Serializable> T load(ID id, Class<T> clazz);

    /**
     * <pre>
     * <get> 
     * <查找的get方法> 
     * @param id 实体的id 
     * @return 查询出来的实体
     * </pre>
     */
    public abstract <T, ID extends Serializable> T get(ID id, Class<T> clazz);

    /**
     * <pre>
     * <contains> 
     * @param t 实体 
     * @return 是否包含
     * </pre>
     */
    public abstract <T> boolean contains(T t);

    /**
     * <pre>
     * <delete> 
     * <删除表中的t数据> 
     * @param t 实体
     * </pre>
     */
    public abstract <T> void delete(T t);

    /**
     * <pre>
     * <根据ID删除数据> 
     * @param Id 实体id 
     * @return 是否删除成功
     * </pre>
     */
    public abstract <T, ID extends Serializable> boolean deleteById(ID Id, Class<T> clazz);

    /**
     * <pre>
     * <删除所有> 
     * @param entities 实体的Collection集合
     * </pre>
     */
    public abstract <T> void deleteAll(Collection<T> entities);

    /**
     * <pre>
     * <执行Hql语句> 
     * @param hqlString hql 
     * @param values 不定参数数组
     * </pre>
     */
    public abstract void executeHql(String hqlString, Object... values);

    /**
     * <pre>
     * <执行Hql语句> 
     * @param hqlString hql 
     * @param values 不定参数数组
     * </pre>
     */
    public abstract void executeHql(String hqlString, Map<String, Object> values);

    /**
     * <pre>
     * <执行Sql语句> 
     * @param sqlString sql 
     * @param values 不定参数数组
     * </pre>
     */
    public abstract void executeSql(String sqlString, Object... values);

    /**
     * <pre>
     * <执行Sql语句> 
     * @param sqlString sql 
     * @param values 参数map
     * </pre>
     */
    public abstract void executeSql(String sqlString, Map<String, Object> values);

    /**
     * <pre>
     * <根据HQL语句查找唯一实体> 
     * @param hqlString HQL语句 
     * @param values 不定参数的Object数组
     * @return 查询实体
     * </pre>
     */
    public abstract <T> T getByHQL(String hqlString, Object... values);

    /**
     * <pre>
     * <根据HQL语句查找唯一实体> 
     * @param hqlString HQL语句 
     * @param values 参数map
     * @return 查询实体
     * </pre>
     */
    public abstract <T> T getByHQL(String hqlString, Map<String, Object> values);

    /**
     * <pre>
     * <根据SQL语句查找唯一实体> 
     * @param sqlString SQL语句 
     * @param values 不定参数的Object数组
     * @return 查询实体
     * </pre>
     */
    public abstract Object getBySQL(String sqlString, Object... values);

    /**
     * <pre>
     * <根据SQL语句查找唯一实体> 
     * @param sqlString SQL语句 
     * @param values 参数map
     * @return 查询实体
     * </pre>
     */
    public abstract Object getBySQL(String sqlString, Map<String, Object> values);

    /**
     * <pre>
     * <根据HQL语句，得到对应的list> 
     * @param hqlString HQL语句 
     * @param values 不定参数的Object数组 
     * @return 查询多个实体的List集合
     * </pre>
     */
    public abstract <T> List<T> getListByHQL(String hqlString, Object... values);

    /**
     * <pre>
     * <根据HQL语句，得到对应的list> 
     * @param hqlString HQL语句 
     * @param values 参数map 
     * @return 查询多个实体的List集合
     * </pre>
     */
    public abstract <T> List<T> getListByHQL(String hqlString, Map<String, Object> values);

    /**
     * <pre>
     * <根据SQL语句，得到对应的list> 
     * @param sqlString HQL语句 
     * @param values 不定参数的Object数组 
     * @return 查询多个实体的List集合
     * </pre>
     */
    public abstract List<?> getListBySQL(String sqlString, Object... values);

    /**
     * <pre>
     * <根据SQL语句，得到对应的list> 
     * @param sqlString HQL语句 
     * @param values 参数map 
     * @return 查询多个实体的List集合
     * </pre>
     */
    public abstract List<?> getListBySQL(String sqlString, Map<String, Object> values);

    /**
     * <pre>
     * <refresh> 
     * @param t 实体
     * </pre>
     */
    public abstract <T> void refresh(T t);

    /**
     * <pre>
     * <update> 
     * @param t 实体
     * </pre>
     */
    public abstract <T> void update(T t);

    /**
     * <pre>
     * <根据HQL得到记录数> 
     * @param hql HQL语句 
     * @param values 参数map 
     * @return 记录总数
     * </pre>
     */
    public abstract Long countByHql(String hql, Object... values);

    /**
     * <pre>
     * <根据HQL得到记录数> 
     * @param hql HQL语句 
     * @param values 不定参数的Object数组 
     * @return 记录总数
     * </pre>
     */
    public abstract Long countByHql(String hql, Map<String, Object> values);

    /**
     * <pre>
     * <HQL分页查询> 
     * @param hql HQL语句 
     * @param start 当前记录位置
     * @param limit 一页总条数 
     * @param values 不定Object数组参数 
     * @return 查询的数据List集合
     * </pre>
     */
    public abstract <T> List<T> findPageByHql(String hql, int start, int limit, Object... values);

    /**
     * <pre>
     * <HQL分页查询> 
     * @param hql HQL语句 
     * @param start 当前记录位置
     * @param limit 一页总条数 
     * @param values 参数map 
     * @return 查询的数据List集合
     * </pre>
     */
    public abstract <T> List<T> findPageByHql(String hql, int start, int limit, Map<String, Object> values);

    /**
     * <pre>
     * <调用存储过程>
     * @param procString
     * @param params
     * @throws Exception
     * </pre>
     */
    public abstract void callProcedure(String procString, List<Object> params) throws Exception;

    /**
     * <pre>
     * <迭代获取记录数据>
     * @param hql
     * @param params
     * @return
     * </pre>
     */
    public abstract <T> Iterator<T> getIterate(String hql, Object... params);

    /**
     * <pre>
     * <迭代获取记录数据>
     * @param hql
     * @param params
     * @return
     * </pre>
     */
    public abstract <T> Iterator<T> getIterate(String hql, Map<String, Object> values);

    /**
     * <pre>
     * <创建与会话无关的检索标准对象>
     * </pre>
     */
    public abstract <T> DetachedCriteria createDetachedCriteria(Class<T> clazz);

    /**
     * <pre>
     * <创建与会话绑定的检索标准对象>
     * </pre>
     */
    public abstract <T> Criteria createCriteria(Class<T> clazz);

    /**
     * <pre>
     * <使用指定的检索标准检索数据>
     * @param criteria
     * </pre>
     */
    public abstract <T> List<T> findByCriteria(DetachedCriteria criteria);

    /**
     * <pre>
     * <使用指定的检索标准检索数据，返回部分记录>
     * @param criteria
     * @param firstResult
     * @param maxResults
     * </pre>
     */
    public abstract <T> List<T> findByCriteria(DetachedCriteria criteria, int firstResult, int maxResults);

    /**
     * <pre>
     * <使用指定的实体及属性检索（满足除主键外属性＝实体值）数据>
     * @param entity 条件值VO
     * @param propertyNames 参与查询的属性
     * </pre>
     */
    public abstract <T> List<T> findEqualByEntity(Object entity, String... propertyNames);

    /**
     * <pre>
     * <使用指定的实体及属性(非主键)检索（满足属性 like 串实体值）数据>
     * @param entity 条件值VO
     * @param propertyNames 参与查询的属性
     * </pre>
     */
    public abstract <T> List<T> findLikeByEntity(Object entity, String... propertyNames);

    /**
     * <pre>
     * <使用指定的检索标准检索数据，返回指定范围的记录>
     * @param criteria
     * </pre>
     */
    public abstract Integer getRowCount(DetachedCriteria criteria);

    /**
     * <pre>
     * <使用指定的检索标准检索数据，返回指定统计值>
     * @param criteria
     * @param propertyName 统计属性
     * @param StatName 统计函数名字
     * </pre>
     */
    public abstract Object getStatValue(DetachedCriteria criteria, String propertyName, String StatName);

}