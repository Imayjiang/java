package com.jiangbo.serialization.serializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * <p>
 * <p> Date: 2014/7/24 Time: 11:18 </p>
 *
 * @author jiangbo.wjb
 */
class ByteSerializer extends BaseSerializerImpl {

    static final ByteSerializer INSTANCE = new ByteSerializer();

    @Override
    void write(final Object o, final OutputStream out) {
        throw new RuntimeException("This method is not implemented yet!");
    }

    @Override
    <T> T read(final InputStream in) {
        byte[] bytes = null;
        try {
            bytes = new byte[in.available()];
            in.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert bytes != null;
        assert bytes.length != 0;
        return (T) bytes;
    }
}
