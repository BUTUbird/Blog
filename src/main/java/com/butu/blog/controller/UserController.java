package com.butu.blog.controller;


import com.butu.blog.common.lang.Result;
import com.butu.blog.common.lang.ResultInfo;
import com.butu.blog.entity.User;
import com.butu.blog.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author BUTUbird
 * @since 2022-01-04
 */
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @RequiresAuthentication
    @GetMapping("/list")
    public Result list(){
        User user = userService.getById(1);
        return Result.success().codeAndMessage(ResultInfo.SUCCESS).data("User",user);
    }
    @PostMapping("/save")
    public Result save(@Validated @RequestBody User user){
        return Result.success().codeAndMessage(ResultInfo.SUCCESS).data("user",user);
    }
}
