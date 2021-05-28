package io.renren.modules.generator.service.impl;

import io.renren.modules.generator.dao.*;
import io.renren.modules.generator.dto.*;
import org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.CourseTeacherClassroomDao;
import io.renren.modules.generator.entity.CourseTeacherClassroomEntity;
import io.renren.modules.generator.service.CourseTeacherClassroomService;

import javax.annotation.Resource;


@Service("courseTeacherClassroomService")
public class CourseTeacherClassroomServiceImpl extends ServiceImpl<CourseTeacherClassroomDao, CourseTeacherClassroomEntity> implements CourseTeacherClassroomService {

    @Resource
    CourseTeacherClassroomDao courseTeacherClassroomDao;
    @Resource
    TeacherDao teacherDao;
    @Resource
    ClassDao classDao;
    @Resource
    ClassroomDao classroomDao;
    @Resource
    CourseDao courseDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CourseTeacherClassroomEntity> page = this.page(
                new Query<CourseTeacherClassroomEntity>().getPage(params),
                new QueryWrapper<CourseTeacherClassroomEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<UnionRspDTO> listUnionCousrse() {
        List<UnionRspDTO> unionRspDTOs = new ArrayList<>();
        //查出所有union_id
        List<Integer> unionIds = courseTeacherClassroomDao.listUnionIds();
        //根据每一个union_id查出相应的teacherId、courseId、classId、classroomId
        for (Integer unionId: unionIds){
            UnionRspDTO unionRspDTO = new UnionRspDTO();
            unionRspDTO.setUnionId(unionId);
            //教师信息
            Integer teacherId = courseTeacherClassroomDao.selectTeacherIdByUnionId(unionId);
            String teacherName = teacherDao.selectTeacherNameByTeacherId(teacherId);
            unionRspDTO.setTeacherId(teacherId);
            unionRspDTO.setTeacherName(teacherName);
            //课程信息
            Integer courseId = courseTeacherClassroomDao.selectCourseIdByUnionId(unionId);
            String courseName = courseDao.selectCourseNameByCourseId(courseId);
            unionRspDTO.setCourseId(courseId);
            unionRspDTO.setCourseName(courseName);
            //班级信息
            Integer classId = courseTeacherClassroomDao.selectClassIdByUnionId(unionId);
            String classGrade = classDao.selectClassGradeByClassId(classId);
            String classSpeciality = classDao.selectClassSpecialityByClassId(classId);
            String className = classDao.selectClassNameByClassId(classId);
            unionRspDTO.setClassId(classId);
            unionRspDTO.setClassGrade(classGrade);
            unionRspDTO.setClassSpeciality(classSpeciality);
            unionRspDTO.setClassName(className);
            //教室信息
            Integer classroomId = courseTeacherClassroomDao.selectClassroomIdByUnionId(unionId);
            String classroomNum = classroomDao.selectClassroomNumByClassroomId(classroomId);
            unionRspDTO.setClassroomId(classroomId);
            unionRspDTO.setClassroomNum(classroomNum);

            String week = courseTeacherClassroomDao.selectWeekByUnionId(unionId);
            unionRspDTO.setWeek(week);
            String orderNum = courseTeacherClassroomDao.selectOrderNumByUnionId(unionId);
            unionRspDTO.setOrderNum(orderNum);

            unionRspDTOs.add(unionRspDTO);
        }

        return unionRspDTOs;
    }

}