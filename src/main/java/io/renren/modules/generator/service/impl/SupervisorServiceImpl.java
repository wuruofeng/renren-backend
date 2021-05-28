package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.SupervisorDao;
import io.renren.modules.generator.entity.SupervisorEntity;
import io.renren.modules.generator.service.SupervisorService;


@Service("supervisorService")
public class SupervisorServiceImpl extends ServiceImpl<SupervisorDao, SupervisorEntity> implements SupervisorService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SupervisorEntity> page = this.page(
                new Query<SupervisorEntity>().getPage(params),
                new QueryWrapper<SupervisorEntity>()
        );

        return new PageUtils(page);
    }

}