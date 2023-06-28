package com.hubu.gl.controller;

/**
 * @author Lovejj
 * @version 1.0
 * @description: TODO
 * @date 2023/6/28 下午2:30
 */

import com.hubu.gl.Entity.Message;
import com.hubu.gl.service.IMessageService;
import com.hubu.gl.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    IMessageService messageService;

    @Autowired
    RedisTemplate redisTemplate;

//todo:身份验证
    @GetMapping("/read")
    public ResponseResult readMessage(@RequestParam int messageId){
        boolean b = messageService.updateById(new Message().setId(messageId).setReadTime(new Timestamp(new Date().getTime())).setStatus(1));
        return b?ResponseResult.SUCCESS():ResponseResult.FAIL();
    }

    @GetMapping("/test")
    public boolean testRedis(){
//        半小时后发消息使用两个队列，超过半小时的发送到发送队列，监听发送队列即可
        redisTemplate.convertAndSend("msg",String.valueOf(new Random().nextInt(100)));
        return true;
    }


}
