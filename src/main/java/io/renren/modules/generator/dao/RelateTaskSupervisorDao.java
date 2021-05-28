package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.EvaluateEntity;
import io.renren.modules.generator.entity.RelateTaskSupervisorEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-25 13:10:39
 */
@Mapper
public interface RelateTaskSupervisorDao extends BaseMapper<RelateTaskSupervisorEntity> {
	List<Integer> selectRelateIds();
    Integer selectTaskIdByRelateId(@Param("relateId") Integer relateId);
    Integer selectUserIdByRelateId(@Param("relateId") Integer relateId);
    Integer selectStatusByRelateId(@Param("relateId") Integer relateId);
    int updateStatusByRelateId(@Param("relateId")Integer relateId);
}
