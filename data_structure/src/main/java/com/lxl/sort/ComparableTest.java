package com.lxl.sort;

public class ComparableTest {

    public static void main(String[] args) {
        Student s1 = new ComparableTest().new Student();
        s1.name = "张三";
        s1.age = 18;

    }

    class Student implements Comparable<Student>{
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int compareTo(Student o) {
            return this.age - o.age;

        }
    }
}
