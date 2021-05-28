package io.renren.modules.generator.service.impl;

import io.renren.common.utils.R;
import io.renren.modules.generator.dao.*;
import io.renren.modules.generator.dto.*;
import io.renren.modules.generator.entity.*;
import io.renren.modules.sys.dao.SysUserDao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.service.EvaluateService;

import javax.annotation.Resource;
//import tk.mybatis.mapper.entity.Example;
//import tk.mybatis.mapper.entity.Example;


@Service("evaluateService")
public class EvaluateServiceImpl extends ServiceImpl<EvaluateDao, EvaluateEntity> implements EvaluateService {

//    EvaluateMapper evaluateMapper;
//    TeacherMapper teacherMapper;
//    CourseTeacherClassroomMapper courseTeacherClassroomMapper;
//    ClassroomMapper classroomMapper;
//    CourseMapper courseMapper;
//    ClassMapper classMapper;
    @Resource
    EvaluateDao evaluateDao;
    @Resource
    TeacherDao teacherDao;
    @Resource
    ClassDao classDao;
    @Resource
    ClassroomDao classroomDao;
    @Resource
    CourseDao courseDao;
    @Resource
    CourseTeacherClassroomDao courseTeacherClassroomDao;
    @Resource
    SysUserDao sysUserDao;
    @Resource
    RelateTaskSupervisorDao relateTaskSupervisorDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<EvaluateEntity> page = this.page(
                new Query<EvaluateEntity>().getPage(params),
                new QueryWrapper<EvaluateEntity>()
        );
        return new PageUtils(page);

    }

    @Override
    public EvaluateDetailRspDTO getDetailById(Integer evaluateId) {

        //通过evaluateId查询得到指定评价表对象
        EvaluateEntity evaluateEntity = evaluateDao.selectById(evaluateId);
        //        通过评价表对象查出所需数据
        EvaluateDetailRspDTO evaluateDetailRspDTO = new EvaluateDetailRspDTO();
        evaluateDetailRspDTO.setCourseAbstract(evaluateEntity.getCourseAbstract());
        evaluateDetailRspDTO.setEvaluatePartOne(evaluateEntity.getEvaluatePartOne());
        evaluateDetailRspDTO.setEvaluatePartTwo(evaluateEntity.getEvaluatePartTwo());
        evaluateDetailRspDTO.setEvaluatePartThree(evaluateEntity.getEvaluatePartThree());
        evaluateDetailRspDTO.setEvaluatePartFour(evaluateEntity.getEvaluatePartFour());
        evaluateDetailRspDTO.setEvaluatePartFive(evaluateEntity.getEvaluatePartFive());
        evaluateDetailRspDTO.setEvaluatePartSix(evaluateEntity.getEvaluatePartSix());
        evaluateDetailRspDTO.setEvaluatePartSeven(evaluateEntity.getEvaluatePartSeven());
        evaluateDetailRspDTO.setEvaluateSum(evaluateEntity.getEvaluateSum());
        evaluateDetailRspDTO.setSuggest(evaluateEntity.getSuggest());

        //通过详细课程ID查出教师、教室、课程、班级的ID
        Integer unionId = evaluateEntity.getUnionId();
        CourseTeacherClassroomEntity courseTeacherClassroomEntity = courseTeacherClassroomDao.selectById(unionId);
        Integer teacherId = courseTeacherClassroomEntity.getTeacherId();
        Integer classroomId = courseTeacherClassroomEntity.getClassroomId();
        Integer courseId = courseTeacherClassroomEntity.getCourseId();
        Integer classId = courseTeacherClassroomEntity.getClassId();

        //教师
        TeacherEntity teacherEntity = teacherDao.selectById(teacherId);
        TeacherInfoRspDTO teacherInfoRspDTO = new TeacherInfoRspDTO();
        teacherInfoRspDTO.setTeacherId(teacherId);
        teacherInfoRspDTO.setTeacherName(teacherEntity.getTeacherName());
        teacherInfoRspDTO.setTeacherTitle(teacherEntity.getTeacherTitle());
        teacherInfoRspDTO.setTeacherDepartment(teacherEntity.getTeacherDepartment());
        //教室
        ClassroomEntity classroomEntity = classroomDao.selectById(classroomId);
        ClassroomInfoRspDTO classroomInfoRspDTO = new ClassroomInfoRspDTO();
        classroomInfoRspDTO.setClassroomId(classroomId);
        classroomInfoRspDTO.setClassroomNum(classroomEntity.getClassroomNum());

        //课程
        CourseEntity courseEntity = courseDao.selectById(courseId);
        CourseInfoRspDTO courseInfoRspDTO = new CourseInfoRspDTO();
        courseInfoRspDTO.setCourseId(courseId);
        courseInfoRspDTO.setCourseName(courseEntity.getCourseName());
        courseInfoRspDTO.setCourseDepartment(courseEntity.getCourseDepartment());

        //班级
        ClassEntity classEntity = classDao.selectById(classId);
        ClassInfoRspDTO classInfoRspDTO = new ClassInfoRspDTO();
        classInfoRspDTO.setClassId(classId);
        classInfoRspDTO.setClassGrade(classEntity.getClassGrade());
        classInfoRspDTO.setClassSpeciality(classEntity.getClassSpeciality());
        classInfoRspDTO.setClassName(classEntity.getClassName());

        evaluateDetailRspDTO.setTeacherInfoRspDTO(teacherInfoRspDTO);
        evaluateDetailRspDTO.setClassInfoRspDTO(classInfoRspDTO);
        evaluateDetailRspDTO.setClassroomInfoRspDTO(classroomInfoRspDTO);
        evaluateDetailRspDTO.setCourseInfoRspDTO(courseInfoRspDTO);

        return evaluateDetailRspDTO;


    }

    @Override
    public EvaluateDetailRspDTO getDetailByRelateId(Integer relateId) {
        //通过relateId查询得到指定评价表对象
        EvaluateEntity evaluateEntity = evaluateDao.selectByRelateId(relateId);
        //        通过评价表对象查出所需数据
        EvaluateDetailRspDTO evaluateDetailRspDTO = new EvaluateDetailRspDTO();
        evaluateDetailRspDTO.setCourseAbstract(evaluateEntity.getCourseAbstract());
        evaluateDetailRspDTO.setEvaluatePartOne(evaluateEntity.getEvaluatePartOne());
        evaluateDetailRspDTO.setEvaluatePartTwo(evaluateEntity.getEvaluatePartTwo());
        evaluateDetailRspDTO.setEvaluatePartThree(evaluateEntity.getEvaluatePartThree());
        evaluateDetailRspDTO.setEvaluatePartFour(evaluateEntity.getEvaluatePartFour());
        evaluateDetailRspDTO.setEvaluatePartFive(evaluateEntity.getEvaluatePartFive());
        evaluateDetailRspDTO.setEvaluatePartSix(evaluateEntity.getEvaluatePartSix());
        evaluateDetailRspDTO.setEvaluatePartSeven(evaluateEntity.getEvaluatePartSeven());
        evaluateDetailRspDTO.setEvaluateSum(evaluateEntity.getEvaluateSum());
        evaluateDetailRspDTO.setSuggest(evaluateEntity.getSuggest());

        //通过详细课程ID查出教师、教室、课程、班级的ID
        Integer unionId = evaluateEntity.getUnionId();
        CourseTeacherClassroomEntity courseTeacherClassroomEntity = courseTeacherClassroomDao.selectById(unionId);
        Integer teacherId = courseTeacherClassroomEntity.getTeacherId();
        Integer classroomId = courseTeacherClassroomEntity.getClassroomId();
        Integer courseId = courseTeacherClassroomEntity.getCourseId();
        Integer classId = courseTeacherClassroomEntity.getClassId();

        //教师
        TeacherEntity teacherEntity = teacherDao.selectById(teacherId);
        TeacherInfoRspDTO teacherInfoRspDTO = new TeacherInfoRspDTO();
        teacherInfoRspDTO.setTeacherId(teacherId);
        teacherInfoRspDTO.setTeacherName(teacherEntity.getTeacherName());
        teacherInfoRspDTO.setTeacherTitle(teacherEntity.getTeacherTitle());
        teacherInfoRspDTO.setTeacherDepartment(teacherEntity.getTeacherDepartment());

        //教室
        ClassroomEntity classroomEntity = classroomDao.selectById(classroomId);
        ClassroomInfoRspDTO classroomInfoRspDTO = new ClassroomInfoRspDTO();
        classroomInfoRspDTO.setClassroomId(classroomId);
        classroomInfoRspDTO.setClassroomNum(classroomEntity.getClassroomNum());

        //课程
        CourseEntity courseEntity = courseDao.selectById(courseId);
        CourseInfoRspDTO courseInfoRspDTO = new CourseInfoRspDTO();
        courseInfoRspDTO.setCourseId(courseId);
        courseInfoRspDTO.setCourseName(courseEntity.getCourseName());
        courseInfoRspDTO.setCourseDepartment(courseEntity.getCourseDepartment());

        //班级
        ClassEntity classEntity = classDao.selectById(classId);
        ClassInfoRspDTO classInfoRspDTO = new ClassInfoRspDTO();
        classInfoRspDTO.setClassId(classId);
        classInfoRspDTO.setClassGrade(classEntity.getClassGrade());
        classInfoRspDTO.setClassSpeciality(classEntity.getClassSpeciality());
        classInfoRspDTO.setClassName(classEntity.getClassName());

        evaluateDetailRspDTO.setTeacherInfoRspDTO(teacherInfoRspDTO);
        evaluateDetailRspDTO.setClassInfoRspDTO(classInfoRspDTO);
        evaluateDetailRspDTO.setClassroomInfoRspDTO(classroomInfoRspDTO);
        evaluateDetailRspDTO.setCourseInfoRspDTO(courseInfoRspDTO);

        return evaluateDetailRspDTO;
    }


    @Override
    public List<EvaluateListDTO> listAll() {
        //得到所有evaluateId
        List<Integer> evaluateIds = evaluateDao.selectEvaluateId();
        List<EvaluateListDTO> evaluateListDTOS = new ArrayList<>();
        //
        for (Integer evaluateId : evaluateIds){
            EvaluateListDTO evaluateListDTO = new EvaluateListDTO();
            //userId、unionId
            Integer userId = evaluateDao.selectUserIdByEvaluateId(evaluateId);
            Integer unionId = evaluateDao.selectUnionIdByEvaluateId(evaluateId);
            //userFullname
            String userFullname = sysUserDao.selectUserFullnameByUserId(userId);
            evaluateListDTO.setUserFullName(userFullname);
            //查出teacherName
            Integer teacherId = courseTeacherClassroomDao.selectTeacherIdByUnionId(unionId);
            String teacherName = teacherDao.selectTeacherNameByTeacherId(teacherId);
            evaluateListDTO.setTeacherName(teacherName);
            //courseName
            Integer courseId = courseTeacherClassroomDao.selectCourseIdByUnionId(unionId);
            String courseName = courseDao.selectCourseNameByCourseId(courseId);
            evaluateListDTO.setCourseName(courseName);
            //分数们
            Integer evaluatePartOne = evaluateDao.selectEvaluatePartOneById(evaluateId);
            Integer evaluatePartTwo = evaluateDao.selectEvaluatePartTwoById(evaluateId);
            Integer evaluatePartThree = evaluateDao.selectEvaluatePartThreeById(evaluateId);
            Integer evaluatePartFour = evaluateDao.selectEvaluatePartFourById(evaluateId);
            Integer evaluatePartFive = evaluateDao.selectEvaluatePartFiveById(evaluateId);
            Integer evaluatePartSix = evaluateDao.selectEvaluatePartSixById(evaluateId);
            Integer evaluatePartSeven = evaluateDao.selectEvaluatePartSevenById(evaluateId);
            Integer evaluateSum = evaluateDao.selectEvaluateSumById(evaluateId);
            evaluateListDTO.setEvaluatePartOne(evaluatePartOne);
            evaluateListDTO.setEvaluatePartTwo(evaluatePartTwo);
            evaluateListDTO.setEvaluatePartThree(evaluatePartThree);
            evaluateListDTO.setEvaluatePartFour(evaluatePartFour);
            evaluateListDTO.setEvaluatePartFive(evaluatePartFive);
            evaluateListDTO.setEvaluatePartSix(evaluatePartSix);
            evaluateListDTO.setEvaluatePartSeven(evaluatePartSeven);
            evaluateListDTO.setEvaluateSum(evaluateSum);

            evaluateListDTO.setEvaluateId(evaluateId);
            evaluateListDTOS.add(evaluateListDTO);

        }
        return evaluateListDTOS;
    }

    @Override
    public R saveEvaluateEntity(EvaluateEntity evaluateEntity) {
        evaluateDao.insert(evaluateEntity);
        Integer relateId = evaluateEntity.getRelateId();
        relateTaskSupervisorDao.updateStatusByRelateId(relateId);
        return R.ok();
    }

}