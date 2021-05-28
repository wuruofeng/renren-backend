package io.renren.modules.generator.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * 评价表详情DTO
 */
public class EvaluateDetailRspDTO {
    /**
     * 逻辑主键
     */
    @ApiModelProperty(value = "逻辑主键")
    private Integer evaluateId;

    @ApiModelProperty(value = "课堂内容摘要")
    private String courseAbstract;

    @ApiModelProperty(value = "")
    private Integer evaluatePartOne;

    private Integer evaluatePartTwo;

    private Integer evaluatePartThree;

    private Integer evaluatePartFour;

    private Integer evaluatePartFive;

    private Integer evaluatePartSix;

    private Integer evaluatePartSeven;

    private Integer evaluateSum;

    private String suggest;

    private TeacherInfoRspDTO teacherInfoRspDTO;
    private CourseInfoRspDTO courseInfoRspDTO;
    private ClassInfoRspDTO classInfoRspDTO;
    private ClassroomInfoRspDTO classroomInfoRspDTO;







}
