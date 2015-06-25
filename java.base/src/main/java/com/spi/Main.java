package com.spi;

import java.util.ServiceLoader;

/**
 * <p>
 * </p>
 * <p> Date: 2014/12/22 Time: 16:50 </p>
 */
public class Main {

    public static void main(String[] args) {

        ServiceLoader<SpiExtension> serviceLoader
                = ServiceLoader.load(SpiExtension.class);

        for(SpiExtension spiExtension:serviceLoader) {
            System.out.println(spiExtension.getName());
        }

    }

}
