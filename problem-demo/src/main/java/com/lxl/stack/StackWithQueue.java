package com.lxl.stack;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 使用队列实现栈
 */
public class StackWithQueue {

    class MyStack{
        Queue<Integer> queue1 = new ArrayBlockingQueue<>(10);
        Queue<Integer> queue2 = new ArrayBlockingQueue<>(10);
        int size = 0;
        public void add(Integer item){
            queue1.add(item);
            size++;
        }

        public Integer poll(){
            if(queue1.isEmpty()){
                return -1;
            }else if(queue1.size() == 1){
                size--;
                return queue1.poll();
            }else{
                int size = queue1.size();
                for(int i = 1;i<size;i++){
                    Integer poll = queue1.poll();
                    queue2.add(poll);
                }
                Integer poll = queue1.poll();
                for(int i = 1;i<size;i++){
                    Integer poll1 = queue2.poll();
                    queue1.add(poll1);
                }
                size--;
                return poll;
            }
        }
    }

    public static void main(String[] args) {
        MyStack myStack = new StackWithQueue().new MyStack();
        myStack.add(1);
        myStack.add(2);
        myStack.add(3);
        int size = myStack.size;
        for(int i = 0; i<size;i++){
            Integer poll = myStack.poll();
            System.out.println(poll);
        }

    }
}
