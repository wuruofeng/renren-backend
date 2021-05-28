package io.renren.modules.generator.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RelateTaskSupervisorRspDTO {
    private Integer relateTaskSupervisorId;
    private Integer teacherId;
    private String teacherName;
    private Integer courseId;
    private String courseName;
    private Integer classroomId;
    private String classroomNum;
    private Integer userId;
    private String userFullname;
    private String isFinish;
    private Date time;
}
