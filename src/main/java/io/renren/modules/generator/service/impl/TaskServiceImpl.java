package io.renren.modules.generator.service.impl;

import io.renren.modules.generator.dao.*;
import io.renren.modules.generator.dto.SupervisorTaskReqDTO;
import io.renren.modules.generator.dto.TaskListRspDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.entity.TaskEntity;
import io.renren.modules.generator.service.TaskService;
import sun.java2d.pipe.SpanClipRenderer;

import javax.annotation.Resource;


@Service("taskService")
public class TaskServiceImpl extends ServiceImpl<TaskDao, TaskEntity> implements TaskService {

    @Resource
    TaskDao taskDao;
    @Resource
    TeacherDao teacherDao;
    @Resource
    CourseDao courseDao;
    @Resource
    ClassroomDao classroomDao;
    @Resource
    CourseTeacherClassroomDao courseTeacherClassroomDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TaskEntity> page = this.page(
                new Query<TaskEntity>().getPage(params),
                new QueryWrapper<TaskEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils searchByUserId(Map<String, Object> params) {
        IPage<TaskEntity> page = this.page(
                new Query<TaskEntity>().getPage(params),
                new QueryWrapper<TaskEntity>()
        );
        return null;
    }

    @Override
    public List<TaskListRspDTO> listTask() {
        List<TaskListRspDTO> taskListRspDTOS = new ArrayList<>();
        //查出所有taskId
        List<Integer> taskIds = taskDao.selectTaskIds();
        //根据每一个taskId查出所有课程表、教师、教室、课程信息
        for (Integer taskId : taskIds){
            TaskListRspDTO taskListRspDTO = new TaskListRspDTO();
            taskListRspDTO.setTaskId(taskId);
            Integer unionId = taskDao.selectUnionId(taskId);
            //根据unionId查出teacherId、courseId、classroomId
            Integer teacherId = courseTeacherClassroomDao.selectTeacherIdByUnionId(unionId);
            Integer courseId = courseTeacherClassroomDao.selectCourseIdByUnionId(unionId);
            Integer classroomId = courseTeacherClassroomDao.selectClassroomIdByUnionId(unionId);
            //课次、日期
            String orderNum = courseTeacherClassroomDao.selectOrderNumByUnionId(unionId);
            Date time = taskDao.selectTimeByTaskId(taskId);
            taskListRspDTO.setOrderNum(orderNum);
            taskListRspDTO.setTime(time);
            //教师
            String teacherName = teacherDao.selectTeacherNameByTeacherId(teacherId);
            taskListRspDTO.setTeacherId(teacherId);
            taskListRspDTO.setTeacherName(teacherName);
            //课程
            String courseName = courseDao.selectCourseNameByCourseId(courseId);
            taskListRspDTO.setCourseId(courseId);
            taskListRspDTO.setCourseName(courseName);
            //教室
            String classroomNum = classroomDao.selectClassroomNumByClassroomId(classroomId);
            taskListRspDTO.setClassroomId(classroomId);
            taskListRspDTO.setClassroomNum(classroomNum);

            taskListRspDTOS.add(taskListRspDTO);
        }
        return taskListRspDTOS;
    }

    @Override
    public boolean deleteByIds(List<Integer> ids) {
        if (ids.isEmpty()){
            return false;
        }
        for (Integer id : ids){
            taskDao.deleteById(id);
        }
        return true;
    }


}