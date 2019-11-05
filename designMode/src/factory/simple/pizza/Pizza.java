package factory.simple.pizza;

public abstract class Pizza {
    private String name;

    public void prepare(){
        System.out.println(name + "准配材料");
    }
    public void bake(){
        System.out.println(name + "烘焙");
    }
}
