package com.lm.blog.server.learn.base.knows;

import com.google.common.collect.Lists;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author yond
 * @date 2023/7/27
 * @description 泛型
 */
public class GenericExample extends Exception {


    public static List<Integer> integerList = new ArrayList<>();

    public <T extends Integer>void addInt(T t) {
        integerList.add(t);
    }


    public <T extends Integer> void addInt(List<? extends T> t) {
        integerList.addAll(t);
    }

    public static void main(String[] args) {
        GenericExample genericExample = new GenericExample();
        genericExample.addInt(Lists.newArrayList(1));
        try {
            integerList.getClass().getMethod("add", Object.class).invoke(integerList, "asd");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(GenericExample.integerList);
    }


    private  <E extends Comparable<? super E>> E max(List<? extends E> e1) {
        if (e1 == null){
            return null;
        }
        //迭代器返回的元素属于 E 的某个子类型
        Iterator<? extends E> iterator = e1.iterator();
        E result = iterator.next();
        while (iterator.hasNext()){
            E next = iterator.next();
            if (next.compareTo(result) > 0){
                result = next;
            }
        }
        return result;
    }

//    //工资低于2500元的上斑族并且站立的乘客车票打8折
//    public static <T extends Staff & Passenger> void discount(T t){
//        if(t.getSalary()<2500 && t.isStanding()){
//            System.out.println("恭喜你！您的车票打八折！");
//        }
//    }

}
