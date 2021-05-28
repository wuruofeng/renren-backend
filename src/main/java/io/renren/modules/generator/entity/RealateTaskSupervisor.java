package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("relate_task_supervisor")
public class RealateTaskSupervisor implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    private Integer relateId;

    private Integer userId;

    private Integer taskId;



}
