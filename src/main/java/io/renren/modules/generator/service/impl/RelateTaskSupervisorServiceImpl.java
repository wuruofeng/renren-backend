package io.renren.modules.generator.service.impl;

import io.renren.modules.sys.entity.SysUserEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.RelateTaskSupervisorDao;
import io.renren.modules.generator.entity.RelateTaskSupervisorEntity;
import io.renren.modules.generator.service.RelateTaskSupervisorService;


@Service("relateTaskSupervisorService")
public class RelateTaskSupervisorServiceImpl extends ServiceImpl<RelateTaskSupervisorDao, RelateTaskSupervisorEntity> implements RelateTaskSupervisorService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RelateTaskSupervisorEntity> page = this.page(
                new Query<RelateTaskSupervisorEntity>().getPage(params),
                new QueryWrapper<RelateTaskSupervisorEntity>()
        );

        return new PageUtils(page);
    }


    @Override
    public List<RelateTaskSupervisorEntity> queryByUserId(Integer user_id) {
        return (List<RelateTaskSupervisorEntity>) baseMapper.queryByUserId(user_id);
    }

}