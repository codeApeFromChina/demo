package cn.tj.baseextweb.fw.service;

import java.util.Map;

import cn.tj.baseextweb.fw.bean.ExecResult;
import cn.tj.baseextweb.fw.exception.DaoException;
import cn.tj.baseextweb.fw.exception.GenericException;
import cn.tj.baseextweb.fw.exception.ServiceException;
import cn.tj.baseextweb.fw.exception.SystemException;
import cn.tj.baseextweb.fw.helper.LogUtil;

/**
 * 用于返回ext逻辑判断服务处理
 * 
 * @author fnzi
 *
 */
public abstract class ExecResultService extends ExtService<ExecResult> {

    @Override
    public final ExecResult execute(Map<String, Object> param) {
        ExecResult ret = null;

        try {
            ret = doExecute(param);
        } catch (SystemException e) {
            LogUtil.logError("系统依赖异常：" + e.getMessage(), module);
            ret = new ExecResult(false, e.getMessage());
        } catch (DaoException e) {
            LogUtil.logError("数据操作异常：" + e.getMessage(), module);
            ret = new ExecResult(false, e.getMessage());
        } catch (ServiceException e) {
            LogUtil.logError("业务异常：" + e.getMessage(), module);
            ret = new ExecResult(false, e.getMessage());
        } catch (GenericException e) {
            LogUtil.logError("系统异常：" + e.getMessage(), module);
            ret = new ExecResult(false, e.getMessage());
        }

        return ret;
    }

    public abstract ExecResult doExecute(Map<String, Object> param);

}
