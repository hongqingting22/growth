package template;

public class BeefHuotui extends Huotui {
    public BeefHuotui() {
        name = "牛肉";
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    void tasty() {
        System.out.println("加入牛肉");
    }
}
