package com.xyh.backendcenter.controller;

import com.xyh.backendcenter.common.Result;
import com.xyh.backendcenter.common.ResultCodeEnum;
import com.xyh.backendcenter.entity.Role;
import com.xyh.backendcenter.service.RoleService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    @GetMapping("/searchRoleList")
    public Result<List<Role>> searchRoleList() {
        List<Role> roleList = roleService.searchRoleList();
        return Result.build(ResultCodeEnum.SUCCESS, roleList);
    }
}
