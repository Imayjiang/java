package com.tmall.pyramid.domain.service;

import com.tmall.pyramid.domain.BusinessCheckException;
import com.tmall.pyramid.domain.model.Goods;
import com.tmall.pyramid.domain.model.Reason;
import com.tmall.pyramid.domain.model.ReasonRepository;
import com.tmall.pyramid.domain.model.Trade;
import com.tmall.pyramid.domain.model.TradeRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * <p> Date: 2014/8/12 Time: 19:23 </p>
 *
 * @author jiangbo.wjb
 */
public class TradeServiceImpl implements TradeService {

    private ReasonRepository reasonRepository;

    private TradeRepository tradeRepository;

    @Override
    public Reason[] suitReasons(final String tradeId) {
        final Trade trade = tradeRepository.find(tradeId);
        if (trade == null) {
            throw new BusinessCheckException("");
        }
        return reasonRepository.applyReason(trade);
    }

    @Override
    public long maxAvailableReturnFunds(final String tradeId) {
        final Trade trade = tradeRepository.find(tradeId);
        throw new RuntimeException("This method is not implemented yet!");
    }

    @Override
    public Goods[] availableReturnGoods(final String tradeId) {

        final Trade trade = tradeRepository.find(tradeId);
        if (trade == null) {
            throw new BusinessCheckException("not such trade!id:" + tradeId);
        }
        final Goods[] boughtGoodsList = trade.getGoodsList();
        if (boughtGoodsList == null || boughtGoodsList.length == 0) {
            return null;
        }
        final List<Goods> availableReturnGoods = new ArrayList<Goods>();
        for (Goods goods : boughtGoodsList) {
            if (goods.allowReturn()) {
                availableReturnGoods.add(goods);
            }
        }
        return availableReturnGoods
                .toArray(new Goods[availableReturnGoods.size()]);
    }

    public void setTradeRepository(final TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }

    public void setReasonRepository(final ReasonRepository reasonRepository) {
        this.reasonRepository = reasonRepository;
    }
}
