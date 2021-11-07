package com.lhy.task2;

public class NewPhone extends CellPhone implements IPlayGame{

    @Override
    public void call(int number) {
        System.out.printf("新手机打电话给%d\n",number);
    }

    @Override
    public void sendMessage(int number, String message) {
        System.out.printf("新手机发送%s给%d\n",message,number);
    }

    @Override
    public void playGame() {
        System.out.print("新手机玩游戏\n");
    }
}
