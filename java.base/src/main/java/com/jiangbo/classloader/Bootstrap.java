package com.jiangbo.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * <p>
 * <p> Date: 14-4-15 Time: 下午4:06 </p>
 *
 * @author jiangbo.wjb
 */
public class Bootstrap {
    private static final String CLASS_PATH
            = "D:\\programming\\java\\src\\study.java.core\\java.base\\target\\classes\\";

    private static Bootstrap bootstrap;

    public static void main(String[] args) throws ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {

        initBootstrap();

        Object container1 = bootstrap.newInstanceContainer();
        printClassLoader(container1);

        Object container2 = bootstrap.newInstanceContainer();
        printClassLoader(container2);

    }

    private static void printClassLoader(final Object o) {
        System.out.println(
                String.format("%s's classLoader :%s ",
                        o.getClass().getSimpleName(),
                        o.getClass().getClassLoader().toString()
                )
        );
    }

    private static void initBootstrap() {
        bootstrap = new Bootstrap();
    }

    private Object newInstanceContainer() throws NoSuchMethodException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
        final ClassLoader loader
                = bootstrap.createLoader(new String[]{
                StandardContainer.class.getName()
                }
        );
        //load container and init it
        final Object container
                = loader.loadClass(StandardContainer.class.getName()).newInstance();
        //set classLoader
        Class<?> paramTypes[] = new Class[1];
        paramTypes[0] = Class.forName("java.lang.ClassLoader");
        Object[] paramValues = new Object[1];
        paramValues[0] = loader;
        Method setClassLoaderMethod =
                container.getClass().getMethod("setClassLoader", paramTypes);
        setClassLoaderMethod.invoke(container, paramValues);
        //invoke start method
        Method startMethod =
                container.getClass().getMethod("start");
        startMethod.invoke(container);
        return container;
    }

    private ClassLoader createLoader(String[] components) {
        return new ComponentClassLoader(CLASS_PATH,
                components);
    }
}
