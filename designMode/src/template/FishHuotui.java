package template;

public class FishHuotui extends Huotui {
    public FishHuotui() {
        name = "鱼肉";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    void tasty() {
        System.out.println("加入鱼肉");
    }
}
