package at.htlpinkafeld;

import java.util.Arrays;

public class Stack {

    Calculation[] stack;
    int count;

    public Stack(){
        this.stack = new Calculation[5];
    }

    public int getSize(){
        return this.stack.length;
    }

    public int getEleCnt(){
        return this.count;
    }

    public boolean isEmpty(){
        return this.getSize() == 0;
    }

    public boolean isFull(){
        return this.getEleCnt() == this.getSize();
    }

    public void push(Calculation val) {
        if (this.isFull()) {
            Calculation[] newStack = new Calculation[this.stack.length + 1];
            for (int i = 0; i < this.stack.length; i++) {
                newStack[i] = this.stack[i];
            }
            this.stack = newStack;
        }
        this.stack[this.count] = val;
        this.count++;
    }


    public Calculation pop() {
        if (this.isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }

        int index = this.getEleCnt() - 1;
        Calculation rv = this.stack[index];

        this.stack[index] = null;
        this.count--;

        return rv;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "stack=" + Arrays.toString(stack) +
                ", count=" + count +
                '}';
    }

    public double getAverage(){
        double avg = 0;
        for(int i = 0; i < this.getEleCnt(); i++){
            avg += this.stack[i].calculate();
        }
        return avg/this.getEleCnt();
    }

    public double getSum(){
        double sum = 0;
        for(int i = 0; i < this.getEleCnt(); i++){
            sum += this.stack[i].calculate();
        }
        return sum;
    }
}
