package com.xyh.backendcenter.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xyh.backendcenter.entity.User;
import com.xyh.backendcenter.mapper.UserMapper;
import com.xyh.backendcenter.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiaoxie
 * @description 针对表【tb_user(用户表)】的数据库操作Service实现
 * @createDate 2024-01-05 16:50:09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<String> searchUserPermission(Long userId) {
        return userMapper.searchUserPermission(userId);
    }
}




