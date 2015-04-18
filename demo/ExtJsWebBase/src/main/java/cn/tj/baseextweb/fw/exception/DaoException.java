package cn.tj.baseextweb.fw.exception;

/**
 * <pre>
 * 描述数据库级别exception
 * </pre>
 */
public class DaoException extends GenericException {

    private static final long serialVersionUID = 1L;

    public DaoException() {
    }

    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
