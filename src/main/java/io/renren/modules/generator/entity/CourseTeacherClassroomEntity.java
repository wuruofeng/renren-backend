package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-09 18:02:48
 */
@Data
@TableName("course_teacher_classroom")
public class CourseTeacherClassroomEntity implements Serializable {
	private static final long serialVersionUID = 1L;


	/**
	 * 
	 */
	@TableId
	private Integer unionId;
	/**
	 * 
	 */
	private Integer courseId;
	/**
	 * 
	 */
	private Integer teacherId;
	/**
	 * 
	 */
	private Integer classroomId;
	/**
	 * 日期
	 */
	private Date date;
	/**
	 * 课在周几
	 */
	private String week;
	/**
	 * 哪几节课
	 */
	private String orderNum;
	/**
	 * 课程ID
	 *
	 */
	private Integer classId;


}
