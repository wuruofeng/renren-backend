package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.EvaluateEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-09 18:02:48
 */
@Mapper
public interface EvaluateDao extends BaseMapper<EvaluateEntity> {
    EvaluateEntity selectByRelateId(@Param("relateId") Integer relateId);
}
