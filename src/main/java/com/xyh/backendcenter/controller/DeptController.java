package com.xyh.backendcenter.controller;

import com.xyh.backendcenter.common.Result;
import com.xyh.backendcenter.common.ResultCodeEnum;
import com.xyh.backendcenter.entity.Dept;
import com.xyh.backendcenter.entity.Role;
import com.xyh.backendcenter.service.DeptService;
import com.xyh.backendcenter.service.RoleService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {

    @Resource
    private DeptService deptService;

    @GetMapping("/searchDeptList")
    public Result<List<Dept>> searchDeptList() {
        List<Dept> deptList = deptService.searchDeptList();
        return Result.build(ResultCodeEnum.SUCCESS, deptList);
    }
}
