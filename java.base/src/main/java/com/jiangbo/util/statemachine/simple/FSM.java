package com.jiangbo.util.statemachine.simple;

/**
 * <p>
 * <p> Date: 2014/8/24 Time: 16:31 </p>
 *
 * @author jiangbo.wjb
 */
public class FSM {

    private State start;

    private State current;

    public FSM(State start) {
        this.start = start;
        this.current = start;
    }

    void on(Event event) {

    }

    void to(State state) {

    }

    void from(State state) {

    }

    void transit(Transition... transitions) {

    }


}
