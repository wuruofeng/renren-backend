package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.ClassroomEntity;
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
public interface ClassroomDao extends BaseMapper<ClassroomEntity> {
    String selectClassroomNumByClassroomId(@Param("classroomId") Integer classroomId);

    List<String> selectClassroomNum();
}
