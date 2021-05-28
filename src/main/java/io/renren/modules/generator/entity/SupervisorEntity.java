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
@TableName("supervisor")
public class SupervisorEntity implements Serializable {
	private static final long serialVersionUID = 1L;


	/**
	 * 
	 */
	private Integer supervisorId;
	/**
	 * 
	 */
	private String supervisorName;

}
