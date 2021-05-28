package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.dto.RelateTaskSupervisorRspDTO;
import io.renren.modules.generator.entity.RelateTaskSupervisorEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-25 13:10:39
 */
public interface RelateTaskSupervisorService extends IService<RelateTaskSupervisorEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<RelateTaskSupervisorRspDTO> listItems();
}

