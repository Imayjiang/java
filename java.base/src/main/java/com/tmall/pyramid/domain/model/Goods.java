package com.tmall.pyramid.domain.model;

/**
 * <p>
 * <p> Date: 2014/8/6 Time: 11:33 </p>
 *
 * @author jiangbo.wjb
 */
@Entity
public class Goods {

    private String goodsId;

    private long originalPrice;

    private String title;

    private String mainPic;

    private Type goodsType = Type.ALLOW_RETURN;

    public static enum Type {
        ALLOW_RETURN,
        NOT_ALLOW_RETURN
    }

    public boolean allowReturn() {
        return goodsType.equals(Type.ALLOW_RETURN);
    }

}
