package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-09 18:02:48
 */
@Data
@TableName("evaluate")
public class EvaluateEntity implements Serializable {
	private static final long serialVersionUID = 1L;


	/**
	 * 
	 */
	@TableId
	private Integer evaluateId;
	/**
	 * 
	 */
	private Integer unionId;
	/**
	 * 分配的督导员id
	 */
	private Integer userId;

	/**
	 * 教书育人（10）
	 */
	private Integer evaluatePartOne;
	/**
	 * 教学态度（10）
	 */
	private Integer evaluatePartTwo;
	/**
	 * 教学内容（20)
	 */
	private Integer evaluatePartThree;
	/**
	 * 教学方法（20)
	 */
	private Integer evaluatePartFour;
	/**
	 * 教学组织（20）
	 */
	private Integer evaluatePartFive;
	/**
	 * 教学表达（10）
	 */
	private Integer evaluatePartSix;
	/**
	 * 总体效果（10）
	 */
	private Integer evaluatePartSeven;
	/**
	 * 合计（100）
	 */
	private Integer evaluateSum;
	/**
	 * 评价与建议
	 */
	private String suggest;
	/**
	 * 课堂内容概括
	 */
	private String courseAbstract;
	/**
	 * 任务分配ID
	 */
	private Integer relateId;

}
