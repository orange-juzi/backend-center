package com.xyh.backendcenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xyh.backendcenter.entity.Role;

import java.util.List;

/**
* @author xiaoxie
* @description 针对表【tb_role(角色表)】的数据库操作Service
* @createDate 2024-01-05 18:37:17
*/
public interface RoleService extends IService<Role> {

    /**
     * 查询角色列表
     * @return
     */
    List<Role> searchRoleList();
}
