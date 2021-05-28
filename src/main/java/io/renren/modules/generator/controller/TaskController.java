package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import cn.hutool.db.Page;
import io.renren.modules.generator.dto.TaskListRspDTO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.TaskEntity;
import io.renren.modules.generator.service.TaskService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-13 17:46:19
 */
@RestController
@RequestMapping("generator/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    /**
     * 列表
     */
//    @RequestMapping("/list")
//    @RequiresPermissions("generator:task:list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = taskService.queryPage(params);
//        return R.ok().put("page", page);
//    }
    @RequestMapping("/list")
    @RequiresPermissions("generator:task:list")
    public List<TaskListRspDTO> list() {
        List<TaskListRspDTO> taskListRspDTOs = taskService.listTask();
        return taskListRspDTOs;
    }
    @RequestMapping("/list1")
//    @RequiresPermissions("generator:task:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = taskService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:task:info")
    public R info(@PathVariable("id") Integer id){
		TaskEntity task = taskService.getById(id);

        return R.ok().put("task", task);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:task:save")
    public R save(@RequestBody TaskEntity task){
		taskService.save(task);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:task:update")
    public R update(@RequestBody TaskEntity task){
		taskService.updateById(task);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:task:delete")
    public R delete(@RequestBody Integer[] ids){
		taskService.removeByIds(Arrays.asList(ids));
        taskService.deleteByIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 根据督导员ID查询
     */
    @RequestMapping("/searchByUserId")
    public R searchBySupervisorId(@RequestBody Map<String, Object> params){
        PageUtils page = taskService.searchByUserId(params);
        return R.ok().put("page", page);
    }

}
