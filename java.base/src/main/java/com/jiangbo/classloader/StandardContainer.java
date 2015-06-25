package com.jiangbo.classloader;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * <p> Date: 14-4-15 Time: 下午3:53 </p>
 *
 * @author jiangbo.wjb
 */
public class StandardContainer implements Container {

    private volatile boolean start;

    private Context context;

    private ClassLoader classLoader;

    private List<Component> components = new ArrayList<Component>();

    public void setClassLoader(final ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public ClassLoader getClassLoader() {
        return classLoader;
    }

    @Override
    public Context getContext() {
        return context;
    }

    @Override
    public Component[] getComponents() {
        return components
                .toArray(new Component[components.size()]);
    }

    @Override
    public synchronized void addComponent(final Component component) {
        if (!components.contains(component)) {
            components.add(component);
        }
    }

    @Override
    public synchronized void start() {
        if(start) {
            throw new IllegalStateException("started!");
        }
        initContext();
        this.start = true;
    }

    private void initContext() {
        if(this.context == null) {
            this.context = new Context();
        }
    }

    @Override
    public void stop() {
        if (components != null) {
            components.clear();
            components = null;
        }
        if (context != null) {
            context = null;
        }
    }
}
