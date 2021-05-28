package io.renren.modules.generator.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TaskListRspDTO {
    private Integer taskId;
    private Integer teacherId;
    private String teacherName;
    private Integer courseId;
    private String courseName;
    private Integer classroomId;
    private String classroomNum;
    private Date time;
    private String orderNum;
}
