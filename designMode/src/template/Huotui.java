package template;

public abstract class Huotui {
    String name;

    final void make(){
        select();
        tasty();
        shape();
        complete();
    }

    void select(){
        System.out.println("充足的面粉和水");
    }

    abstract void tasty();

    void shape(){
        System.out.println("做成固定形状");
    }

    void complete(){
        System.out.println("做成美味的" + name + "火腿");
    }



}
