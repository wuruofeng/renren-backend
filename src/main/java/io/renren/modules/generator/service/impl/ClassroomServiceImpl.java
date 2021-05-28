package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.ClassroomDao;
import io.renren.modules.generator.entity.ClassroomEntity;
import io.renren.modules.generator.service.ClassroomService;


@Service("classroomService")
public class ClassroomServiceImpl extends ServiceImpl<ClassroomDao, ClassroomEntity> implements ClassroomService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ClassroomEntity> page = this.page(
                new Query<ClassroomEntity>().getPage(params),
                new QueryWrapper<ClassroomEntity>()
        );

        return new PageUtils(page);
    }

}