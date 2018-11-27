package bwie.com.suquanwei_yuekao.bean;

/**
 * Created by 小哥 on 2018/11/23.
 */

public class Message<T> {
    private String msg;
    private String code;
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
