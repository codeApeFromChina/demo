package cn.tj.baseextweb.fw.exception;

/**
 * <pre>
 * exception基类
 * </pre>
 */
public class GenericException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public GenericException() {
    }

    public GenericException(String message) {
        super(message);
    }

    public GenericException(String message, Throwable cause) {
        super(message, cause);
    }
}
