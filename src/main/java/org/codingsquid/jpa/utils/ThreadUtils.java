package org.codingsquid.jpa.utils;

/**
 * @author taewoong.han
 * @since 2020.12.12
 */
public class ThreadUtils {

    public static void sleep(long period) {
        try {
            Thread.sleep(period);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
