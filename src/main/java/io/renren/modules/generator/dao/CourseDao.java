package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.CourseEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-09 18:02:48
 */
@Mapper
public interface CourseDao extends BaseMapper<CourseEntity> {
    String selectCourseNameByCourseId(@Param("courseId") Integer courseId);
    List<String> selectCourseName();


}
