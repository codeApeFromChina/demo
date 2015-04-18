package cn.tj.baseextweb.fw.exception;

/**
 * <pre>
 * 描述底层jar抛出的exception
 * eg：java IO
 * </pre>
 */
public class SystemException extends GenericException {

    private static final long serialVersionUID = 1L;

    public SystemException() {
    }

    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
