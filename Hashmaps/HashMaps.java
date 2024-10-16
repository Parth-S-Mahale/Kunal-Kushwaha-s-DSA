package Hashmaps;

import java.util.*;

class HashMaps {
    public static void main(String[] args) {

        // String name = "Rahul";
        // int str = name.hashCode();
        // System.out.println(str);

        // Integer a = 4235678;
        // int code = a.hashCode();
        // System.out.println(code);

        TreeMap<String, Integer> map = new TreeMap<>();

        // HashMap<String, Integer> map = new HashMap<>();

        map.put("Kunal", 89);
        map.put("Karan", 99);
        map.put("Rahul", 94);

        System.out.println(map.get("Karan"));
        System.out.println(map.getOrDefault("Apoorv", 78));
        System.out.println(map.containsKey("Karan"));

        HashSet<Integer> set = new HashSet<Integer>();

        set.add(56);
        set.add(9);
        set.add(12);
        set.add(43);
        set.add(56);
        set.add(2);

        System.out.println(set);
    }    
}