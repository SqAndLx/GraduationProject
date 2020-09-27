//package com.shiqing.myshiro.shiro;
//
//import org.apache.shiro.cache.Cache;
//import org.apache.shiro.cache.CacheException;
//import org.apache.shiro.cache.CacheManager;
//
///**
// * 自定义的shiro缓存管理器
// * @author
// */
//public class RedisCacheManager implements CacheManager {
//
//    /**
//     *
//     * @param cacheName 认证或授权的缓存统一名称
//     * @param <K>
//     * @param <V>
//     * @return
//     * @throws CacheException
//     */
//    @Override
//    public <K, V> Cache<K, V> getCache(String cacheName) throws CacheException {
//        return new RedisCache<K, V>();
//    }
//}
