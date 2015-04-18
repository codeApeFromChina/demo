package cn.tj.baseextweb.fw.service;

/**
 * 通用服务基类
 * 
 * @author fnzi
 *
 * @param <P>
 * @param <R>
 */
public interface GenericService<P, R> {

    public abstract R execute(P param);
}
