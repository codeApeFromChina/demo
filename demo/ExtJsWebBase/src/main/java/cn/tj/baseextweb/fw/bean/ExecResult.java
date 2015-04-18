package cn.tj.baseextweb.fw.bean;

public class ExecResult {

    private boolean success;
    private String msg;
    private Object data;

    public ExecResult() {
        super();
    }

    public ExecResult(boolean success, String msg) {
        super();
        this.success = success;
        this.msg = msg;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
      return data;
    }

    public void setData(Object data) {
      this.data = data;
    }

}
