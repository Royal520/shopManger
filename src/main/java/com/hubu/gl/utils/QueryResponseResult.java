package com.hubu.gl.utils;

import lombok.Data;

@Data
public class QueryResponseResult<T> extends ResponseResult {
    private QueryResult<T> queryResult;

    public QueryResponseResult(ResultCode resultCode, QueryResult<T> queryResult) {
        super(resultCode);
        this.queryResult = queryResult;
    }
}
