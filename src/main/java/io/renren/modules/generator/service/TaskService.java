package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.dto.TaskListRspDTO;
import io.renren.modules.generator.entity.TaskEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-13 17:46:19
 */
public interface TaskService extends IService<TaskEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils searchByUserId(Map<String, Object> id);

    List<TaskListRspDTO> listTask();

    boolean deleteByIds(List<Integer> ids);
}

