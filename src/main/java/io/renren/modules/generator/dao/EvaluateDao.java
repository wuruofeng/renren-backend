package io.renren.modules.generator.dao;

import io.renren.modules.generator.dto.EvaluateDetailRspDTO;
import io.renren.modules.generator.entity.EvaluateEntity;
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
public interface EvaluateDao extends BaseMapper<EvaluateEntity> {
    EvaluateEntity selectByRelateId(@Param("relateId") Integer relateId);
    List<Integer> selectEvaluateId();
    Integer selectEvaluatePartOneById(@Param("evaluateId") Integer evaluateId);
    Integer selectEvaluatePartTwoById(@Param("evaluateId") Integer evaluateId);
    Integer selectEvaluatePartThreeById(@Param("evaluateId") Integer evaluateId);
    Integer selectEvaluatePartFourById(@Param("evaluateId") Integer evaluateId);
    Integer selectEvaluatePartFiveById(@Param("evaluateId") Integer evaluateId);
    Integer selectEvaluatePartSixById(@Param("evaluateId") Integer evaluateId);
    Integer selectEvaluatePartSevenById(@Param("evaluateId") Integer evaluateId);
    Integer selectEvaluateSumById(@Param("evaluateId") Integer evaluateId);
    Integer selectUserIdByEvaluateId(@Param("evaluateId") Integer evaluateId);
    Integer selectUnionIdByEvaluateId(@Param("evaluateId") Integer evaluateId);
}
