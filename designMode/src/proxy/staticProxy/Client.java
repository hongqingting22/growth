package proxy.staticProxy;

import proxy.staticProxy.impl.Teacher;

public class Client {

    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        TeacherProxy proxy = new TeacherProxy(teacher);
        proxy.teach();
    }
}
