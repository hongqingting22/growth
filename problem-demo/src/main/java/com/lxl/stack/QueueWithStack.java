package com.lxl.stack;

import java.util.Stack;

/**
 * 使用两个栈实现队列
 */
public class QueueWithStack {

    class MyQueue{
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();;
        int size = 0;

        public void push(int item){
            stack1.push(item);
            size++;
        }

        public int pop(){
            if(stack1.isEmpty()){
                return -1;
            }else if(stack1.size() == 1){
                size--;
                return stack1.pop();
            }else{
                int size = stack1.size();
                for(int i=1;i<size;i++){
                    Integer pop = stack1.pop();
                    stack2.push(pop);
                }
                Integer pop = stack1.pop();
                for(int i = 1; i<size;i++){
                    Integer pop1 = stack2.pop();
                    stack1.push(pop1);
                }
                size--;
                return pop;
            }
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new QueueWithStack().new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        int size = queue.size;
        for(int i =0 ;i<size;i++){
            int pop = queue.pop();
            System.out.println(pop);
        }
    }

}
