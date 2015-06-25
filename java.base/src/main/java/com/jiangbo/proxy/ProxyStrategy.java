package com.jiangbo.proxy;

/**
 * <p>
 * <p> Date: 14-4-18 Time: 下午4:24 </p>
 *
 * @author jiangbo.wjb
 */
public class ProxyStrategy {

    public static void main(String[] args){
        testProxyStrategy();
    }

    private static void testProxyStrategy() {
        ProxySubject proxy = new ProxySubject(new RealSubject());
        consumer(proxy);
    }


    private static void consumer(Subject subject) {
        subject.operation1();
        subject.operation2("ZJ");
    }


    static interface Subject {
        void operation1();

        void operation2(String arg);
    }

    static class RealSubject implements Subject {

        public void operation1() {
            System.out.println("Realer do operation1");
        }

        public void operation2(String arg) {
            System.out.println("Realer do operation2 with " + arg);
        }
    }

    static class ProxySubject implements Subject {

        private Subject realSubject;

        ProxySubject(Subject subject) {
            this.realSubject = subject;
        }

        @Override
        public void operation1() {
            System.out.println("I am proxy class");
            realSubject.operation1();
        }

        @Override
        public void operation2(final String arg) {
            System.out.println("I am proxy class");
            realSubject.operation2(arg);
        }
    }
}
