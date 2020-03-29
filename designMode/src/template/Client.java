package template;

public class Client {
    public static void main(String[] args) {
        Huotui beafHuotui = new BeefHuotui();
        beafHuotui.make();

        FishHuotui fishHuotui = new FishHuotui();
        fishHuotui.make();
    }
}
