package bridge;

import bridge.impl.GameSoft;

public class Client {
    public static void main(String[] args) {
        Mode ios = new Mode("ios","2.0");
        Soft game = new GameSoft("斗地主");

        Phone phone = new Phone(ios, game) ;

        phone.play();

    }
}
