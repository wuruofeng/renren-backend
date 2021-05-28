package io.renren.modules.generator.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassroomInfoRspDTO {
    @ApiModelProperty(value = "主键")
    private Integer classroomId;

    @ApiModelProperty(value = "教室")
    private String classroomNum;
}
