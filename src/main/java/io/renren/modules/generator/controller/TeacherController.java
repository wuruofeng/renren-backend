package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.renren.modules.generator.dto.TeacherIdNameRspDTO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.TeacherEntity;
import io.renren.modules.generator.service.TeacherService;
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
@RequestMapping("generator/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("generator:teacher:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = teacherService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 教师姓名列表
     */
    @RequestMapping("/listName")
    public List<String> listTeacherName(){
        List<String> teacherList = teacherService.listTeacherName();
        return teacherList;
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:teacher:info")
    public R info(@PathVariable("id") Integer id){
		TeacherEntity teacher = teacherService.getById(id);

        return R.ok().put("teacher", teacher);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:teacher:save")
    public R save(@RequestBody TeacherEntity teacher){
		teacherService.save(teacher);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:teacher:update")
    public R update(@RequestBody TeacherEntity teacher){
		teacherService.updateById(teacher);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:teacher:delete")
    public R delete(@RequestBody Integer[] ids){
		teacherService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 教师ID+教师姓名
     */
    @RequestMapping("/listTeachers")
    public List<TeacherIdNameRspDTO> listTeachers(){
        List<TeacherIdNameRspDTO> list = teacherService.listTeachers();
        return list;
    }

}
