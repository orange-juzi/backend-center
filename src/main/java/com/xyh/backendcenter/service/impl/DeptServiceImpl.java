package com.xyh.backendcenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyh.backendcenter.entity.Dept;
import com.xyh.backendcenter.service.DeptService;
import com.xyh.backendcenter.mapper.DeptMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author xiaoxie
* @description 针对表【tb_dept】的数据库操作Service实现
* @createDate 2024-01-05 18:48:51
*/
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept>
    implements DeptService{

    @Override
    public List<Dept> searchDeptList() {
        List<Dept> list = this.list(new QueryWrapper<>());
        return list;
    }
}




