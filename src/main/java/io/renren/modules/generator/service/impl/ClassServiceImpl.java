package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.ClassDao;
import io.renren.modules.generator.entity.ClassEntity;
import io.renren.modules.generator.service.ClassService;


@Service("classService")
public class ClassServiceImpl extends ServiceImpl<ClassDao, ClassEntity> implements ClassService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ClassEntity> page = this.page(
                new Query<ClassEntity>().getPage(params),
                new QueryWrapper<ClassEntity>()
        );

        return new PageUtils(page);
    }

}