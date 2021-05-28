package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.renren.modules.generator.dao.RelateTaskSupervisorDao;
import io.renren.modules.generator.dto.RelateTaskSupervisorRspDTO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.RelateTaskSupervisorEntity;
import io.renren.modules.generator.service.RelateTaskSupervisorService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-25 13:10:39
 */
@RestController
@RequestMapping("generator/relatetasksupervisor")
public class RelateTaskSupervisorController {
    @Autowired
    private RelateTaskSupervisorService relateTaskSupervisorService;

    /**
     * 列表
     */
//    @RequestMapping("/list")
//    @RequiresPermissions("generator:relatetasksupervisor:list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = relateTaskSupervisorService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }
    @RequestMapping("/list")
    @RequiresPermissions("generator:relatetasksupervisor:list")
    public List<RelateTaskSupervisorRspDTO> list(){
        List<RelateTaskSupervisorRspDTO> relateTaskSupervisorRspDTOS = relateTaskSupervisorService.listItems();
        return relateTaskSupervisorRspDTOS;
    }

    @RequestMapping("/list1")
//    @RequiresPermissions("generator:relatetasksupervisor:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = relateTaskSupervisorService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{relateId}")
    @RequiresPermissions("generator:relatetasksupervisor:info")
    public R info(@PathVariable("relateId") Integer relateId){
		RelateTaskSupervisorEntity relateTaskSupervisor = relateTaskSupervisorService.getById(relateId);

        return R.ok().put("relateTaskSupervisor", relateTaskSupervisor);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:relatetasksupervisor:save")
    public R save(@RequestBody RelateTaskSupervisorEntity relateTaskSupervisor){
		relateTaskSupervisorService.save(relateTaskSupervisor);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:relatetasksupervisor:update")
    public R update(@RequestBody RelateTaskSupervisorEntity relateTaskSupervisor){
		relateTaskSupervisorService.updateById(relateTaskSupervisor);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:relatetasksupervisor:delete")
    public R delete(@RequestBody Integer[] relateIds){
		relateTaskSupervisorService.removeByIds(Arrays.asList(relateIds));

        return R.ok();
    }

}
