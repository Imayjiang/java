package com.jiangbo.metaelement;

import java.lang.reflect.Field;
import java.lang.reflect.TypeVariable;

/**
 * <p>
 *     to a class ,the meta data are as follows:
 *     class
 *         generic parameter type
 *         annotation
 *     fields
 *         annotations
 *         parameter types
 *     methods
 *         annotations
 *         parameters、
 *         generic parameter type
 *     all of the meta data can retrieve through the class{@link java.lang.Class}
 *
 * <p> Date: 2014/7/24 Time: 15:05 </p>
 *
 * @author jiangbo.wjb
 */
public class ClassMetaData {


    public static void main(String[] args) {
        FullClassDefinition<Integer> testClass = new FullClassDefinition(14);
        Class clazz = testClass.getClass();
        //print class info
        classCoreInfo(clazz);

        fieldsInfo(clazz);
        //print fields info

        //print method info




    }

    private static void fieldsInfo(final Class clazz) {
        Field[] fields = clazz.getDeclaredFields();
        if(fields!=null) {
            for(Field f:fields) {
                System.out.println("filed "+f.getGenericType());
            }
        }
    }

    private static void classCoreInfo(final Class clazz) {
        System.out.println("class name = "+clazz.getName());
        TypeVariable[] typeVariables = clazz.getTypeParameters();
        if(typeVariables!=null) {
            System.out.println("parameter type list");
            for(TypeVariable tv:typeVariables) {
                System.out.println("tv = "+tv+" inner = "+tv.getClass()+tv.getGenericDeclaration()+" last"+tv.getBounds());
            }
        }

    }


    private @interface NotNull{

    }

    private @interface Decorator{

    }


    @Decorator
    private static class FullClassDefinition<K>{

        @NotNull
        private K fieldKeeping;

        FullClassDefinition(final K k) {
            this.fieldKeeping = k;
        }

        public void setFieldKeeping(@NotNull final K k){
            this.fieldKeeping = k;
        }

        public @NotNull K getFieldKeeping() {
            return fieldKeeping;
        }
    }

}
