package com.xyh.backendcenter.service;

import com.xyh.backendcenter.entity.Dept;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author xiaoxie
* @description 针对表【tb_dept】的数据库操作Service
* @createDate 2024-01-05 18:48:51
*/
public interface DeptService extends IService<Dept> {
    /**
     * 查询部门列表
     *
     * @return
     */
    List<Dept> searchDeptList();
}
