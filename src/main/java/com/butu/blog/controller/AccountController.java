package com.butu.blog.controller;

import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.butu.blog.common.dto.LoginDto;
import com.butu.blog.common.lang.Result;
import com.butu.blog.common.lang.ResultInfo;
import com.butu.blog.entity.User;
import com.butu.blog.service.UserService;
import com.butu.blog.utils.JwtUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author BUTUbird
 */
@RestController
public class AccountController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtils jwtUtils;
    @PostMapping("/login")
    public Result login(@Validated @RequestBody LoginDto loginDto,HttpServletResponse response){
        User user = userService.getOne(new QueryWrapper<User>().eq("username", loginDto.getUsername()));
        Assert.notNull(user,"用户不存在");

        if(!user.getPassword().equals(SecureUtil.md5(loginDto.getPassword()))){
            return Result.error().codeAndMessage(ResultInfo.GLOBAL_ERROR).data("msg", "密码不正确");
        }

        String jwt = jwtUtils.generateToken(user.getId());


        response.setHeader("Authorization",jwt);
        response.setHeader("Access-control-Expose-Headers","Authorization" );
        return Result.success().codeAndMessage(ResultInfo.SUCCESS).data("msg", MapUtil.builder()
                .put("id", user.getId())
                .put("username", user.getUsername())
                .put("avatar", user.getAvatar())
                .put("email", user.getEmail())
                .map());
    }
    @RequiresAuthentication
    @GetMapping("/logout")
    public Result logout(){
        SecurityUtils.getSubject().logout();
        System.out.println(SecurityUtils.getSubject());
        return Result.success().codeAndMessage(ResultInfo.SUCCESS).data("msg", "退出成功" );
    }
}
