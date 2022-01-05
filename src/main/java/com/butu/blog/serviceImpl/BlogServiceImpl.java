package com.butu.blog.serviceImpl;

import com.butu.blog.entity.Blog;
import com.butu.blog.mapper.BlogMapper;
import com.butu.blog.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author BUTUbird
 * @since 2022-01-04
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
