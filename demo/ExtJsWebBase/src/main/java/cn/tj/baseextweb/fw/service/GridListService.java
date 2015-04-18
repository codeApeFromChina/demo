package cn.tj.baseextweb.fw.service;

import java.util.Map;

import cn.tj.baseextweb.fw.bean.GridList;
import cn.tj.baseextweb.fw.exception.DaoException;
import cn.tj.baseextweb.fw.exception.GenericException;
import cn.tj.baseextweb.fw.exception.ServiceException;
import cn.tj.baseextweb.fw.exception.SystemException;
import cn.tj.baseextweb.fw.helper.LogUtil;

/**
 * 用于返回ext Grid服务处理
 * 
 * @author fnzi
 *
 * @param <T>
 */
public abstract class GridListService<T> extends ExtService<GridList<T>> {

    @Override
    public final GridList<T> execute(Map<String, Object> param) {
        GridList<T> ret = new GridList<T>();

        try {
            ret = doExecute(param);
        } catch (SystemException e) {
            LogUtil.logError("系统依赖异常：" + e.getMessage(), module);
        } catch (DaoException e) {
            LogUtil.logError("数据操作异常：" + e.getMessage(), module);
        } catch (ServiceException e) {
            LogUtil.logError("业务异常：" + e.getMessage(), module);
        } catch (GenericException e) {
            LogUtil.logError("系统异常：" + e.getMessage(), module);
        }

        return ret;
    }

    public abstract GridList<T> doExecute(Map<String, Object> param);
}
