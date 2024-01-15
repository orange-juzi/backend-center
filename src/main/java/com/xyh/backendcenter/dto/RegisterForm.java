package com.xyh.backendcenter.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(description = "注册表单类")
public class RegisterForm {

    @NotBlank(message = "用户名不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9]{5,20}$", message = "用户名在5-20个字符之间")
    @Schema(description = "用户名")
    private String username;

    @NotBlank(message = "password不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9]{6,20}$", message = "密码在6-20个字符之间")
    @Schema(description = "密码")
    private String password;

    @NotBlank(message = "checkPassword不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9]{6,20}$", message = "确认密码在6-20个字符之间")
    @Schema(description = "确认密码")
    private String checkPassword;
}
