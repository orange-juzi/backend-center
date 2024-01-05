package com.xyh.backendcenter.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.xyh.backendcenter.entity.User;

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
    public List<String> searchUserPermission(Long userId);

}
