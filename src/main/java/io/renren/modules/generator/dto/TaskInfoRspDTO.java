package io.renren.modules.generator.dto;

import cn.hutool.system.UserInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskInfoRspDTO {
    @ApiModelProperty(value = "任务ID")
    private Integer taskId;

    private CourseInfoRspDTO courseInfoRspDTO;

    private UserInfoRspDTO userInfoRspDTO;

}
