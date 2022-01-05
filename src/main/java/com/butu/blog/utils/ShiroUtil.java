package com.butu.blog.utils;

import com.butu.blog.shiro.AccountProfile;
import org.apache.shiro.SecurityUtils;

/**
 * @author BUTUbird
 */
public class ShiroUtil {
    public static AccountProfile getProfile(){
        return (AccountProfile) SecurityUtils.getSubject().getPrincipal();
    }
}
