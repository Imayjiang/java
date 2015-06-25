package com.tmall.pyramid.domain.model;

/**
 * <p>
 * <p> Date: 2014/8/6 Time: 11:34 </p>
 *
 * @author jiangbo.wjb
 */
@Entity
public class User {

    private String userId;

    private String name;

    private Role role;

    public static enum Role {
        BUYER,
        SELLER
    }

    public boolean isBuyer() {
        assert role != null;
        return role == Role.BUYER;
    }

    public boolean isSeller() {
        assert role != null;
        return role == Role.SELLER;
    }
}
