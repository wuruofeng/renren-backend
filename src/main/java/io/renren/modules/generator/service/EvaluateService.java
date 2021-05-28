package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.generator.dto.EvaluateDetailRspDTO;
import io.renren.modules.generator.entity.EvaluateEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-09 18:02:48
 */
public interface EvaluateService extends IService<EvaluateEntity> {

    PageUtils queryPage(Map<String, Object> params);

    EvaluateDetailRspDTO getDetailById(Integer id);
    EvaluateDetailRspDTO getDetailByRelateId(Integer relatedId);
    R saveEvaluateEntity(EvaluateEntity evaluateEntity);
}

