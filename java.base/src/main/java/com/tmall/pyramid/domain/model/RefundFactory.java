package com.tmall.pyramid.domain.model;

import com.tmall.pyramid.domain.BusinessCheckException;
import com.tmall.pyramid.domain.service.TradeService;

/**
 * <p>
 * <p> Date: 2014/8/12 Time: 20:57 </p>
 *
 * @author jiangbo.wjb
 */
public class RefundFactory {

    private TradeRepository tradeRepository;

    private TradeService tradeService;

    private RefundFactory refundFactory;

    private RefundRepository refundRepository;

    private ReasonRepository reasonRepository;

    public Refund createRefund(final String tradeId, final long funds,
                               final String reasonId, final User user) {
        final Trade trade = tradeRepository.find(tradeId);
        if (trade == null) {
            throw new BusinessCheckException("not such trade,id" + tradeId);
        }
        final long maxAvailableReturnFunds
                = tradeService.maxAvailableReturnFunds(tradeId);
        assert maxAvailableReturnFunds >= funds;
        return new Refund(nextRefundId(), trade, reasonRepository.find(reasonId),
                null, funds, user);
    }

    private String nextRefundId() {
        return "mock";
    }
}
