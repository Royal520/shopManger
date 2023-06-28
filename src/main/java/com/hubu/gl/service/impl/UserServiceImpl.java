package com.hubu.gl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hubu.gl.Entity.User;
import com.hubu.gl.dao.mapper.UserMapper;
import com.hubu.gl.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @author Lovejj
 * @version 1.0
 * @description: TODO
 * @date 2023/6/28 下午2:27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
}
