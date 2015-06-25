package com.tmall.pyramid.domain.service;

import com.tmall.pyramid.domain.model.Refund;
import com.tmall.pyramid.domain.model.RefundFactory;
import com.tmall.pyramid.domain.model.RefundRepository;
import com.tmall.pyramid.domain.model.Trade;
import com.tmall.pyramid.domain.model.TradeRepository;

/**
 * <p>
 * <p> Date: 2014/8/12 Time: 20:51 </p>
 *
 * @author jiangbo.wjb
 */
public class RefundServiceImpl implements RefundService {

    private TradeRepository tradeRepository;

    private TradeService tradeService;

    private RefundFactory refundFactory;

    private RefundRepository refundRepository;

    @Override
    public Refund applyRefund(final String tradeId, final long funds,
                              final String reasonId) {

        return null;
    }
}
