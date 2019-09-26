package bridge;

public class Phone {
    Mode mode;
    Soft soft;

    public Phone(Mode mode,Soft soft) {
        this.mode = mode;
        this.soft = soft;
    }

    public void play(){
        System.out.println(mode.name + "手机" + mode.version + "启动");
        soft.run();
    }
}
