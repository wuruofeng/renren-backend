package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.modules.generator.dto.EvaluateDetailRspDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.EvaluateEntity;
import io.renren.modules.generator.service.EvaluateService;
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
@RequestMapping("generator/evaluate")
@Api("Evaluate")
public class EvaluateController {
    @Autowired
    private EvaluateService evaluateService;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @RequestMapping("/list")
//    @RequiresPermissions("generator:evaluate:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = evaluateService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @ApiOperation("查询")
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:evaluate:info")
    public R info(@PathVariable("id") Integer id){
		EvaluateEntity evaluate = evaluateService.getById(id);

        return R.ok().put("evaluate", evaluate);
    }

    @ApiOperation("保存")
    @RequestMapping("/save")
//    @RequiresPermissions("generator:evaluate:save")
    public R save(@RequestBody EvaluateEntity evaluate){
        evaluateService.saveEvaluateEntity(evaluate);

        return R.ok();
    }


    @ApiOperation("查询评价表细节")
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id){
        EvaluateDetailRspDTO evaluateDetailRspDTO = evaluateService.getDetailById(id);
        return R.ok().put("evaluateDetailRspDTO", evaluateDetailRspDTO);
    }

    @ApiOperation("grelate_id查询评价表细节")
    @RequestMapping("/relatedetail/{relateId}")
    public R detailBydetail(@PathVariable("relateId") Integer relateId){
        EvaluateDetailRspDTO evaluateDetailRspDTO = evaluateService.getDetailByRelateId(relateId);
        return R.ok().put("evaluateDetailRspDTO", evaluateDetailRspDTO);
    }

    /**
     * 保存
     */
//    @ApiOperation("保存")
//    @RequestMapping("/save")
//    @RequiresPermissions("generator:evaluate:save")
//    public R save(@RequestBody EvaluateEntity evaluate){
//		evaluateService.save(evaluate);
//
//        return R.ok();
//    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @RequestMapping("/update")
    @RequiresPermissions("generator:evaluate:update")
    public R update(@RequestBody EvaluateEntity evaluate){
		evaluateService.updateById(evaluate);

        return R.ok();
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @RequestMapping("/delete")
    @RequiresPermissions("generator:evaluate:delete")
    public R delete(@RequestBody Integer[] ids){
		evaluateService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
