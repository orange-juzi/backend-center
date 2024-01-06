package com.xyh.backendcenter.config;

import cn.dev33.satoken.stp.StpInterface;
import com.xyh.backendcenter.entity.Permission;
import com.xyh.backendcenter.mapper.UserMapper;
import com.xyh.backendcenter.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class StpInterfaceImpl implements StpInterface {
    @Resource
    private UserService userService;

    /**
     * 返回一个用户所拥有的权限集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        int userId = Integer.parseInt(loginId.toString());
        List<String> permissions = userService.searchUserPermission(userId);
        List list = new ArrayList();
        list.addAll(permissions);
        return list;
    }

    /**
     * 返回一个用户所拥有的角色标识集合
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginKey) {
        //因为本项目不需要用到角色判定，所以这里就返回一个空的ArrayList对象
        return new ArrayList<>();
    }
}
