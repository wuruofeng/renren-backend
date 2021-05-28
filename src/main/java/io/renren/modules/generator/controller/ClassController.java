package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.ClassEntity;
import io.renren.modules.generator.service.ClassService;
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
@RequestMapping("generator/class")
public class ClassController {
    @Autowired
    private ClassService classService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("generator:class:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = classService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:class:info")
    public R info(@PathVariable("id") Integer id){
		ClassEntity classEntity = classService.getById(id);

        return R.ok().put("class", classEntity);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:class:save")
    public R save(@RequestBody ClassEntity classEntity){
		classService.save(classEntity);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:class:update")
    public R update(@RequestBody ClassEntity classEntity){
		classService.updateById(classEntity);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:class:delete")
    public R delete(@RequestBody Integer[] ids){
		classService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
