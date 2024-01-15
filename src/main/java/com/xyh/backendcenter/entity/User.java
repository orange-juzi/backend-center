package com.xyh.backendcenter.entity;


import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

/**
 * 用户表
 * @TableName tb_user
 */
@TableName(value ="tb_user")
@Data
@Schema(description = "用户表")
public class User implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @Schema(description = "用户ID")
    private Integer id;

    /**
     * 用户名
     */
    @Schema(description = "用户名")
    private String username;

    /**
     * 密码
     */
    @Schema(description = "密码")
    private String password;

    /**
     * 昵称
     */
    @Schema(description = "昵称")
    private String nickname;

    /**
     * 头像网址
     */
    @Schema(description = "photo")
    private String photo;

    /**
     * 姓名
     */
    @Schema(description = "姓名")
    private String name;

    /**
     * 性别
     */
    @Schema(description = "性别")
    private Object sex;

    /**
     * 手机号码
     */
    @Schema(description = "手机号码")
    private String tel;

    /**
     * 邮箱
     */
    @Schema(description = "邮箱")
    private String email;

    /**
     * 角色
     */
    @Schema(description = "角色集合")
    private String role;

    /**
     * 是否是超级管理员
     */
    @Schema(description = "是否是超级管理员")
    private Integer root;

    /**
     * 部门编号
     */
    @Schema(description = "部门编号")
    private Integer deptId;

    /**
     * 状态：1.在线，2.离线
     */
    @Schema(description = "状态")
    private Integer status;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 修改时间
     */
    @Schema(description = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 是否删除，0未删除，1已删除
     */
    @TableLogic
    @Schema(description = "是否删除")
    private Integer isDeleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}