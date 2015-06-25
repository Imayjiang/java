package com.tmall.pyramid.domain.model;


/**
 * <p>
 * <p> Date: 2014/8/6 Time: 11:33 </p>
 *
 * @author jiangbo.wjb
 */
public class Refund {

    private String refundId;

    private String tradeId;

    private Goods[] goodsList;

    private User operator;

    private RefundFunds funds;

    private Reason reason;

    private ConsultMessage[] consultMessages;

    public String getRefundId() {
        return refundId;
    }

    public String getTradeId() {
        return tradeId;
    }

    public Goods[] getGoodsList() {
        return goodsList;
    }

    public RefundFunds getFunds() {
        return funds;
    }

    public Reason getReason() {
        return reason;
    }

    public ConsultMessage[] getConsultMessages() {
        return consultMessages;
    }

    public User getOperator() {
        return operator;
    }

    public Refund() {
    }

    public Refund(final String refundId,final Trade trade, final Reason reason,
                  final ConsultMessage[] consultMessages,
                  final long funds, final User operator) {
        this.refundId = refundId;
        this.tradeId = trade.getTradeId();
        this.reason = reason;
        this.consultMessages = consultMessages;
        this.funds = new RefundFunds(trade.figureRefundFunds(), funds);
        this.goodsList = trade.getGoodsList();
        this.operator = operator;
    }

    public boolean refundOnly() {
        return goodsList == null;
    }

    public boolean returnGoods() {
        return goodsList != null;
    }
}
