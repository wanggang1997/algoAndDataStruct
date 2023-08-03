package com.pers.design.principle.openclose;

public class Test {
    public static void main(String[] args) {
        ICourse javaCourse = new JavaCourse(1,"java课程",199D);

        System.out.println(javaCourse.getId() +"::"+javaCourse.getName()  +"::"+javaCourse.getPrice());

        ICourse javaDiscountCourse = new JavaDiscountCourse(2,"java打折课程",199D);

        System.out.println(javaDiscountCourse.getId() +"::"+javaDiscountCourse.getName()  +"::"+javaDiscountCourse.getPrice()+"::"+ ((JavaDiscountCourse) javaDiscountCourse).getOriginPrice());


    }
}
