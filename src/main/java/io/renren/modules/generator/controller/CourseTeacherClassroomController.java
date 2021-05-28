package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.renren.modules.generator.dto.UnionRspDTO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.CourseTeacherClassroomEntity;
import io.renren.modules.generator.service.CourseTeacherClassroomService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-09 18:02:48
 */
@RestController
@RequestMapping("generator/courseteacherclassroom")
public class CourseTeacherClassroomController {
    @Autowired
    private CourseTeacherClassroomService courseTeacherClassroomService;

    /**
     * 列表
     */
//    @RequestMapping("/list")
//    @RequiresPermissions("generator:courseteacherclassroom:list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = courseTeacherClassroomService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }

    @RequestMapping("/list")
    @RequiresPermissions("generator:courseteacherclassroom:list")
    public List<UnionRspDTO> list(){
        List<UnionRspDTO> unionRspDTOS = courseTeacherClassroomService.listUnionCousrse();
        return unionRspDTOS;
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:courseteacherclassroom:info")
    public R info(@PathVariable("id") Integer id){
		CourseTeacherClassroomEntity courseTeacherClassroom = courseTeacherClassroomService.getById(id);

        return R.ok().put("courseTeacherClassroom", courseTeacherClassroom);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:courseteacherclassroom:save")
    public R save(@RequestBody CourseTeacherClassroomEntity courseTeacherClassroom){
		courseTeacherClassroomService.save(courseTeacherClassroom);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:courseteacherclassroom:update")
    public R update(@RequestBody CourseTeacherClassroomEntity courseTeacherClassroom){
		courseTeacherClassroomService.updateById(courseTeacherClassroom);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:courseteacherclassroom:delete")
    public R delete(@RequestBody Integer[] ids){
		courseTeacherClassroomService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
