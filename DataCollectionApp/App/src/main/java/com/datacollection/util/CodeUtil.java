package com.datacollection.util;

import java.util.Random;

public class CodeUtil {

    public static String generate(){

        Random r = new Random();

        return String.valueOf(100000 + r.nextInt(900000));

    }

}
