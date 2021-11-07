package com.lhy.task1;

public class Manager extends Worker{

    private int bonus;

    public Manager() {
    }

    public Manager(String name, int id, int salary, int bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.printf("工号为%d基本工资为%d奖金为%d的项目经理%s正在努力的做着管理工作,分配任务,检查员工提交上来的代码.....\n",getId(),getSalary(),getBonus(),getName());
    }
}
