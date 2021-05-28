package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.generator.dto.EvaluateDetailRspDTO;
import io.renren.modules.generator.dto.EvaluateListDTO;
import io.renren.modules.generator.entity.EvaluateEntity;
import org.apache.velocity.runtime.directive.Evaluate;

import java.util.List;
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

    EvaluateDetailRspDTO getDetailByRelateId(Integer relateId);

    List<EvaluateListDTO> listAll();

    R saveEvaluateEntity(EvaluateEntity evaluateEntity);
}

