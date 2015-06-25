package com.spi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;

/**
 * <p>
 * </p>
 * <p> Date: 2014/11/8 Time: 15:19 </p>
 *
 * @author jiangbo.wjb
 */
public class JdkServiceLoader {

    private static JdkServiceLoader INSTANCE;

    private final Map<Class, List> CACHE;

    private JdkServiceLoader() {
        CACHE = new HashMap();
    }

    public static JdkServiceLoader getInstance() {
        if (INSTANCE == null) {
            synchronized (JdkServiceLoader.class) {
                if (INSTANCE == null) {
                    INSTANCE = new JdkServiceLoader();
                }
            }
        }
        return INSTANCE;
    }

    public <T> List<T> load(final Class<T> serviceType) {
        List<T> providers = CACHE.get(serviceType);
        if (providers != null) {
            System.out.println("Cache:");
            return providers;
        }
        providers = new ArrayList<T>();
        for (T provider : ServiceLoader.load(serviceType)) {
            CACHE.put(serviceType, providers);
            providers.add(provider);
        }
        return providers;
    }

    public static void main(String[] args) {
        List<SpiExtension> spiExtensionList = JdkServiceLoader.getInstance().load(SpiExtension.class);
        for (SpiExtension spiExtension : spiExtensionList) {
            System.out.println("【name】:" + spiExtension.getName()
                    + "【class】:" + spiExtension.getClass());
        }

        spiExtensionList = JdkServiceLoader.getInstance().load(SpiExtension.class);
        for (SpiExtension spiExtension : spiExtensionList) {
            System.out.println("【name】:" + spiExtension.getName()
                    + "【class】:" + spiExtension.getClass());
        }
    }

}
