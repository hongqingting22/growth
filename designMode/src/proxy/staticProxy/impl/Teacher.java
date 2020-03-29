package proxy.staticProxy.impl;

import proxy.staticProxy.ITeacher;

public class Teacher implements ITeacher {
    @Override
    public void teach() {
        System.out.println("上课");
    }
}
