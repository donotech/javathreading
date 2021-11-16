package java_threading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TwoSums {

    private int sum1 = 0;
    private int sum2 = 0;

    private Integer sum1Lock = new Integer(1);
    private Integer sum2Lock = new Integer(2);
    private static int myStaticVar = 0;
    List<Integer> syncList = Collections.synchronizedList(new ArrayList<Integer>()); //thread safe list

    public synchronized void changeStatic(int newValue) { //useless as it cant protect a static variable
        myStaticVar = newValue;
    }

    public synchronized void addList(List<Integer> val1) { //Thread T3 can change val1 while addList is called
        val1.add(sum1);
        val1.add(sum2);
    }

    public synchronized void addLockMethod(int val1, int val2){
        this.sum1 += val1;
        this.sum2 += val2;
    }

    public void changeValue(int valToChange) {
        this.sum1 = valToChange;
    }

    public void addLockAll(int val1, int val2){
        synchronized(this){
            this.sum1 += val1;
            this.sum2 += val2;
        }
    }

    public void add(int val1, int val2){
        synchronized(this.sum1Lock){
            this.sum1 += val1;
        }
        synchronized(this.sum2Lock){
            this.sum2 += val2;
        }
    }
}