package bridge;

public abstract class Soft {
    String name;

    public Soft(String name) {
        this.name = name;
    }

    public void run(){
        System.out.println(name + "运行");
    }
}
