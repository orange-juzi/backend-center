package com.xyh.backendcenter.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.xyh.backendcenter.common.PageUtils;
import com.xyh.backendcenter.dto.LoginForm;
import com.xyh.backendcenter.dto.RegisterForm;
import com.xyh.backendcenter.dto.SearchUserByPageForm;
import com.xyh.backendcenter.entity.User;

import java.util.HashMap;
import java.util.List;

/**
* @author xiaoxie
* @description 针对表【tb_user(用户表)】的数据库操作Service
* @createDate 2024-01-05 16:50:09
*/
public interface UserService extends IService<User> {
    /**
     * 查询用户权限信息
     *
     * @param userId 用户id
     * @return 返回权限集合
     */
    public List<String> searchUserPermission(int userId);

    /**
     * 用户注册
     * @param form 注册表单
     * @return 用户id
     */
    Integer register(RegisterForm form);

    /**
     * 用户登录
     * @param form 登录表单
     * @return 用户信息
     */
    User login(LoginForm form);

    /**
     * 获取当前用户
     * @param userId 用户ID
     * @return 返回用户信息
     */
    User getCurrentUser(int userId);

    /**
     * 查询用户列表
     * @return
     */
    PageUtils getUserList(HashMap map);

    /**
     * 添加用户
     * @param user 用户表单
     * @return
     */
    public boolean insert(User user);

    /**
     * 修改用户
     * @param param
     * @return
     */

    boolean update(HashMap param);

    /**
     * 删除用户
     * @param id
     * @return
     */
    boolean delete(Integer[] id);

}
