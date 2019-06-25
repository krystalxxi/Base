package com.demo.base.java8;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Krystal on 2019/4/3.
 */
public class Car {
    @FunctionalInterface
    public interface Supplier<T>{
        T get();
    }

    public static Car create(final Supplier<Car> supplier){
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }

    public static void main(String[] args){
        Car car = Car.create(Car::new);
        Car car1 = Car.create(Car::new);
        Car car2 = Car.create(Car::new);
        Car car3 = new Car();
        List<Car> cars = Arrays.asList(car,car1,car2,car3);
        System.out.println("==构造器引用==");
        // 语法是Class：：static_method
        cars.forEach(Car::collide);
        System.out.println("==静态方法引用==");
        // 语法是Class：：method
        cars.forEach(Car::repair);
        System.out.println("==特定类的任意对象的方法引用==");
        // 语法是instance::method
        final Car police  = Car.create(Car::new);
        cars.forEach(police::follow);
    }

}
