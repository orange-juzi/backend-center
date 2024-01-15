package com.xyh.backendcenter.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xyh.backendcenter.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
* @author xiaoxie
* @description 针对表【tb_user(用户表)】的数据库操作Mapper
* @createDate 2024-01-05 16:50:09
* @Entity backend-center.entity.TbUser
*/
public interface UserMapper extends BaseMapper<User> {

    List<String> searchUserPermission(@Param("userId") int userId);

    List<HashMap> getUserList(HashMap map);

    public long searchUserCount(HashMap map);

    public int insert(User user);

    int update(HashMap param);
}




