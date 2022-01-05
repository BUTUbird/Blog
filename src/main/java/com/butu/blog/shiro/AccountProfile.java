package com.butu.blog.shiro;


import lombok.Data;

import java.io.Serializable;

/**
 * @author BUTUbird
 */
@Data
public class AccountProfile implements Serializable {
    private Long id;


    private String username;


    private String avatar;


    private String email;
}
