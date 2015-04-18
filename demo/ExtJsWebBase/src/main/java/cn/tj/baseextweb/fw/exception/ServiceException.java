package cn.tj.baseextweb.fw.exception;

/**
 * <pre>
 * 描述业务级别exception
 * </pre>
 */
public class ServiceException extends GenericException {

    private static final long serialVersionUID = 1L;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
