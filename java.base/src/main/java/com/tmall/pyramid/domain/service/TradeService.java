package com.tmall.pyramid.domain.service;

import com.tmall.pyramid.domain.model.Goods;
import com.tmall.pyramid.domain.model.Reason;

/**
 * <p>
 * <p> Date: 2014/8/12 Time: 19:21 </p>
 *
 * @author jiangbo.wjb
 */
public interface TradeService {

    public Reason[] suitReasons(final String tradeId);

    public long maxAvailableReturnFunds(final String tradeId);

    public Goods[] availableReturnGoods(final String tradeId);

}
