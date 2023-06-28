package com.hubu.gl.utils;

import cn.hutool.json.JSONUtil;
import lombok.ToString;

@ToString
public enum CommonCode implements ResultCode {
    SUCCESS(true, 1000, "操作成功！"),
    SUCCESS_Login(true, 1001, "登录成功！"),
    SUCCESS_LOGOUT(true, 10002, "退出成功！"),
    UPLOADSUCCESS(true, 1002, "上传成功！"),
    INVALID_PARAM(false, 2000, "非法参数！"),
    INVALID_ID(false, 2000, "ID不存在！"),
    EMPYTFILE(false, 2003, "上传文件为空"),
    FAIL(false, 4000, "操作失败！"),
    LOGINFAIL(false, 4001, "登录失败，用户名或密码错误！"),
    FAIL_LOGOUT(false, 4002, "登出失败,删除token失败！"),
    UNAUTHENTICATED(false, 5000, "此操作需要登陆系统！"),
    UNAUTHORISE(false, 5001, "权限不足，无权操作！"),
    SERVER_ERROR(false, 9999, "抱歉，系统繁忙，请稍后重试！");

    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;

    private CommonCode(boolean success, int code, String message) {
        this.message = message;
        this.code = code;
        this.success = success;
    }

    @Override
    public boolean success() {
        return success;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }

    public static String toJson(CommonCode code) {
        return JSONUtil.toJsonStr(code);
    }
}
