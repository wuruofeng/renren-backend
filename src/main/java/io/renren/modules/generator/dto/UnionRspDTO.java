package io.renren.modules.generator.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnionRspDTO {
    private Integer unionId;

    private Integer teacherId;
    private String teacherName;

    private Integer courseId;
    private String courseName;

    private Integer classId;
    private String classGrade;
    private String classSpeciality;
    private String className;

    private Integer classroomId;
    private String classroomNum;
//    private String courseName;
//    private CourseInfoRspDTO courseInfoRspDTO;
//    private TeacherInfoRspDTO teacherInfoRspDTO;
//    private ClassroomInfoRspDTO classroomInfoRspDTO;
    private String week;
    private String orderNum;
}
