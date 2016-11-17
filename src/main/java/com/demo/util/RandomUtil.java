package com.demo.util;

import java.util.Random;

/**
 * Created by lw on 16-11-15.
 * random
 */
public class RandomUtil {
    public static String getRandomString(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(random.nextInt());
        }
        return stringBuilder.toString();
    }
}
