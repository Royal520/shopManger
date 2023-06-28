package com.hubu.gl.Entity;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@ToString
@Accessors(chain = true)
public class Store implements Serializable {

    private Integer id;

    private String name;

    private String address;

    private static final long serialVersionUID = 1L;
}

