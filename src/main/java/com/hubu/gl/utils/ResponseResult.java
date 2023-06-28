package com.hubu.gl.utils;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;

@Data
@ToString
@NoArgsConstructor
@Accessors(chain = true)
public class ResponseResult implements Response {

    //操作是否成功
    boolean success = SUCCESS;

    //操作代码
    int code = SUCCESS_CODE;

    //提示信息
    String message;

    private Map<String, Object> data = new HashMap<String, Object>();

    public ResponseResult(ResultCode resultCode) {
        this.success = resultCode.success();
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    public ResponseResult data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public ResponseResult data(Map<String, Object> map) {
        this.data = map;
        return this;
    }

    public static ResponseResult SUCCESS() {
        return new ResponseResult(CommonCode.SUCCESS);
    }

    public static ResponseResult FAIL() {
        return new ResponseResult(CommonCode.FAIL);
    }
}
