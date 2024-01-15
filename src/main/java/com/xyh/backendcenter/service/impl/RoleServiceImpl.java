package com.xyh.backendcenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyh.backendcenter.entity.Role;
import com.xyh.backendcenter.mapper.RoleMapper;
import com.xyh.backendcenter.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author xiaoxie
* @description 针对表【tb_role(角色表)】的数据库操作Service实现
* @createDate 2024-01-05 18:37:17
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService {

    @Override
    public List<Role> searchRoleList() {
        List<Role> roleList = this.list(new QueryWrapper<>());
        return roleList;
    }
}




