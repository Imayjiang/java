package com.spi;

/**
 * <p>
 * </p>
 * <p> Date: 2014/11/8 Time: 15:24 </p>
 *
 * @author jiangbo.wjb
 */
public class GeneralSpiExtension implements SpiExtension {

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
