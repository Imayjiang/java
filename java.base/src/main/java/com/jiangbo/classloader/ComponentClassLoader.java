package com.jiangbo.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * <p>
 * <p> Date: 14-4-15 Time: 下午3:40 </p>
 *
 * @author jiangbo.wjb
 */
public class ComponentClassLoader extends ClassLoader {

    private static final String LOAD_COMPONENT_PACKAGE_NAME
            = "com.jiangbo.classloader.isolation";

    private String classPath;

    ComponentClassLoader(String classPath,
                         String[] componentsName) {
        this.classPath = classPath;
        for (String component : componentsName) {
            System.out.println("load component:" + component);
        }
    }


    private byte[] getPendingLoadClassData(final String classFullName) {
        String path = classPath + classFullName.replace('.', File.separatorChar) + ".class";
        try {
            InputStream in = new FileInputStream(path);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buffer = new byte[2048];
            int num = 0;
            while((num = in.read(buffer)) != -1){
                out.write(buffer,0,num);
            }
            return out.toByteArray();
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Class<?> loadClass(final String name) throws ClassNotFoundException {
        if (!name.startsWith(LOAD_COMPONENT_PACKAGE_NAME)) {
            return super.loadClass(name);
        }
        Class<?> clazz = findLoadedClass(name);
        if (clazz != null) {
            return clazz;
        }
        return findClass(name);
    }

    @Override
    protected Class<?> findClass(final String name) throws ClassNotFoundException {
        if (!name.startsWith(LOAD_COMPONENT_PACKAGE_NAME)) {
            return super.loadClass(name);
        }
        byte[] classData = getPendingLoadClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException("not found");
        } else {
            return defineClass(name, classData, 0, classData.length);
        }
    }
}
