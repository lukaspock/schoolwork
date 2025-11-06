package at.htlpinkafeld;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class TestStack {

    private Stack stack;



    @BeforeEach
    void setUp(){
        this.stack = new Stack();
        this.stack.push(new Volume(3.0,2.0,1.0));
        this.stack.push(new ValueAddedTax(2.0,3.0));
        double[] ar = {2.0,3.0,4.0};
        this.stack.push(new Average(ar));

    }

    @AfterEach
    void tearDown(){
        this.stack = null;
    }

    @Test
    void getSize() {
        assertEquals(5,this.stack.getSize());
    }

    @Test
    void getEleCnt() {
        assertEquals(3,this.stack.getEleCnt());
    }

    @Test
    void isEmpty() {
        assertFalse(this.stack.isEmpty());
    }

    @Test
    void isFull() {
        assertFalse(this.stack.isFull());
    }

    @Test
    void push() {
        System.out.println(this.stack);
        assertEquals(3,this.stack.getEleCnt());
    }

    @Test
    void pop() {
        System.out.println(this.stack.pop());
        assertEquals(2,this.stack.getEleCnt());
    }

    @Test
    void getAverage() {
        assertEquals(5,this.stack.getAverage());
    }



    @Test
    void getSum() {
        assertEquals(15,this.stack.getSum());
    }
}