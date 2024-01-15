package com.xyh.backendcenter.controller;


import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaMode;
import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.json.JSONUtil;
import com.xyh.backendcenter.common.PageUtils;
import com.xyh.backendcenter.common.Result;
import com.xyh.backendcenter.common.ResultCodeEnum;
import com.xyh.backendcenter.config.COSClientConfig;
import com.xyh.backendcenter.dto.*;
import com.xyh.backendcenter.entity.User;
import com.xyh.backendcenter.exception.BackendException;
import com.xyh.backendcenter.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.yaml.snakeyaml.events.Event;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Tag(name = "用户模块")
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private COSClientConfig cosClientConfig;


    @PostMapping("/register")
    @Operation(summary = "用户注册")
    public Result<Integer> register(@Valid @RequestBody RegisterForm form) {
        Integer userId = userService.register(form);
        return Result.build(200, "注册成功", userId);
    }

    @PostMapping("/login")
    @Operation(summary = "用户登录")
    public Result<HashMap<String, Object>> register(@Valid @RequestBody LoginForm form) {
        User user = userService.login(form);
        StpUtil.login(user.getId(), false);
        List<String> permission = userService.searchUserPermission(user.getId());
        String token = StpUtil.getTokenValue();
        HashMap<String, Object> map = new HashMap<>();
        map.put("permission", permission);
        map.put("token", token);
        return Result.build(200, "登录成功", map);
    }

    @GetMapping("/currentUser")
    @Operation(summary = "获取当前用户")
    public Result<User> getCurrentUser() {
        int userId = StpUtil.getLoginIdAsInt();
        User user = userService.getCurrentUser(userId);
        return Result.build(ResultCodeEnum.SUCCESS, user);
    }

    @GetMapping("/logout")
    @Operation(summary = "退出登录")
    public Result<?> logout() {
        StpUtil.logout();
        return Result.build(ResultCodeEnum.SUCCESS, null);
    }

    @PostMapping("/getUserList")
    @Operation(summary = "查询用户列表")
    public Result<PageUtils> getUserList(@RequestBody SearchUserByPageForm form) {
        Integer current = form.getCurrent();
        Integer pageSize = form.getPageSize();
        int start = (current - 1) * pageSize;
        HashMap param = JSONUtil.parse(form).toBean(HashMap.class);
        param.put("start", start);
        PageUtils userList = userService.getUserList(param);
        return Result.build(ResultCodeEnum.SUCCESS, userList);
    }

    @PostMapping("/insert")
//    @SaCheckPermission(value = {"ROOT", "USER:INSERT"}, mode = SaMode.OR)
    @Operation(summary = "添加用户")
    public Result<Boolean> insert(@Valid @RequestBody InsertUserForm form) {
        User user = new User();
        BeanUtils.copyProperties(form, user);
        String encryptPassword = DigestUtil.sha1Hex(form.getPassword());
        user.setPassword(encryptPassword);
        user.setRole(JSONUtil.parseArray(form.getRole()).toString());
        boolean result = userService.insert(user);
        if (result) {
            return Result.build(200, "添加成功", result);
        }
        return Result.build(500, "添加失败", result);
    }

    @PostMapping("/update")
//    @SaCheckPermission(value = {"ROOT", "USER:INSERT"}, mode = SaMode.OR)
    @Operation(summary = "修改用户")
    public Result<Boolean> update(@Valid @RequestBody UpdateUserForm form) {
        HashMap param = JSONUtil.parse(form).toBean(HashMap.class);
        param.replace("role", JSONUtil.parseArray(form.getRole()).toString());
        boolean result = userService.update(param);
        if (result) {
            return Result.build(200, "修改成功", result);
        }
        return Result.build(500, "修改失败", result);
    }

    @DeleteMapping("/delete")
    public Result<Boolean> delete(@RequestBody Integer[] id) {
        boolean result = userService.delete(id);
        if (result) {
            return Result.build(200, "删除成功", result);
        }
        return Result.build(500, "删除失败", result);
    }

    @PostMapping("/upload")
    @Operation(summary = "上传文件")
    public Result<String> upload(MultipartFile file) {
        String url = cosClientConfig.uploadFile(file);
        return Result.build(200, "上传成功", url);
    }

}
