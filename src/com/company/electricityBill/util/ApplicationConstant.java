package com.company.electricityBill.util;

import java.util.HashMap;
import java.util.Map;

public class ApplicationConstant {

    public static Map<Integer, Integer> map = new HashMap();

    public static void price(){
        map.put(100 ,4);
        map.put(200, 5);
        map.put(300, 6);

    }


}
