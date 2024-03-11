package com.sky.controller.admin;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController("ShopController")
@Slf4j
@Api(tags = "店铺相关接口")
@RequestMapping("/admin/shop")
public class ShopController {
    public static final String KEY="SHOP_STATUS";
    @Autowired
    private RedisTemplate redisTemplate;
    @ApiOperation("设置店铺营业状态")
    @PutMapping("/{status}")
    public Result setStatus(@PathVariable Integer status){
        log.info("设置店铺营业状态为:{}",status==1?"营业中":"打样中");
        redisTemplate.opsForValue().set(KEY,status);
        return Result.success();
    }

    @GetMapping("/status")
    @ApiOperation("获取店铺营业状态")
    public Result<Integer> getStatus(){
        Integer status = (Integer)redisTemplate.opsForValue().get(KEY);
        log.info("获取店铺营业状态为：{}",status==1?"营业中":"打样中");
        return Result.success(status);
    }
}
