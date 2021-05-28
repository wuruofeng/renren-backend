package io.renren.modules.generator.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherInfoRspDTO {
    @ApiModelProperty(value = "主键")
    private Integer teacherId;

    @ApiModelProperty(value = "教师姓名")
    private String teacherName;

    @ApiModelProperty(value = "教师职称")
    private String teacherTitle;

    @ApiModelProperty(value = "教师所属系、部")
    private String teacherDepartment;
}
