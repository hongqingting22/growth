package observer;

public abstract class Observer {

    private String observerState;

    public void update(String state){
        this.observerState = state;
        System.out.println("update");
    }
}
