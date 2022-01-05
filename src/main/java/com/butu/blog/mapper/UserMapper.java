package com.butu.blog.mapper;

import com.butu.blog.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author BUTUbird
 * @since 2022-01-04
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
