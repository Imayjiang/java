package com.jiangbo.concurrent.locks;

import com.jiangbo.concurrent.*;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * <p>
 * CLH 锁是在别的节点上的自旋，如图
 * ******    ******     ******
 * *next*———>*next*————>*next*
 * *    *<———*pre *<————*pre *
 * *head*    *node*     *tail*
 * ******    ******     ******
 * <p/>
 * 如图示，每一个新加入的竞争锁的线程都会insert到tail的位置，insert以后就会一直
 * 盯着pre节点是否释放了锁。线程进入队列后，默认状态是lock，lock其实包含了两种
 * 状态，locking 和 waiting for lock。在队列外的线程则会是isLock = false
 * <p> Date: 2014/7/30 Time: 10:57 </p>
 *
 * @author jiangbo.wjb
 */
class CLHLock implements com.jiangbo.concurrent.Lock {

    private static class Node {

        Thread thread;

        volatile boolean isLocked = true;

        Node() {
            thread = Thread.currentThread();
        }
    }

    private volatile Node tail;

    private static final AtomicReferenceFieldUpdater<CLHLock, CLHLock.Node> UPDATER
            = AtomicReferenceFieldUpdater.newUpdater(CLHLock.class, Node.class, "tail");

    private ThreadLocal<Node> cur = new ThreadLocal<Node>();

    @Override
    public void lock() {
        Node node = new Node();
        node.isLocked = true;
        cur.set(node);
        Node predecessor = UPDATER.getAndSet(this, node);
        if (predecessor != null) {
            while (predecessor.isLocked) {

            }
        }
    }

    @Override
    public void unlock() {
        Node cur = this.cur.get();
        assert cur != null;
        UPDATER.compareAndSet(this, cur, null);
        cur.isLocked = false;
        this.cur.set(null);
    }

}
