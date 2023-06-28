package com.hubu.gl.service.impl;

import org.springframework.stereotype.Component;

/**
 * @author Lovejj
 * @version 1.0
 * @description: TODO
 * @date 2023/6/28 下午3:25
 */
@Component
public class RedisReceiver {
    public void receiveMessage(String message) {
    System.out.println("subscribe receive message:"+message);
}

}
