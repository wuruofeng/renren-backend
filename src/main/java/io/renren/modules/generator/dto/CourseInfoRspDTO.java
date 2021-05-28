package io.renren.modules.generator.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseInfoRspDTO {

    @ApiModelProperty(value = "主键")
    private Integer courseId;

    @ApiModelProperty(value = "课程名")
    private String courseName;

    @ApiModelProperty(value = "课程承担系、部")
    private String courseDepartment;




}
