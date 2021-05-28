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
 * @date 2021-05-25 13:10:39
 */
@Data
@TableName("relate_task_supervisor")
public class RelateTaskSupervisorEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer relateId;
	/**
	 * 
	 */
	private Long userId;
	/**
	 * 
	 */
	private Integer taskId;

	private Integer status;

}
