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

import io.renren.modules.generator.entity.SupervisePicEntity;
import io.renren.modules.generator.service.SupervisePicService;
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
@RequestMapping("generator/supervisepic")
public class SupervisePicController {
    @Autowired
    private SupervisePicService supervisePicService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("generator:supervisepic:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = supervisePicService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:supervisepic:info")
    public R info(@PathVariable("id") Integer id){
		SupervisePicEntity supervisePic = supervisePicService.getById(id);

        return R.ok().put("supervisePic", supervisePic);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:supervisepic:save")
    public R save(@RequestBody SupervisePicEntity supervisePic){
		supervisePicService.save(supervisePic);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:supervisepic:update")
    public R update(@RequestBody SupervisePicEntity supervisePic){
		supervisePicService.updateById(supervisePic);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:supervisepic:delete")
    public R delete(@RequestBody Integer[] ids){
		supervisePicService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
