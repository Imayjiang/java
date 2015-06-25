package com.jiangbo.serialization.serializer;

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * <p>
 * 提供primitive和object类型的序列化器
 * <ul>
 * <li>byte/Byte</li>
 * <li>int/Integer</li>
 * <li>short/Short</li>
 * <li>long/Long</li>
 * <li>double/Double</li>
 * <li>float/Float</li>
 * <li>decimal/Decimal</li>
 * <li>boolean/Boolean</li>
 * <li>enum</li>
 * <li>array/Array</li>
 * <p/>
 * <li>String</li>
 * <li>Object</li>
 * </ul>
 * <p/>
 * </p>
 * <p> Date: 2014/7/24 Time: 11:18 </p>
 *
 * @author jiangbo.wjb
 */
abstract class BaseSerializerImpl {

    abstract void write(Object o, OutputStream out);

    abstract <T> T read(InputStream in);

}
