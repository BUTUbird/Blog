package com.butu.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 
 * </p>
 *
 * @author BUTUbird
 * @since 2022-01-04
 */
@Getter
@Setter
@TableName("m_blog")
//@ApiModel(value = "MBlog对象", description = "")
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("user_id")
    private Long userId;

    @NotBlank(message = "标题不能为空")
    @TableField("title")
    private String title;

    @NotBlank(message = "摘要不能为空")
    @TableField("description")
    private String description;

    @NotBlank(message = "内容不能为空")
    @TableField("content")
    private String content;

    @TableField("created")
    private LocalDateTime created;

    @TableField("status")
    private Integer status;


}
