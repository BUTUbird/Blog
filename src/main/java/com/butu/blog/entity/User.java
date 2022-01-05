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

import javax.validation.constraints.Email;
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
@TableName("m_user")
//@ApiModel(value = "MUser对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @NotBlank(message = "昵称不能为空")
    @TableField("username")
    private String username;

    @TableField("avatar")
    private String avatar;

    @NotBlank(message = "邮箱不能为空")
    @Email(message="邮箱格式不正确")
    @TableField("email")
    private String email;

    @TableField("password")
    private String password;

    @TableField("status")
    private Integer status;

    @TableField("created")
    private LocalDateTime created;

    @TableField("last_login")
    private LocalDateTime lastLogin;


}
