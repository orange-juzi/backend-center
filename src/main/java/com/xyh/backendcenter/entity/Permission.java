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
 * @TableName tb_permission
 */
@TableName(value ="tb_permission")
@Data
@Schema(description = "权限实体类")
public class Permission implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @Schema(description = "权限id")
    private Integer id;

    /**
     * 权限
     */
    @Schema(description = "权限")
    private String permissionName;

    /**
     * 菜单ID
     */
    @Schema(description = "菜单ID")
    private Integer menuId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}