package com.hubu.gl.utils;

public interface ResultCode {
    //是否成功
    public boolean success();

    //状态代码
    public int code();

    //返回提示
    public String message();

}
