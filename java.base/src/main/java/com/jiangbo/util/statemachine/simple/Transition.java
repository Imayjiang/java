package com.jiangbo.util.statemachine.simple;

/**
 * <p>
 * 在状态机中，一个transition的发生，意味着special event was trigger，
 * and result in the state transit from From to To;
 * <p> Date: 2014/8/24 Time: 16:18 </p>
 *
 * @author jiangbo.wjb
 */
public class Transition {

    private State from;

    private State to;

    private Event event;

    /**
     * has the transition been pass through
     */
    private boolean proceed = false;

    /**
     * 是否是状态机中到达the last state的transition
     */
    private boolean terminal = false;

//    Transition(State from, State to, Event event) {
//        this.from = from;
//        this.to = to;
//        this.event = event;
//    }

    Transition from(State from) {
        this.from = from;
        return this;
    }

    Transition to(State to) {
        this.to = to;
        return this;
    }





}
