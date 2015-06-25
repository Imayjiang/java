package com.jiangbo.concurrent.locks;

import com.jiangbo.concurrent.Lock;

/**
 * </p>
 * Date:2015/4/30   Time:10:43
 *
 * @author: jiangbo.wjb
 */
public class Locks {

    public static Lock clhLock() {
        return new CLHLock();
    }

    public static Lock mcsLock() {
        return new MCSLock();
    }

}
