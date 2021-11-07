package com.lhy.task1;

public class WorkerTest {

    public static void main(String[] args) {

        Manager m1 = new Manager("一龙" ,123, 15000, 6000);
        m1.work();
        Manager m2 = new Manager();
        m2.setName("一龙");
        m2.setId(123);
        m2.setSalary(15000);
        m2.setBonus(6000);
        m2.work();

        Coder c1 = new Coder("方便" ,135 ,10000);
        c1.work();
        Coder c2 = new Coder();
        c2.setName("方便");
        c2.setId(135);
        c2.setSalary(10000);
        c2.work();

    }
}
