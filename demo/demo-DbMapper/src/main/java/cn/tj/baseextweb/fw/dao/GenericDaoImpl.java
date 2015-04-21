package cn.tj.baseextweb.fw.dao;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jdbc.Work;

import org.apache.commons.beanutils.PropertyUtils;

@SuppressWarnings({ "unchecked" })
public class GenericDaoImpl implements GenericDao {

    private SessionFactory sessionFactory;

    public GenericDaoImpl() {
    }

    /**
     * <pre>
     * <保存实体> 
     * <完整保存实体> 
     * @param t 实体参数 
     * @see cn.tj.baseextweb.fw.dao.GenericDao#save(java.lang.Object)
     * </pre>
     */
    
    public <T> void save(T t) {
        this.getSession().save(t);
    }

    /**
     * <pre>
     * <保存或者更新实体> 
     * @param t 实体 
     * @see cn.tj.baseextweb.fw.dao.GenericDao#saveOrUpdate(java.lang.Object)
     * </pre>
     */
    
    public <T> void saveOrUpdate(T t) {
        this.getSession().saveOrUpdate(t);
    }

    /**
     * <pre>
     * <load> 
     * <加载实体的load方法> 
     * @param id 实体的id 
     * @return 查询出来的实体 
     * @see cn.tj.baseextweb.fw.dao.GenericDao#load(java.io.Serializable)
     * </pre>
     */
    
    public <T, ID extends Serializable> T load(ID id, Class<T> clazz) {
        T load = (T) this.getSession().load(clazz, id);
        return load;
    }

    /**
     * <pre>
     * <get> 
     * <查找的get方法> 
     * @param id 实体的id 
     * @return 查询出来的实体 
     * @see cn.tj.baseextweb.fw.dao.GenericDao#get(java.io.Serializable)
     * </pre>
     */
    
    public <T, ID extends Serializable> T get(ID id, Class<T> clazz) {
        T load = (T) this.getSession().get(clazz, id);
        return load;
    }

    /**
     * <pre>
     * <contains> 
     * @param t 实体 
     * @return 是否包含 
     * @see cn.tj.baseextweb.fw.dao.GenericDao#contains(java.lang.Object)
     * </pre>
     */
    
    public <T> boolean contains(T t) {
        return this.getSession().contains(t);
    }

    /**
     * <pre>
     * <delete> 
     * <删除表中的t数据> 
     * @param t 实体
     * @see cn.tj.baseextweb.fw.dao.GenericDao#delete(java.lang.Object)
     * </pre>
     */
    
    public <T> void delete(T t) {
        this.getSession().delete(t);
    }

    /**
     * <pre>
     * <根据ID删除数据> 
     * @param Id 实体id 
     * @return 是否删除成功 
     * @see cn.tj.baseextweb.fw.dao.GenericDao#deleteById(java.io.Serializable)
     * </pre>
     */
    
    public <T, ID extends Serializable> boolean deleteById(ID Id, Class<T> clazz) {
        T t = get(Id, clazz);
        if (t == null) {
            return false;
        }
        delete(t);
        return true;
    }

    /**
     * <pre>
     * <删除所有> 
     * @param entities 实体的Collection集合
     * @see cn.tj.baseextweb.fw.dao.GenericDao#deleteAll(java.util.Collection)
     * </pre>
     */

    
    public <T> void deleteAll(Collection<T> entities) {
        for (Object entity : entities) {
            this.getSession().delete(entity);
        }
    }

    /**
     * <pre>
     * <执行Hql语句> 
     * @param hqlString hql 
     * @param values 不定参数数组 
     * @see cn.tj.baseextweb.fw.dao.GenericDao#queryHql(java.lang.String,java.lang.Object[])
     * </pre>
     */
    
    public void executeHql(String hqlString, Object... values) {
        Query query = this.getSession().createQuery(hqlString);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        query.executeUpdate();
    }

    /**
     * <pre>
     * <执行Hql语句> 
     * @param hqlString hql 
     * @param values 参数map 
     * @see cn.tj.baseextweb.fw.dao.GenericDao#queryHql(java.lang.String,java.util.Map<String, Object>)
     * </pre>
     */
    
    public void executeHql(String hqlString, Map<String, Object> values) {
        Query query = this.getSession().createQuery(hqlString);
        if (values != null) {
            for (String param : values.keySet()) {
                query = setParam(query, param, values.get(param));
            }
        }
        query.executeUpdate();
    }

    /**
     * <pre>
     * <执行Sql语句> 
     * @param sqlString sql 
     * @param values 不定参数数组 
     * @see cn.tj.baseextweb.fw.dao.GenericDao#querySql(java.lang.String, java.lang.Object[])
     * </pre>
     */
    
    public void executeSql(String sqlString, Object... values) {
        Query query = this.getSession().createSQLQuery(sqlString);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        query.executeUpdate();
    }

    /**
     * <pre>
     * <执行Sql语句> 
     * @param sqlString sql 
     * @param values 参数map 
     * @see cn.tj.baseextweb.fw.dao.GenericDao#querySql(java.lang.String, java.util.Map<String, Object>)
     * </pre>
     */
    
    public void executeSql(String sqlString, Map<String, Object> values) {
        Query query = this.getSession().createSQLQuery(sqlString);
        if (values != null) {
            for (String param : values.keySet()) {
                query = setParam(query, param, values.get(param));
            }
        }
        query.executeUpdate();
    }

    /**
     * <pre>
     * <根据HQL语句查找唯一实体> 
     * @param hqlString HQL语句 
     * @param values 不定参数的Object数组
     * @return 查询实体 
     * @see cn.tj.baseextweb.fw.dao.GenericDao#getByHQL(java.lang.String, java.lang.Object[])
     * </pre>
     */
    
    public <T> T getByHQL(String hqlString, Object... values) {
        Query query = this.getSession().createQuery(hqlString);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        return (T) query.uniqueResult();
    }

    /**
     * <pre>
     * <根据HQL语句查找唯一实体> 
     * @param hqlString HQL语句 
     * @param values 参数map
     * @return 查询实体 
     * @see cn.tj.baseextweb.fw.dao.GenericDao#getByHQL(java.lang.String, java.util.Map<String, Object>)
     * </pre>
     */
    
    public <T> T getByHQL(String hqlString, Map<String, Object> values) {
        Query query = this.getSession().createQuery(hqlString);
        if (values != null) {
            for (String param : values.keySet()) {
                query = setParam(query, param, values.get(param));
            }
        }
        return (T) query.uniqueResult();
    }

    /**
     * <pre>
     * <根据SQL语句查找唯一实体> 
     * @param sqlString SQL语句
     * @param values 不定参数的Object数组
     * @return 查询实体
     * @see cn.tj.baseextweb.fw.dao.GenericDao#getBySQL(java.lang.String, java.lang.Object[])
     * </pre>
     */
    
    public Object getBySQL(String sqlString, Object... values) {
        Query query = this.getSession().createSQLQuery(sqlString);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        return query.uniqueResult();
    }

    /**
     * <pre>
     * <根据SQL语句查找唯一实体> 
     * @param sqlString SQL语句
     * @param values 参数map
     * @return 查询实体
     * @see cn.tj.baseextweb.fw.dao.GenericDao#getBySQL(java.lang.String, java.util.Map<String, Object>)
     * </pre>
     */
    
    public Object getBySQL(String sqlString, Map<String, Object> values) {
        Query query = this.getSession().createSQLQuery(sqlString);
        if (values != null) {
            for (String param : values.keySet()) {
                query = setParam(query, param, values.get(param));
            }
        }
        return query.uniqueResult();
    }

    /**
     * <pre>
     * <根据HQL语句，得到对应的list> 
     * @param hqlString HQL语句 
     * @param values 不定参数的Object数组 
     * @return 查询多个实体的List集合 
     * @see cn.tj.baseextweb.fw.dao.GenericDao#getListByHQL(java.lang.String, java.lang.Object[])
     * </pre>
     */
    
    public <T> List<T> getListByHQL(String hqlString, Object... values) {
        Query query = this.getSession().createQuery(hqlString);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        return query.list();
    }

    /**
     * <pre>
     * <根据HQL语句，得到对应的list> 
     * @param hqlString HQL语句 
     * @param values 参数map 
     * @return 查询多个实体的List集合 
     * @see cn.tj.baseextweb.fw.dao.GenericDao#getListByHQL(java.lang.String, java.util.Map<String, Object>)
     * </pre>
     */
    
    public <T> List<T> getListByHQL(String hqlString, Map<String, Object> values) {
        Query query = this.getSession().createQuery(hqlString);
        if (values != null) {
            for (String param : values.keySet()) {
                query = setParam(query, param, values.get(param));
            }
        }
        return query.list();
    }

    /**
     * <pre>
     * <根据SQL语句，得到对应的list> 
     * @param sqlString HQL语句
     * @param values 不定参数的Object数组 
     * @return 查询多个实体的List集合 
     * @see cn.tj.baseextweb.fw.dao.GenericDao#getListBySQL(java.lang.String, java.lang.Object[])
     * </pre>
     */
    
    public List<?> getListBySQL(String sqlString, Object... values) {
        Query query = this.getSession().createSQLQuery(sqlString);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        return query.list();
    }

    /**
     * <pre>
     * <根据SQL语句，得到对应的list> 
     * @param sqlString HQL语句
     * @param values 参数map 
     * @return 查询多个实体的List集合 
     * @see cn.tj.baseextweb.fw.dao.GenericDao#getListBySQL(java.lang.String, java.util.Map<String, Object>)
     * </pre>
     */
    
    public List<?> getListBySQL(String sqlString, Map<String, Object> values) {
        Query query = this.getSession().createSQLQuery(sqlString);
        if (values != null) {
            for (String param : values.keySet()) {
                query = setParam(query, param, values.get(param));
            }
        }
        return query.list();
    }

    /**
     * <pre>
     * <refresh>
     * @param t 实体 
     * @see cn.tj.baseextweb.fw.dao.GenericDao#refresh(java.lang.Object)
     * </pre>
     */
    
    public <T> void refresh(T t) {
        this.getSession().refresh(t);
    }

    /**
     * <pre>
     * <update> 
     * @param t 实体 
     * @see cn.tj.baseextweb.fw.dao.GenericDao#update(java.lang.Object)
     * </pre>
     */
    
    public <T> void update(T t) {
        this.getSession().update(t);
    }

    /**
     * <pre>
     * <根据HQL得到记录数> 
     * @param hql HQL语句 
     * @param values 不定参数的Object数组
     * @return 记录总数 
     * @see cn.tj.baseextweb.fw.dao.GenericDao#countByHql(java.lang.String, java.lang.Object[])
     * </pre>
     */
    
    public Long countByHql(String hql, Object... values) {
        Query query = this.getSession().createQuery(hql);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        return (Long) query.uniqueResult();
    }

    /**
     * <pre>
     * <根据HQL得到记录数> 
     * @param hql HQL语句 
     * @param values 参数map
     * @return 记录总数 
     * @see cn.tj.baseextweb.fw.dao.GenericDao#countByHql(java.lang.String, java.util.Map<String, Object>)
     * </pre>
     */
    
    public Long countByHql(String hql, Map<String, Object> values) {
        Query query = this.getSession().createQuery(hql);
        if (values != null) {
            for (String param : values.keySet()) {
                query = setParam(query, param, values.get(param));
            }
        }
        return (Long) query.uniqueResult();
    }

    /**
     * <pre>
     * <HQL分页查询> 
     * @param hql HQL语句 
     * @param start 当前记录位置
     * @param limit 一页总条数 
     * @param values 不定Object数组参数 
     * @return 查询的数据List集合
     * @see cn.tj.baseextweb.fw.dao.GenericDao#findPageByFetchedHql(java.lang.String, int, int, java.lang.Object[])
     * </pre>
     */
    public <T> List<T> findPageByHql(String hql, int start, int limit, Object... values) {
        Query query = this.getSession().createQuery(hql);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        return query.setFirstResult(start).setMaxResults(limit).list();
    }

    /**
     * <pre>
     * <HQL分页查询> 
     * @param hql HQL语句 
     * @param start 当前记录位置
     * @param limit 一页总条数 
     * @param values 参数map 
     * @return 查询的数据List集合
     * @see cn.tj.baseextweb.fw.dao.GenericDao#findPageByFetchedHql(java.lang.String, int, int, java.util.Map<String, Object>)
     * </pre>
     */
    public <T> List<T> findPageByHql(String hql, int start, int limit, Map<String, Object> values) {
        Query query = this.getSession().createQuery(hql);
        if (values != null) {
            for (String param : values.keySet()) {
                query = setParam(query, param, values.get(param));
            }
        }
        return query.setFirstResult(start).setMaxResults(limit).list();
    }

    /**
     * <pre>
     * <迭代获取记录数据>
     * @param hql
     * @param params
     * @return
     * @see cn.tj.baseextweb.fw.dao.GenericDao#iterate(java.lang.String, java.lang.Object[])
     * </pre>
     */
    public <T> Iterator<T> getIterate(String hql, Object... params) {
        Query query = this.getSession().createQuery(hql);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }
        return query.iterate();
    }

    /**
     * <pre>
     * <迭代获取记录数据>
     * @param hql
     * @param params
     * @return
     * @see cn.tj.baseextweb.fw.dao.GenericDao#iterate(java.lang.String, java.util.Map<String, Object>)
     * </pre>
     */
    public <T> Iterator<T> getIterate(String hql, Map<String, Object> params) {
        Query query = this.getSession().createQuery(hql);
        if (params != null) {
            for (String param : params.keySet()) {
                query.setParameter(param, params.get(param));
            }
        }
        return query.iterate();
    }

    /**
     * <pre>
     * <根据HQL得到记录数> 
     * @param procString 存储过程语句 
     * @param values 不定参数的Object数组
     * @return 记录总数 
     * @see cn.tj.baseextweb.fw.dao.GenericDao#callProcedure(java.lang.String, java.lang.Object[])
     * </pre>
     */
    
    public void callProcedure(final String procString, final List<Object> params) throws Exception {
        Work work = new Work() {
            public void execute(Connection cn) throws SQLException {
                CallableStatement stmt = null;
                stmt = cn.prepareCall(procString);
                if (params != null) {
                    int idx = 1;
                    for (Object obj : params) {
                        if (obj != null) {
                            stmt.setObject(idx, obj);
                        } else {
                            stmt.setNull(idx, Types.NULL);
                        }
                        idx++;
                    }
                }
                stmt.execute();
            }
        };
        this.getSession().doWork(work);
    }

    /**
     * <pre>
     * <创建与会话无关的检索标准对象>
     * </pre>
     */
    public <T> DetachedCriteria createDetachedCriteria(Class<T> clazz) {
        return DetachedCriteria.forClass(clazz);
    }

    /**
     * <pre>
     * <创建与会话绑定的检索标准对象>
     * 
     * Criteria 参考资料：
     * http://www.blogjava.net/jjshcc/archive/2010/08/16/329046.html?opt=admin
     * </pre>
     */
    public <T> Criteria createCriteria(Class<T> clazz) {
        return this.getSession().createCriteria(clazz);
    }

    /**
     * <pre>
     * <使用指定的检索标准检索数据>
     * @param criteria
     * </pre>
     */
    public <T> List<T> findByCriteria(DetachedCriteria criteria) {
        return this.findByCriteria(criteria, -1, -1);
    }

    /**
     * <pre>
     * <使用指定的检索标准检索数据，返回部分记录>
     * @param criteria
     * @param firstResult
     * @param maxResults
     * </pre>
     */
    public <T> List<T> findByCriteria(DetachedCriteria criteria, int firstResult, int maxResults) {
        Criteria executableCriteria = criteria.getExecutableCriteria(this.getSession());
        if (firstResult >= 0) {
            executableCriteria.setFirstResult(firstResult);
        }
        if (maxResults > 0) {
            executableCriteria.setMaxResults(maxResults);
        }
        return executableCriteria.list();
    }

    /**
     * <pre>
     * <使用指定的实体及属性检索（满足除主键外属性＝实体值）数据>
     * @param entity 条件值VO
     * @param propertyNames 参与查询的属性
     * </pre>
     */
    public <T> List<T> findEqualByEntity(Object entity, String... propertyNames) {
        Criteria criteria = this.createCriteria(entity.getClass());
        Example exam = Example.create(entity);
        exam.excludeZeroes();
        String[] defPropertys = getSessionFactory().getClassMetadata(entity.getClass()).getPropertyNames();
        for (String defProperty : defPropertys) {
            int ii = 0;
            for (ii = 0; ii < propertyNames.length; ++ii) {
                if (defProperty.equals(propertyNames[ii])) {
                    criteria.addOrder(Order.asc(defProperty));
                    break;
                }
            }
            if (ii == propertyNames.length) {
                exam.excludeProperty(defProperty);
            }
        }
        criteria.add(exam);
        return (List<T>) criteria.list();
    }

    /**
     * <pre>
     * <使用指定的实体及属性(非主键)检索（满足属性 like 串实体值）数据>
     * @param entity 条件值VO
     * @param propertyNames 参与查询的属性
     * </pre>
     */
    public <T> List<T> findLikeByEntity(Object entity, String... propertyNames) {
        Criteria criteria = this.createCriteria(entity.getClass());
        for (String property : propertyNames) {
            try {
                Object value = PropertyUtils.getProperty(entity, property);
                if (value instanceof String) {
                    criteria.add(Restrictions.like(property, (String) value, MatchMode.ANYWHERE));
                    criteria.addOrder(Order.asc(property));
                } else {
                    criteria.add(Restrictions.eq(property, value));
                    criteria.addOrder(Order.asc(property));
                }
            } catch (Exception ex) {
                // 忽略无效的检索参考数据。
            }
        }
        return (List<T>) criteria.list();
    }

    /**
     * <pre>
     * <使用指定的检索标准检索数据，返回指定范围的记录>
     * @param criteria
     * </pre>
     */
    public Integer getRowCount(DetachedCriteria criteria) {
        criteria.setProjection(Projections.rowCount());
        List<?> list = this.findByCriteria(criteria, 0, 1);
        return (Integer) list.get(0);
    }

    /**
     * <pre>
     * <使用指定的检索标准检索数据，返回指定统计值>
     * @param criteria
     * @param propertyName 统计属性
     * @param StatName 统计函数名字
     * </pre>
     */
    public Object getStatValue(DetachedCriteria criteria, String propertyName, String StatName) {
        if (StatName.toLowerCase().equals("max"))
            criteria.setProjection(Projections.max(propertyName));
        else if (StatName.toLowerCase().equals("min"))
            criteria.setProjection(Projections.min(propertyName));
        else if (StatName.toLowerCase().equals("avg"))
            criteria.setProjection(Projections.avg(propertyName));
        else if (StatName.toLowerCase().equals("sum"))
            criteria.setProjection(Projections.sum(propertyName));
        else
            return null;
        List<?> list = this.findByCriteria(criteria, 0, 1);
        return list.get(0);
    }

    /**
     * @return the sessionFactory
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * @param sessionFactory
     *            the sessionFactory to set
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * @return session
     */
    public Session getSession() {
        // 需要开启事物，才能得到CurrentSession
        return sessionFactory.getCurrentSession();
    }

    /** 参数赋值 */
    private Query setParam(Query q, String key, Object value) {
        if ((value instanceof Long))
            q.setLong(key, ((Long) value).longValue());
        else if ((value instanceof String))
            q.setString(key, (String) value);
        else if ((value instanceof Integer))
            q.setInteger(key, ((Integer) value).intValue());
        else if ((value instanceof Short))
            q.setShort(key, ((Short) value).shortValue());
        else if ((value instanceof Double))
            q.setDouble(key, ((Double) value).doubleValue());
        else if ((value instanceof Date))
            q.setDate(key, (Date) value);
        else
            q.setString(key, value.toString());

        return q;
    }
}
