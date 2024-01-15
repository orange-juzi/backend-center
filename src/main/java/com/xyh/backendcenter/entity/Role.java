package com.xyh.backendcenter.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 角色表
 * @TableName tb_role
 */
@TableName(value ="tb_role")
@Data
@Schema(description = "角色表")
public class Role implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @Schema(description = "角色ID")
    private Integer id;

    /**
     * 角色名称
     */
    @Schema(description = "角色名称")
    private String roleName;

    /**
     * 权限集合
     */
    @Schema(description = "权限集合")
    private Object permissions;

    /**
     * 描述
     */
    @Schema(description = "描述")
    @TableField("`desc`")
    private String desc;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}