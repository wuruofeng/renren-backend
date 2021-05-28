package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.renren.modules.generator.dao.ClassroomDao;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.ClassroomEntity;
import io.renren.modules.generator.service.ClassroomService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;

import javax.annotation.Resource;


/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-09 18:02:48
 */
@RestController
@RequestMapping("generator/classroom")
public class ClassroomController {

    @Resource
    ClassroomDao classroomDao;

    @Autowired
    private ClassroomService classroomService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("generator:classroom:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = classroomService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 列表教室名
     */
    @RequestMapping("/listName")
    public List<String> listName(){
       List<String> list = classroomService.listName();

        return list;
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("generator:classroom:info")
    public R info(@PathVariable("id") Integer id){
		ClassroomEntity classroom = classroomService.getById(id);
        return R.ok().put("classroom", classroom);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:classroom:save")
    public R save(@RequestBody ClassroomEntity classroom){
		classroomService.save(classroom);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:classroom:update")
    public R update(@RequestBody ClassroomEntity classroom){
		classroomService.updateById(classroom);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:classroom:delete")
    public R delete(@RequestBody Integer[] ids){
		classroomService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
