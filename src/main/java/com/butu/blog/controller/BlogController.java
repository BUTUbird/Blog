package com.butu.blog.controller;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.butu.blog.common.lang.Result;
import com.butu.blog.common.lang.ResultInfo;
import com.butu.blog.entity.Blog;
import com.butu.blog.service.BlogService;
import com.butu.blog.utils.ShiroUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author BUTUbird
 * @since 2022-01-04
 */
@RestController
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/blogs")
    public Result list(@RequestParam(defaultValue = "1")Integer currentPage){
        Page page = new Page(currentPage,5);
        Page pageDate = blogService.page(page, new QueryWrapper<Blog>().orderByDesc("created"));
        return Result.success().codeAndMessage(ResultInfo.SUCCESS).data("PageData", pageDate);
    }
    @GetMapping("/blog/{id}")
    public Result detail(@PathVariable(name = "id") Long id){
        Blog blog = blogService.getById(id);
        Assert.notNull(blog, "该博客已被删除");
        return Result.success().codeAndMessage(ResultInfo.SUCCESS).data("blogData", blog);
    }
    @RequiresAuthentication
    @PostMapping("/blog/edit")
    public Result edit(@Validated @RequestBody Blog blog){
        Blog temp = null;
        if (blog.getId() != null){
            temp = blogService.getById(blog.getId());
            Assert.isTrue(temp.getUserId().equals(ShiroUtil.getProfile().getId()), "没有权限编辑");

        }else{
            temp = new Blog();
            temp.setUserId(ShiroUtil.getProfile().getId());
            temp.setCreated(LocalDateTime.now());
            temp.setStatus(0);
        }
        BeanUtil.copyProperties(blog,temp, "id","userId","created","status");
        blogService.saveOrUpdate(temp);
        return Result.success().data("", "");
    }
}
