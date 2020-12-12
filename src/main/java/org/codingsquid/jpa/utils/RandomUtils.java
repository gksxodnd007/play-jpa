package org.codingsquid.jpa.utils;

import java.util.Random;

/**
 * @author taewoong.han
 * @since 2020.12.12
 */
public class RandomUtils {

    public static String generateNumber() {
        Random rand = new Random(System.currentTimeMillis());
        return Integer.toString(Math.abs(rand.nextInt()));
    }
}
