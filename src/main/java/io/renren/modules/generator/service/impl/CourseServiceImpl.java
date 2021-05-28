package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.CourseDao;
import io.renren.modules.generator.entity.CourseEntity;
import io.renren.modules.generator.service.CourseService;

import javax.annotation.Resource;


@Service("courseService")
public class CourseServiceImpl extends ServiceImpl<CourseDao, CourseEntity> implements CourseService {

    @Resource
    CourseDao courseDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CourseEntity> page = this.page(
                new Query<CourseEntity>().getPage(params),
                new QueryWrapper<CourseEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<String> listName() {
        List<String> list = courseDao.selectCourseName();
        return list;
    }

}