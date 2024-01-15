package com.xyh.backendcenter.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 
 * @TableName tb_dept
 */
@TableName(value ="tb_dept")
@Data
@Schema(description = "部门实体类")
public class Dept implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @Schema(description = "部门id")
    private Integer id;

    /**
     * 部门名称
     */
    @Schema(description = "部门名称")
    private String deptName;

    /**
     * 部门电话
     */
    @Schema(description = "部门电话")
    private String tel;

    /**
     * 部门邮箱
     */
    @Schema(description = "部门邮箱")
    private String email;

    /**
     * 备注
     */
    @Schema(description = "备注")
    @TableField("`desc`")
    private String desc;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}