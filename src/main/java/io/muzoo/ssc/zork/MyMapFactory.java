package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.map.HospitalMyMap;
import io.muzoo.ssc.zork.map.MyMap;
import io.muzoo.ssc.zork.map.SchoolMyMap;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyMapFactory {

    private static final Map<String, MyMap> MY_MAP_MAP = new HashMap<>();
    private static final List<Class<? extends MyMap>> REGISTERED_MAPS = Arrays.asList(
            SchoolMyMap.class,
            HospitalMyMap.class
    );

    static {
        {
            for (Class<? extends MyMap> myMapClass : REGISTERED_MAPS) {
                try {
                    MyMap myMap = myMapClass.getDeclaredConstructor().newInstance();
                    MY_MAP_MAP.put(myMap.getMyMapName(), myMap);
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static MyMap get(String myMap) {
        return MY_MAP_MAP.get(myMap);
    }
}
