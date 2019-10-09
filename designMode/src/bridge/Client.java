package bridge;

import bridge.impl.GameSoft;

import java.net.URLDecoder;

public class Client {
    public static void main(String[] args) throws Exception{
        Mode ios = new Mode("ios","2.0");
        Soft game = new GameSoft("斗地主");

        Phone phone = new Phone(ios, game) ;

        phone.play();

        String decode = URLDecoder.decode("%25E7%25BE%258E%25E6%259C%25AF%25E5%25AE%259D1%25E5%25AF%25B91%25E5%25AE%25A2%25E6%259C%258D%25E8%2580%2581%25E5%25B8%2588", "UTF-8");
        System.out.println(decode);

    }
}
