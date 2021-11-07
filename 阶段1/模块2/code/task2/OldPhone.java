package com.lhy.task2;

public class OldPhone extends CellPhone{
    @Override
    public void call(int number) {
        System.out.printf("旧手机打电话给%d\n",number);
    }

    @Override
    public void sendMessage(int number, String message) {
        System.out.printf("旧手机发送%s给%d\n",message,number);
    }
}
