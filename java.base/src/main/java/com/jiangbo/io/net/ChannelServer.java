package com.jiangbo.io.net;

/**
 * <p>
 * <p> Date: 2014/6/30 Time: 13:14 </p>
 *
 * @author jiangbo.wjb
 */
public abstract class ChannelServer extends Server {

    public abstract ChannelServer channel(Channel channel);

    public abstract ChannelServer pipeline(Pipeline pipeline);
}
