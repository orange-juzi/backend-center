package com.xyh.backendcenter.service.impl;


import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xyh.backendcenter.common.PageUtils;
import com.xyh.backendcenter.dto.LoginForm;
import com.xyh.backendcenter.dto.RegisterForm;
import com.xyh.backendcenter.dto.SearchUserByPageForm;
import com.xyh.backendcenter.entity.User;
import com.xyh.backendcenter.exception.BackendException;
import com.xyh.backendcenter.mapper.UserMapper;
import com.xyh.backendcenter.service.UserService;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static com.xyh.backendcenter.common.ResultCodeEnum.TWO_PASSWORD_ERROR;
import static com.xyh.backendcenter.common.ResultCodeEnum.USERNAME_ERROR;

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
    public List<String> searchUserPermission(int userId) {
        return userMapper.searchUserPermission(userId);
    }

    @Override
    public Integer register(RegisterForm form) {
        String username = form.getUsername();
        String password = form.getPassword();
        String checkPassword = form.getCheckPassword();
        if (!StringUtils.equals(password, checkPassword)) {
            throw new BackendException(TWO_PASSWORD_ERROR);
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        long count = this.count(queryWrapper);
        if (count > 0) {
            throw new BackendException(USERNAME_ERROR);
        }
        String encryptPassword = DigestUtil.sha1Hex(password);
        User user = new User();
        user.setUsername(username);
        user.setPassword(encryptPassword);
        //设置角色默认值
        user.setRole("[3]");
        boolean result = this.save(user);
        if (!result) {
            throw new BackendException(500, "该用户注册未成功");
        }
        return user.getId();
    }

    @Override
    public User login(LoginForm form) {
        if (form.getPassword().length() == 40) {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("username", form.getUsername());
            queryWrapper.eq("password", form.getPassword());
            User user = this.getOne(queryWrapper);
            if (user == null) {
                throw new BackendException(500, "用户名或密码不正确，请重新输入！");
            }
            return user;
        }
        String encryptPassword = DigestUtil.sha1Hex(form.getPassword());
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", form.getUsername());
        queryWrapper.eq("password", encryptPassword);
        User user = this.getOne(queryWrapper);
        if (user == null) {
            throw new BackendException(500, "用户名或密码不正确，请重新输入！");
        }
        return user;
    }

    @Override
    public User getCurrentUser(int userId) {
        User user = this.getById(userId);
        if (user == null) {
            throw new BackendException(500, "该用户不存在，请重新登录");
        }
        return user;
    }

    @Override
    public PageUtils getUserList(HashMap param) {
        List<HashMap> userList = userMapper.getUserList(param);
        long total = userMapper.searchUserCount(param);
        int current = (Integer) param.get("start");
        int pageSize = (Integer) param.get("pageSize");
        PageUtils pageUtils = new PageUtils(userList, total, current, pageSize);
        return pageUtils;
    }

    @Override
    public boolean insert(User user) {
        int count = userMapper.insert(user);
        if (count > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean update(HashMap param) {
        int rows = userMapper.update(param);
        if (rows > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer[] id) {
        return this.removeBatchByIds(Arrays.stream(id).toList());
    }


}




