package io.renren.modules.generator.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassInfoRspDTO {
    @ApiModelProperty(value = "主键")
    private Integer classId;

    @ApiModelProperty(value = "专业")
    private String classSpeciality;

    @ApiModelProperty(value = "年级" )
    private String classGrade;

    @ApiModelProperty(value = "班级")
    private String className;
}
