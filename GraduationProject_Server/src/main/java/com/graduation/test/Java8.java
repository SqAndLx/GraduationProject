package com.graduation.test;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Java8 {

    public static void main(String[] args) {
        List<Employee> emps = Arrays.asList(
                new Employee("张三", 18, 9999.99),
                new Employee("李四", 59, 6669.99),
                new Employee("王五", 18, 3333.99),
                new Employee("赵六", 18, 2222.99),
                new Employee("田七", 18, 5555.99),
                new Employee("田七", 18, 5555.99),
                new Employee("田七", 18, 5555.99),
                new Employee("田七", 18, 5555.99),
                new Employee("java", 18, 15555.99)
        );

        emps.stream().filter(e -> {
            System.out.println("短路");
            return e.getSalary() > 5000;
        }).limit(2).forEach(item -> System.out.println(JSON.toJSONString(item)));
        System.out.println("-----------------");

        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "dddd", "eeee");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
        emps.stream().map(Employee::getName).forEach(System.out::println);
        System.out.println("-----------------");

        emps.stream().sorted((a, b) -> a.getAge() == b.getAge() ? a.getName().compareTo(b.getName()) : a.getAge() - b.getAge())
                .forEach(item ->System.out.println(JSON.toJSONString(item)));
        System.out.println("-----------------");

        Optional<Employee> first = emps.stream().sorted((e1, e2) -> -Double.compare(e1.getSalary(),
                e2.getSalary())).findFirst();
        System.out.println(JSON.toJSONString(first.get()));

        System.out.println("----归约---------");
        /**
         * 归约
         */
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Integer sum = list2.stream().reduce(0, Integer::sum);
        System.out.println(sum);

       System.out.println("-------------");

         Optional<Double> reduce = emps.stream().map(Employee::getSalary).reduce(Double::sum);
         System.out.println(reduce.get());
//        // 获取中文环境
//        Comparator comparator = Collator.getInstance(Locale.CHINA);
//        // 按照首字母排序
//        Collections.sort(emps, (e1, e2) -> comparator.compare(e1.getAge(), e2.getAge()));
    }
}
