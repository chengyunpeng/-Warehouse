package com.hz.boot3.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.hz.boot3.pojo.Provider;
import com.hz.boot3.service.ProviderService;
import com.hz.boot3.utils.RedisUtil;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/nnn")


public class Redis {
    @Autowired
    public StringRedisTemplate StringRedisTemplate;

   @Autowired
     private RedisTemplate  redisTemplate;
    @Autowired
    private ProviderService providerService;
    @Autowired
    private RedisUtil redisUtil;
//    @ResponseBody
//    @RequestMapping("/sum")
//    public String countNum(){
//        StringRedisTemplate.opsForValue().increment("age",1);
//        System.out.println(redisTemplate.opsForValue().get("age"));
//        StringRedisTemplate.opsForValue().increment("bb",3);
//        System.out.println(redisTemplate.opsForValue().get("bb"));
//        String a = redisTemplate.opsForValue().get("age");
//        String b = redisTemplate.opsForValue().get("bb");
//        return a+b;
//    }
    @ResponseBody
    @RequestMapping("/provider")
            public String providers(){
//    Provider provider = providerService.findProviderById(1);
//    String s = JSONObject.toJSONString(provider);
//    Provider provider1 = JSON.parseObject(s, new TypeReference<Provider>(){});
//
//    ValueOperations qqq = redisTemplate.opsForValue();
//        qqq.set("pro",provider1);
//    Provider pro =(Provider) redisTemplate.opsForValue().get("pro");
//        System.out.println(pro.toString());
//        System.out.println("aaaa");


        Provider provider2 = providerService.findProviderById(1);
        redisUtil.setStrJson("pro",provider2,60L);
        redisUtil.getStrJson("pro",Provider.class);
        return "成功";
}

    //gggggggggggggggggg
//    @ResponseBody
//    @RequestMapping("/bbbb")
//    public Object RedisTemplate(){
//    redisTemplate.opsForValue().increment("sex",1);
//
//
//
//
//        return redisTemplate.opsForValue().get("sex");
//    }

    }


//        return ss;