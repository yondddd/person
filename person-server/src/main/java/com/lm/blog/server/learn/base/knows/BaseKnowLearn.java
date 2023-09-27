package com.lm.blog.server.learn.base.knows;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author yond
 * @date 2023/7/22
 * @description 基础知识
 */
public class BaseKnowLearn {


    public  void buffer() {
        Integer a = 1;
        Integer b = 1;
        System.out.println(a.byteValue());
        System.out.println(b.byteValue());
        System.out.println(super.toString());
    }


    public static void main(String[] args) {
        BaseKnowLearn baseKnowLearn = new BaseKnowLearn();
        baseKnowLearn.buffer();
        baseKnowLearn.abstractExample();
        System.out.println(baseKnowLearn.hashCode());

    }

    public void abstractExample() {
        AbstractClassExampleExtend exampleExtend = new AbstractClassExampleExtend();
        exampleExtend.b = "1";
        exampleExtend.say();
        System.out.println(exampleExtend.b);
        Class<? extends AbstractClassExampleExtend> aClass = exampleExtend.getClass();
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            try {
                method.invoke(null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
