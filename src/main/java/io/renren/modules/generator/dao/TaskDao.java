package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.TaskEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-13 17:46:19
 */
@Mapper
public interface TaskDao extends BaseMapper<TaskEntity> {
    List<Integer> selectTaskIds();
    Integer selectUnionId(@Param("taskId") Integer taskId);
    Date selectTimeByTaskId(@Param("taskId") Integer taskId);
}
