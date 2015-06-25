package com.jiangbo.bytecode;

/**
 * <p>
 * byteCode structure:
 * <p/>
 * ClassFile {
 * ----------header------------------
 * u4			magic;
 * u2			minor_version;
 * u2			major_version;
 * ----------constant pool------------------
 * u2			constant_pool_count;
 * cp_info		contant_pool[constant_pool_count – 1];
 * ----------Access flags------------------
 * u2			access_flags;
 * u2			this_class;
 * u2			super_class;
 * ---------Implemented Interfaces---------
 * u2			interfaces_count;
 * u2			interfaces[interfaces_count];
 * u2			fields_count;
 * field_info		fields[fields_count];
 * u2			methods_count;
 * method_info		methods[methods_count];
 * u2			attributes_count;
 * attribute_info	attributes[attributes_count];
 * }
 * </p>
 * <p> Date: 2014/6/15 Time: 17:21 </p>
 *
 * @author jiangbo.wjb
 */
public class ByteCodeSourceFile extends SourceSuperClazz
        implements SourceInterface {

    private static final int FILED_1 = 1;

    private Object FIELD_2 = new Object();

    @Override
    public void doNothing(final int param1, final Object param2) {
        final int argA = 1;
        final int argB = 2;
        final int result = argA + argB;
        System.out.println(result);
        synchronizedMethod(result);
    }

    public void synchronizedMethod(int arg1) {
        synchronized (this) {
            if (arg1 <= 5) {
                System.out.println(111111);
            } else {
                System.out.println(222222);
            }
        }
    }
}
