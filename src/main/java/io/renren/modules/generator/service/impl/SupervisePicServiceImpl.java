package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.SupervisePicDao;
import io.renren.modules.generator.entity.SupervisePicEntity;
import io.renren.modules.generator.service.SupervisePicService;


@Service("supervisePicService")
public class SupervisePicServiceImpl extends ServiceImpl<SupervisePicDao, SupervisePicEntity> implements SupervisePicService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SupervisePicEntity> page = this.page(
                new Query<SupervisePicEntity>().getPage(params),
                new QueryWrapper<SupervisePicEntity>()
        );

        return new PageUtils(page);
    }

}