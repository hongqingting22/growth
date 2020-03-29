package proxy.staticProxy;

import proxy.staticProxy.impl.Teacher;

public class TeacherProxy implements ITeacher {

    private Teacher teacher;

    public TeacherProxy(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public void teach() {
        System.out.println("kKKK");
        teacher.teach();
    }
}
