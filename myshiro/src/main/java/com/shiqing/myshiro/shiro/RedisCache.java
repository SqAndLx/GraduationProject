//package com.shiqing.myshiro.shiro;
//
//import org.apache.shiro.cache.Cache;
//import org.apache.shiro.cache.CacheException;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Component;
//
//import java.util.Collection;
//import java.util.Set;
//
///**
// * 自定义redis缓存的实现
// */
//public class RedisCache<K, V> implements Cache<K, V> {
//
//    @Override
//    public V get(K k) throws CacheException {
//        return null;
//    }
//
//    @Override
//    public V put(K k, V v) throws CacheException {
//
//        return null;
//    }
//
//    @Override
//    public V remove(K k) throws CacheException {
//        return null;
//    }
//
//    @Override
//    public void clear() throws CacheException {
//
//    }
//
//    @Override
//    public int size() {
//        return 0;
//    }
//
//    @Override
//    public Set<K> keys() {
//        return null;
//    }
//
//    @Override
//    public Collection<V> values() {
//        return null;
//    }
//
//    private RedisTemplate getRediaTemplate(){
//        RedisTemplate redisTemplate = ApplicationContextUtils.getBean();
//    }
//}
