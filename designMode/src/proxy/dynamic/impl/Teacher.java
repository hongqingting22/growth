package proxy.dynamic.impl;

import proxy.dynamic.ITeacher;

public class Teacher implements ITeacher {
    @Override
    public void teach() {
        System.out.println("上课");
    }
}
