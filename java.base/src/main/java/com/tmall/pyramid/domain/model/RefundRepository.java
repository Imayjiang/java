package com.tmall.pyramid.domain.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * <p>
 * <p> Date: 2014/8/12 Time: 20:56 </p>
 *
 * @author jiangbo.wjb
 */
public class RefundRepository {

    private Map<String, Refund> REPO = new HashMap<String, Refund>();

    public Refund findByTradeId(String tradeId) {
        Collection<Refund> values = REPO.values();
        if (values.isEmpty()) {
            return null;
        }
        Iterator<Refund> iterator = values.iterator();
        for (; iterator.hasNext(); ) {
            Refund refund = iterator.next();
            if (refund.getTradeId().equalsIgnoreCase(tradeId)) {
                return refund;
            }
        }
        return null;
    }

    public Refund find(final String refundId) {
        return REPO.get(refundId);
    }

    public Refund saveRefund(final Refund refund) {
        this.REPO.put(refund.getRefundId(), refund);
        return refund;
    }
}
