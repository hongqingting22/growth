package bridge.impl;

import bridge.Soft;

public class GameSoft extends Soft {
    public GameSoft(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();
        System.out.println("进入游戏战场");
    }
}
