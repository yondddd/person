package com.lm.blog.server.learn.base.anno;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author yond
 * @date 2023/8/12
 * @description
 */
public class Chinese implements SpeakAction{


    @Override
    @MyAnnotation
    public void sayHi() {

    }

    public static void main(String[] args) {
        Annotation[] declaredAnnotations = Chinese.class.getDeclaredAnnotations();
        for (Annotation annotation : declaredAnnotations) {
            System.out.println(annotation.toString());
        }
        for (Method method : Chinese.class.getMethods()) {
            for (Annotation declaredAnnotation : method.getDeclaredAnnotations()) {
                System.out.println(declaredAnnotation.toString());
            }
        }
    }

}
