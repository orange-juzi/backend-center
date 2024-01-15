package com.xyh.backendcenter.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
@Schema(description = "查询用户分页记录表单")
public class SearchUserByPageForm {
    @NotNull(message = "page不能为空")
    @Min(value = 1, message = "page不能小于1")
    @Schema(description = "页数")
    private Integer current;

    @NotNull(message = "length不能为空")
    @Range(min = 10, max = 50, message = "length必须在10~50之间")
    @Schema(description = "每页记录数")
    private Integer pageSize;

    @Pattern(regexp = "^[\\u4e00-\\u9fa5]{1,10}$", message = "昵称不正确")
    @Schema(description = "昵称")
    private String nickname;

    @Pattern(regexp = "^男$|^女$", message = "性别不正确")
    @Schema(description = "性别")
    private String sex;

    @Pattern(regexp = "^[a-zA-Z0-9\\u4e00-\\u9fa5]{2,10}$", message = "角色不正确")
    @Schema(description = "角色")
    private String role;

    @Min(value = 1, message = "dept不能小于1")
    @Schema(description = "部门")
    private Integer deptId;

    @Min(value = 1, message = "status不能小于1")
    private Integer status;

}