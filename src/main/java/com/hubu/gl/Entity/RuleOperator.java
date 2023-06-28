package com.hubu.gl.Entity;
import lombok.Getter;

@Getter
public enum RuleOperator {

    EQUAL,
    NOT_EQUAL,

    LESS,
    LESS_OR_EQUAL,

    GREATER,
    GREATER_OR_EQUAL,

    IN,
    NOT_IN,

    CONTAINS,
    CONTAINS_IGNORE_CASE,

    NOT_CONTAINS,
    NOT_CONTAINS_IGNORE_CASE,


    BETWEEN,
    NOT_BETWEEN,

    IS_NULL,
    IS_NOT_NULL,

    IS_EMPTY,
    IS_NOT_EMPTY,

    LIKE,
    NO_LIKE

}
