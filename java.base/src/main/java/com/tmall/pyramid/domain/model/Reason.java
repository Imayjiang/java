package com.tmall.pyramid.domain.model;

/**
 * <p>
 * <p> Date: 2014/8/6 Time: 11:33 </p>
 *
 * @author jiangbo.wjb
 */
@Entity
public class Reason {

    private final String id;

    private final String text;

    /**
     * indicate which problem the reason resolved
     */
    private String description;

    Reason(final String id, final String text) {
        this(id, text, null);
    }

    Reason(final String id, final String text, final String desc) {
        this.id = id;
        this.text = text;
        this.description = desc;
    }

    public String getDescription() {
        return description;
    }

    public String getText() {
        return text;
    }

    public String getId() {
        return id;
    }

    public boolean from(final Reason from) {
        return false;
    }
}
