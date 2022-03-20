package com.janwes.controller;

import com.janwes.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author Janwes
 * @version 1.0.0
 * @package com.janwes.controller
 * @date 2022/3/20 16:58
 * @description
 */
@Api(tags = {"用户中心"})
@RestController
@RequestMapping("/user")
public class UserLoginController {

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public Result login(@RequestBody Map<String, Object> params) {
        return Result.success();
    }

    @ApiOperation("测试案例")
    @GetMapping("/example")
    public Result example(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          @RequestParam("age") int age,
                          @RequestParam("captcha") String captcha) {
        return Result.success();
    }
}
