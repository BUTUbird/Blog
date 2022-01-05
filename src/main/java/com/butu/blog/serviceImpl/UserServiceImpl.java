package com.butu.blog.serviceImpl;

import com.butu.blog.entity.User;
import com.butu.blog.mapper.UserMapper;
import com.butu.blog.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
