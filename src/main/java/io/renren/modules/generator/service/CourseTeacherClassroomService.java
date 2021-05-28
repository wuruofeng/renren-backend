package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.CourseTeacherClassroomEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-09 18:02:48
 */
public interface CourseTeacherClassroomService extends IService<CourseTeacherClassroomEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

