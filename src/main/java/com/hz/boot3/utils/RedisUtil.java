package com.hz.boot3.utils;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
@Component
public class RedisUtil {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate<Object, Object> redisTemplate;
    @Resource(name = "stringRedisTemplate")
    ValueOperations<String, String> valOpsStr;
    @Resource(name = "redisTemplate")
    ValueOperations<Object, Object> valOpsObj;
    public Object getStrJson(String key,Class a){
        String j = valOpsStr.get(key);
        return  JSON.parseObject(j,a);
    }
    //time 秒
    public void setStrJson(String key,Object object,Long time){
        String json = JSON.toJSONString(object);
        if(time!=null){
            valOpsStr.set(key,json,time,TimeUnit.SECONDS);
        }else{
            valOpsStr.set(key,json);
        }
    }
    /**
     * 根据指定key获取String
     * @param key
     * @return
     */
    public String getStr(String key){
        return valOpsStr.get(key);
    }
    /**
     * 设置Str缓存
     * @param key
     * @param val
     */
    public void setStr(String key, String val){
        valOpsStr.set(key,val);
    }
    /***
     * 设置Str缓存
     * @param key
     * @param val
     * @param expire 超时时间
     */
    public void setStr(String key, String val,Long expire){
        valOpsStr.set(key,val,expire, TimeUnit.MINUTES);
    }
    /**
     * 删除指定key
     * @param key
     */
    public void del(String key){
        stringRedisTemplate.delete(key);
    }
    /**
     * 根据指定o获取Object
     * @param o
     * @return
     */
    public Object getObj(Object o){
        return valOpsObj.get(o);
    }
    /**
     * 设置obj缓存
     * @param o1
     * @param o2
     */
    public void setObj(Object o1, Object o2){
        valOpsObj.set(o1, o2);
    }
    /**
     * 删除Obj缓存
     * @param o
     */
    public void delObj(Object o){
        redisTemplate.delete(o);
    }
    /***
     * 加锁的方法
     * @return
     */
    public boolean lock(String key,Long expire){
        RedisConnection redisConnection=redisTemplate.getConnectionFactory().getConnection();
        //设置序列化方法
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        if(redisConnection.setNX(key.getBytes(),new byte[]{1})){
            redisTemplate.expire(key,expire,TimeUnit.SECONDS);
            redisConnection.close();
            return true;
        }else{
            redisConnection.close();
            return false;
        }
    }
    /***
     * 解锁的方法
     * @param key
     */
    public void unLock(String key){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.delete(key);
    }
}