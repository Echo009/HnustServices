package cn.echo0.hnustservices.common;

import com.sun.istack.internal.Nullable;

import java.util.HashMap;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 07/21/2017 03:54 PM
 */
public class CachedInfo {
    // 用于缓存用户相关信息
    private HashMap<String, Object> cache = new HashMap<>(10);

    public boolean saveInfo(String key, Object info) {
        if (key != null && info != null && cache.put(key, info) != null) {
            return true;
        }
        return false;
    }

    public boolean removeInfo(String key) {
        return cache.remove(key) != null;
    }

    public void clearInfo() {
        cache.clear();
    }

    public Object getInfo(String key) {
        return cache.get(key);
    }

    @Override
    public String toString() {
        return "CachedInfo{" +
                "cache=" + cache +
                '}';
    }
}
