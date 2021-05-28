package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.RelateTaskSupervisorEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-25 13:10:39
 */
@Mapper
public interface RelateTaskSupervisorDao extends BaseMapper<RelateTaskSupervisorEntity> {

    RelateTaskSupervisorEntity queryByUserId(Integer user_id);
    int updateStatusByRelateId(@Param("relateId")Integer relateId);
}
