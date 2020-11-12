package net.xdclass.online_xdclass.exception;

/**
 * 自定义异常类
 * @author suning
 */
public class XdException extends RuntimeException{

    private Integer code;

    private String msg;

    public XdException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
