package com.hubu.gl.utils;


import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseUtil {
    public static void out(HttpServletResponse response, ResponseResult responseResult) {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");
        try {
            new ObjectMapper().writeValue(response.getWriter(), responseResult);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
