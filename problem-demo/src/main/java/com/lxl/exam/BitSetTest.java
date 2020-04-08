package com.lxl.exam;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 100万ip，判断ip是否存在
 */
public class BitSetTest {

    /**
     * ip前两段为key，后两段转换为int存在BitSet中
     * BitSet
     *  set
     *  get
     */
    private Map<String,BitSet> ipMap = new HashMap<String,BitSet>();

    public static void main(String[] args) {
//        BitSetTest bitSetTest = new BitSetTest();
//        bitSetTest.set("192.168.1.1");
//        bitSetTest.set("192.168.11.10");
//        bitSetTest.set("192.168.111.100");
//        bitSetTest.set("192.220.1.1");
//        bitSetTest.set("192.220.1.13");
//        bitSetTest.set("192.200.18.10");
//        System.out.println(bitSetTest.ipMap);
//        System.out.println(bitSetTest.contains("192.168.111.100"));
//        System.out.println(bitSetTest.contains("192.168.1.12"));

        BitSet bitSet = new BitSet();
        bitSet.set(1);
        boolean b = bitSet.get(2);
        System.out.println(b);
        bitSet.clear(1);

    }

    public void set(String ip){
        String group = getBitSetGroup(ip);
        int value = getBitSetValue(ip);
        BitSet bitSet = ipMap.get(group);
        if(bitSet == null){
            bitSet = new BitSet();
        }
        bitSet.set(value);
        ipMap.put(group, bitSet);
    }

    public int getBitSetValue(String ip){
        String[] arr = ip.split("\\.");
        if(arr.length != 4)return 0;
        String s = arr[2];
        String s1 = arr[3];
        return Integer.valueOf(padding(s) + padding(s1));
    }

    public String padding(String s){
        char[] charArray = s.toCharArray();
        for(int i = charArray.length;i< 3;i++){
            s = "0" + s;
        }
        return s;
    }

    public String getBitSetGroup(String ip){
        String[] arr = ip.split("\\.");
        if(arr.length < 4)return "";
        return padding(arr[0]) + "." + padding(arr[1]);
    }

    public boolean contains(String ip){
        String group = getBitSetGroup(ip);
        int value = getBitSetValue(ip);
        if(ipMap.containsKey(group)){
            BitSet bitSet = ipMap.get(group);
            return bitSet.get(value);
        }else {
            return false;
        }
    }
}
