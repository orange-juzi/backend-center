package com.xyh.backendcenter.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

@Schema(description = "添加用户表单")
@Data
public class InsertUserForm {

    @NotBlank(message = "username不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9]{5,20}$", message = "username内容不正确")
    @Schema(description = "账号")
    private String username;

    @NotBlank(message = "password不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9]{6,20}$", message = "password内容不正确")
    @Schema(description = "密码")
    private String password;

    @NotBlank(message = "nickname不能为空")
    @Schema(description = "昵称")
    private String nickname;

    @NotBlank(message = "photo不能为空")
    @Schema(description = "头像")
    private String photo;

    @NotBlank(message = "sex不能为空")
    @Pattern(regexp = "^男$|^女$", message = "sex内容不正确")
    @Schema(description = "性别")
    private String sex;

    @NotBlank(message = "tel不能为空")
    @Pattern(regexp = "^1\\d{10}$", message = "tel内容不正确")
    @Schema(description = "电话")
    private String tel;

    @NotEmpty(message = "role不能为空")
    @Schema(description = "角色")
    private Integer[] role;

    @NotNull(message = "deptId不能为空")
    @Min(value = 1, message = "deptId不能小于1")
    @Schema(description = "部门")
    private Integer deptId;

    @Min(value = 1, message = "status不能小于1")
    private Integer status;

}
