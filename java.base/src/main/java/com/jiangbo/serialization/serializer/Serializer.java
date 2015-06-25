package com.jiangbo.serialization.serializer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * <p> Date: 2014/7/24 Time: 11:18 </p>
 *
 * @author jiangbo.wjb
 */
public class Serializer {

    private static final Map<Class, ? extends BaseSerializerImpl> serializerMap
            = new HashMap() {{
        put(Byte.class, ByteSerializer.INSTANCE);
        put(byte.class, ByteSerializer.INSTANCE);
    }};

    static BaseSerializerImpl getSerializerByType(Class type) {
        final Map<Class, ? extends BaseSerializerImpl> serializers = serializerMap;
        return serializers.get(type);
    }

    public static <T> T deserialize(Class type, InputStream in) {
        return getSerializerByType(type).read(in);
    }

    public static void main(String[] args) throws IOException {
        byte[] bytes = "hello,world".getBytes();
        System.out.println(Arrays.toString(bytes));
        InputStream in = new ByteArrayInputStream(bytes);
        byte[] bytes1 = Serializer.deserialize(byte.class, in);
        System.out.println(Arrays.toString(bytes1));
    }
}
