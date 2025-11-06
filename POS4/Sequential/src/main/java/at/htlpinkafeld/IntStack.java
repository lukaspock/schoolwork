package at.htlpinkafeld;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class IntStack implements Sequential {

    private int[] stack;
    private int iteratorIndex;

    public static void main(String[] args) {

        }

    public IntStack(int size) {

        stack = new int[size];
        iteratorIndex = 0;
    }

    public IntStack(){
        this(1);
    }

    public int getSize(){
        return stack.length;
    }

    public int getEleCnt(){
        for(int i=0;i<this.getSize();i++){
            if(this.stack[i] == 0){
                return i;
            }
        }
        return 0;
    }

    public void push(int value){
        if(this.isFull()){
            System.out.println("Stack is full");
            return;
        }
        else{
            stack[this.getEleCnt()] = value;
        }


    }

    public boolean isFull(){
        if(this.getEleCnt() == this.getSize()){
            return true;
        }else{
            return false;
        }
    }

    public int pop(){
        if(this.isEmpty()){
            System.out.println("Stack is empty");
            return 0;
        }
        int value = this.stack[this.getEleCnt() - 1];
        this.stack[this.getEleCnt()] = 0;
        return value;
    }

    public boolean isEmpty(){
        if(this.getEleCnt() == 0){
            return true;
        }
        return false;
    }

    public int peek(){
        return this.stack[this.getEleCnt() - 1];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("( ");
        for(int i=0; i < this.getEleCnt(); i++){
            sb.append(this.stack[i]);
            sb.append(", ");
        }
        sb.append(" )");
        return sb.toString();
    }

    public boolean resize(int size){
        if(this.getEleCnt() > size){
            return false;
        }
        else{
            int[] ar = new  int[size];
            for(int i=0; i < this.getEleCnt(); i++){
                ar[i] = stack[i];
            }
            this.stack = ar;
            return true;
        }
    }

    @Override
    public Object getFirst(){
        this.iteratorIndex = this.getEleCnt() - 1;
        if(this.iteratorIndex == -1){
            return null;
        }
        else{
            return stack[this.iteratorIndex--];
        }
    }

    @Override
    public Object getNext(){
        if(this.iteratorIndex == -1){
            return null;
        }
        else{
            return stack[this.iteratorIndex--];
        }
    }


}
