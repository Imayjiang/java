package com.tmall.pyramid.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * <p> Date: 2014/8/6 Time: 11:33 </p>
 *
 * @author jiangbo.wjb
 */
@Entity
public class Trade {

    private String tradeId;

    //货物跟付款明细的对应，实付现金、积分、打折

    private Payment[] paymentDetail;

    private Payment actualPayment;//the sum of cash+points+other pay tool

    private Goods[] goodsList;

    public String getTradeId() {
        return tradeId;
    }

    public Payment getActualPayment() {
        return actualPayment;
    }

    public Goods[] getGoodsList() {
        return goodsList;
    }

    public long figureRefundFunds() {
        throw new UnsupportedOperationException("");
    }

}
