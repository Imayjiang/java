package com.jiangbo.concurrent.locks;

import com.jiangbo.concurrent.Lock;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * <p>
 * MCS的实现原理刚好和CLH有点相反，CLH是在其他节点上自旋，而MCS是在自己身上自旋
 * <p> Date: 2014/7/29 Time: 17:54 </p>
 *
 * @author jiangbo.wjb
 */
class MCSLock implements Lock {

    static class Node {
        boolean isLocked = true;

        Node next;
    }

    private volatile Node tail;

    private static final AtomicReferenceFieldUpdater<MCSLock, Node> UPDATER
            = AtomicReferenceFieldUpdater.newUpdater(MCSLock.class, Node.class, "tail");

    private ThreadLocal<Node> cur = new ThreadLocal<Node>();

    @Override
    public void lock() {
        final Node curNode = new Node();
        this.cur.set(curNode);
        Node predecessor = UPDATER.getAndSet(this, curNode);
        if (predecessor != null) {
            predecessor.next = curNode;
            while (curNode.isLocked) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void unlock() {
        final Node curNode = this.cur.get();
        UPDATER.compareAndSet(this, curNode, null);
        this.cur.set(null);

        if (curNode.next == null) {
            return;
        }
        curNode.next.isLocked = false;
    }
}
