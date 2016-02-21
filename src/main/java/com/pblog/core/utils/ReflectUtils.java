package com.pblog.core.utils;

import java.lang.reflect.Field;

public class ReflectUtils {

    public static Object getFieldValue(Object obj, String fieldName){
        Object result = null;

        Field field = ReflectUtils.getField(obj, fieldName);
        if(field != null){
            field.setAccessible(true);

            try {
                result = field.get(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e){
                e.printStackTrace();
            }
        }
        return result;
    }

    public static void setFieldValue(Object obj, String fieldName, Object fieldValue){
        Field field = ReflectUtils.getField(obj, fieldName);

        if(field != null){
            try {
                field.setAccessible(true);
                field.set(obj, fieldValue);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e){
                e.printStackTrace();
            }
        }
    }

    private static Field getField(Object obj, String fieldName){
        Field field = null;

        for(Class<?> clazz = obj.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()){
            try {
                field = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {

            }
        }
        return field;
    }
}
