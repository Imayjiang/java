package com.tmall.pyramid.domain.model;

/**
 * <p>
 * <p> Date: 2014/8/6 Time: 11:42 </p>
 *
 * @author jiangbo.wjb
 */
@ValueObject
public class RefundFunds {

    private long maxAvailableFunds;

    private long applyFunds;

    RefundFunds(final long max,final long apply) {
        this.maxAvailableFunds = max;
        this.applyFunds = apply;
    }

    public long getMaxAvailableFunds() {
        return maxAvailableFunds;
    }

    public long getApplyFunds() {
        return applyFunds;
    }

}
