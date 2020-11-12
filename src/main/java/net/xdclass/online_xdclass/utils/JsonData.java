package net.xdclass.online_xdclass.utils;

/**
 * 统一返回类
 *
 * @author suning
 */
public class JsonData {

    /**
     * 状态码，0表示成功，1表示处理中，-1表示失败
     */
    private Integer code;

    /**
     * 信息
     */
    private String message;

    /**
     * 用户数据
     */
    private Object data;

    public JsonData() {
    }

    public JsonData(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功不反回数据
     *
     * @return 包装返回数据
     */
    public static JsonData buildSuccess() {
        return new JsonData(0, null, null);
    }

    /**
     * 成功返回数据
     *
     * @param data 返回数据
     * @return 包装返回数据
     */
    public static JsonData buildSuccess(Object data) {
        return new JsonData(0, null, data);
    }

    /**
     * 失败不反回数据
     *
     * @param msg 错误信息
     * @return 包装返回数据
     */
    public static JsonData buildError(String msg) {
        return new JsonData(-1, msg, null);
    }

    public static JsonData buildError(Integer code, String msg) {
        return new JsonData(code, msg, null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
