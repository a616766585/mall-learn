package cn.muzaijian.mall.satoken.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 后台用户表 前端控制器
 * </p>
 *
 * @author muzaijian
 * @date 2021/9/1
 */
@RestController
@RequestMapping("/umsAdmin")
public class UmsAdminController {

    /**
     * 登陆以后返回token
     */
    @PostMapping("/login")
    public String login(String username, String password) {
        StpUtil.login(10010);
        StpUtil.getLoginId();
        SaTokenInfo saTokenInfo = new SaTokenInfo();
        return null;
    }
}
