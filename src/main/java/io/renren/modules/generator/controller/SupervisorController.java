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

import io.renren.modules.generator.entity.SupervisorEntity;
import io.renren.modules.generator.service.SupervisorService;
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
@RequestMapping("generator/supervisor")
public class SupervisorController {
    @Autowired
    private SupervisorService supervisorService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("generator:supervisor:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = supervisorService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:supervisor:info")
    public R info(@PathVariable("id") Integer id){
		SupervisorEntity supervisor = supervisorService.getById(id);

        return R.ok().put("supervisor", supervisor);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:supervisor:save")
    public R save(@RequestBody SupervisorEntity supervisor){
		supervisorService.save(supervisor);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:supervisor:update")
    public R update(@RequestBody SupervisorEntity supervisor){
		supervisorService.updateById(supervisor);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:supervisor:delete")
    public R delete(@RequestBody Integer[] ids){
		supervisorService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
