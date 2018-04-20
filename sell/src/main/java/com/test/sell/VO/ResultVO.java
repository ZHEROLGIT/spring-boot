package com.test.sell.VO;

/**
 * @file_name: ResultVO
 * @Description：
 * @author: 张磊
 * @date: 四月 2018/4/13 16:18
 * @version：
 */
//http返回请求的最外层对象
public class ResultVO <T>{
    private int code;   //错误码
    private String msg;  //提示信息
    private T data;  //返回的具体内容

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
