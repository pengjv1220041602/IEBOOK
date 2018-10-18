package com.iebook.utils;

import java.util.UUID;

public class Utils {
    public static String getUUID () {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
