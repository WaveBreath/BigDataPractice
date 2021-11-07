package com.lhy.task1;

public class Coder extends Worker{
    public Coder() {
    }

    public Coder(String name, int id, int salary) {
        super(name, id, salary);
    }

    @Override
    public void work() {
        System.out.printf("工号为%d基本工资为%d的程序员%s正在努力的写着代码......操作步骤描述\n",getId(),getSalary(),getName());
    }
}
