package com.hubu.gl.Entity;

import java.io.Serializable;
import lombok.Data;

@Data
public class User implements Serializable {
    /**
     *
     */
    private Integer id;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private String email;

    /**
     *
     */
    private String phone;

    /**
     *
     */
    private Integer status;

    private static final long serialVersionUID = 1L;
}

