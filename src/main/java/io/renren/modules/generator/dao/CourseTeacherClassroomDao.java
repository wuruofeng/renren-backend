package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.CourseTeacherClassroomEntity;
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
public interface CourseTeacherClassroomDao extends BaseMapper<CourseTeacherClassroomEntity> {
    List<Integer> listUnionIds();
    Integer selectTeacherIdByUnionId(@Param("unionId") Integer unionId);
    Integer selectCourseIdByUnionId(@Param("unionId") Integer unionId);
    Integer selectClassIdByUnionId(@Param("unionId") Integer unionId);
    Integer selectClassroomIdByUnionId(@Param("unionId") Integer unionId);
    String selectWeekByUnionId(@Param("unionId") Integer unionId);
    String selectOrderNumByUnionId(@Param("unionId") Integer unionId);
}
