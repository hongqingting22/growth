package proxy.dynamic;


import proxy.dynamic.impl.Teacher;

public class Client {

    public static void main(String[] args) {
        ITeacher teacher = new Teacher();
        Object proxyInstance = new ProxyFactory(teacher).getProxyInstance();

        System.out.println(proxyInstance.getClass());

        ITeacher proxyTeacher = (ITeacher)proxyInstance;
        proxyTeacher.teach();
    }
}
