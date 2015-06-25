package com.tmall.pyramid.domain.model;

/**
 * <p>
 * <p> Date: 2014/8/6 Time: 11:35 </p>
 *
 * @author jiangbo.wjb
 */
@ValueObject
public abstract class Payment {

    private long amount;

    private FundsUnit fundsUnit;

    private PayTool payTool;

    Payment(final long amount) {
        this(amount, FundsUnit.FEN, PayTool.CASH);
    }

    Payment(final long amount, final FundsUnit unit, final PayTool payTool) {
        this.fundsUnit = unit;
        this.amount = amount;
        this.payTool = payTool;
    }

    public long getAmount() {
        return amount;
    }

    public FundsUnit getFundsUnit() {
        return fundsUnit;
    }

    public PayTool getPayTool() {
        return payTool;
    }


    public static enum FundsUnit {
        FEN,
        YUAN
    }

    public static enum PayTool {
        CASH,
        POINTS,
        COUPON
    }

}
