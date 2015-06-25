package com.tmall.pyramid.domain.service;

import com.tmall.pyramid.domain.model.Refund;

/**
 * <p>
 * <p> Date: 2014/8/12 Time: 19:19 </p>
 *
 * @author jiangbo.wjb
 */
public interface RefundService {

    public Refund applyRefund(final String tradeId,final long funds,
                              final String reasonId);
}
