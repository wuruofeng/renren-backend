package io.renren.modules.generator.service.impl;

import io.renren.modules.generator.dto.TeacherIdNameRspDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.TeacherDao;
import io.renren.modules.generator.entity.TeacherEntity;
import io.renren.modules.generator.service.TeacherService;

import javax.annotation.Resource;


@Service("teacherService")
public class TeacherServiceImpl extends ServiceImpl<TeacherDao, TeacherEntity> implements TeacherService {

    @Resource
    private TeacherDao teacherDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TeacherEntity> page = this.page(
                new Query<TeacherEntity>().getPage(params),
                new QueryWrapper<TeacherEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<String> listTeacherName() {
        List<String> nameList = teacherDao.getTeacherNameList();
        return nameList;
    }

    @Override
    public List<TeacherIdNameRspDTO> listTeachers() {
        List<Integer> teacherIds = teacherDao.selectTeacherIds();
        List<TeacherIdNameRspDTO> list = new ArrayList<>();
        for (Integer teacherId : teacherIds){
            TeacherIdNameRspDTO teacherIdNameRspDTO = new TeacherIdNameRspDTO();
            teacherIdNameRspDTO.setTeacherId(teacherId);
            String teacherName = teacherDao.selectTeacherNameByTeacherId(teacherId);
            teacherIdNameRspDTO.setTeacherName(teacherName);

            list.add(teacherIdNameRspDTO);

        }
        return list;
    }


}