package com.simon.learn.headfirstjava.extend;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author simon.wei
 */
abstract class BaseDao<T> {
    public void getType() {
        //Class<E> clazz = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Type t = getClass().getGenericSuperclass();
        ParameterizedType p = (ParameterizedType) t ;
        Class<T> c = (Class<T>) p.getActualTypeArguments()[0];
        System.out.println(c.getName());    //java.lang.String
    }
}

class SubDao extends BaseDao<Aoo> {

    public static void main(String[] args) {
        new SubDao().getType();
    }
}