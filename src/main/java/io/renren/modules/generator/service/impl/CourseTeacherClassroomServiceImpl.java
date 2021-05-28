package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.CourseTeacherClassroomDao;
import io.renren.modules.generator.entity.CourseTeacherClassroomEntity;
import io.renren.modules.generator.service.CourseTeacherClassroomService;


@Service("courseTeacherClassroomService")
public class CourseTeacherClassroomServiceImpl extends ServiceImpl<CourseTeacherClassroomDao, CourseTeacherClassroomEntity> implements CourseTeacherClassroomService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CourseTeacherClassroomEntity> page = this.page(
                new Query<CourseTeacherClassroomEntity>().getPage(params),
                new QueryWrapper<CourseTeacherClassroomEntity>()
        );

        return new PageUtils(page);
    }

}