package io.renren.modules.generator.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
//督导员个人督导任务
public class SupervisorTaskReqDTO {
    @ApiModelProperty(value = "课程名称")
    private String courseName;

    @ApiModelProperty(value = "老师名字")
    private String teacherName;

    @ApiModelProperty(value = "教室地址")
    private String classroomNum;

    @ApiModelProperty(value = "日期")
    private Date date;

    @ApiModelProperty(value = "年级")
    private String classGrade;

    @ApiModelProperty(value = "专业")
    private String classSpeciality;

    @ApiModelProperty(value = "班级名称")
    private String className;


}
