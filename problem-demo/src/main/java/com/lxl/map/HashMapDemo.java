package com.lxl.map;

import sun.misc.Unsafe;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapDemo {

    private static final sun.misc.Unsafe U;

    static{
        U = sun.misc.Unsafe.getUnsafe();
    }

    public void test(){
        Map map  = new HashMap<String,Object>();

        Map<String, String> concurrentHashMap = new ConcurrentHashMap<String, String>();

    }
}
