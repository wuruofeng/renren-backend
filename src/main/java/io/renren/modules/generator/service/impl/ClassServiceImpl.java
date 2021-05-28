package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.ClassDao;
import io.renren.modules.generator.entity.ClassEntity;
import io.renren.modules.generator.service.ClassService;

import javax.annotation.Resource;


@Service("classService")
public class ClassServiceImpl extends ServiceImpl<ClassDao, ClassEntity> implements ClassService {

    @Resource
    ClassDao classDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ClassEntity> page = this.page(
                new Query<ClassEntity>().getPage(params),
                new QueryWrapper<ClassEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<String> listName() {
        List<Integer> ids = classDao.selectClassId();
        List<String> list = new ArrayList<>();
        for (Integer id : ids){
            String classGrade = classDao.selectClassGradeByClassId(id);
            String classSpeciality = classDao.selectClassSpecialityByClassId(id);
            String className = classDao.selectClassNameByClassId(id);
            list.add(classGrade+classSpeciality+className);
        }
        return list;
    }

}