package com.tobyspring.helloboot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FilteringApples {

    public static void main(String[] args) {
        //System.out.println("================");
        List<Apple> inventory = Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red")
        );

        // 1. 예전 방식 녹색 사과 필터링
        List<Apple> greenApples = FilteringApples.filterGreenApples(inventory);
        System.out.println(greenApples);

        //2. 150 이상 사과 필터링
        List<Apple> HeavyApples = FilteringApples.filterHeavyApples(inventory);
        System.out.println(HeavyApples);


        System.out.println("================================================");
        System.out.println("자바8 방식으로 변경");
        System.out.println("================================================");

        System.out.println("자바8 예제 1");
        List<Apple> greenApples2 = FilteringApples.filterApples(inventory, FilteringApples::isGreenApple);
        System.out.println(greenApples2);

        List<Apple> HeavyApples2 = FilteringApples.filterApples(inventory, FilteringApples::isHeavyApple);
        System.out.println(HeavyApples2);

        System.out.println("자바8 예제 2 축약형");
        List<Apple> greenApples3 = FilteringApples.filterApples(inventory, (Apple a) -> a.getColor().equals("green"));
        System.out.println(greenApples3);

        List<Apple> HeavyApples3 = FilteringApples.filterApples(inventory, (Apple a) -> a.getWeight() > 150);
        System.out.println(HeavyApples3);

        List<Apple> filterApples = FilteringApples.filterApples(inventory, (Apple a) -> a.getWeight() < 80 ||
                "red".equals(a.getColor()));
        System.out.println(filterApples);

    }

    public static void myPrint(List<Apple> apples) {
        for (Apple apple : apples) {
            System.out.println(apple.toString());
        }
    }

    // 1.예전 방식
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    // 2.예전 방식
    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }

    // 3. 자바8 방식
    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    //4. 자바8 방식
    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    //5. 3과 4를 이용
    // 메서드가 p라는 이름의 프레디케이트 파라미터로 전달됨
    /*
    참고로
    public interface Predicate<T>{
        boolean test(T t);
    }
     */
    public static List<Apple> filterApples(List<Apple> inventory,
                                           Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @SuppressWarnings("boxing")
        @Override
        public String toString() {
            return String.format("Apple{color='%s', weight=%d}", color, weight);
        }
    }
}