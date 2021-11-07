package com.lhy.task2;

public class Test {
    static void playGame(IPlayGame joyer) {
        joyer.playGame();
    }
    public static void main(String[] args) {
        NewPhone iphone = new NewPhone();
        playGame(iphone);
        iphone.call(12345);
        iphone.sendMessage(1357,"hello");

        OldPhone old = new OldPhone();
        old.call(246);
        old.sendMessage(110, "help");
    }
}
