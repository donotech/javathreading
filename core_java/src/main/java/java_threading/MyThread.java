package java_threading;

class MyRunnable implements Runnable {
    String something;

    public MyRunnable(String something) {
        this.something = something;
    }

    public void someOtherMethods() {
        System.out.println("blah");
        System.out.println("someMethods thread name " + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("This is my runnable thread");
        System.out.println("This is  " + something);
        for(int i = 0; i<5; i++) {
            System.out.println("In " + something + " i = " + i);
            try {
                Thread.sleep(1000);
                someOtherMethods();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class MyThread extends Thread {

    @Override
    public void run(){
        System.out.println("MyThread running " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("Print im in main thread");

        Thread  namedThread = new Thread("My name is khan") {
            public void run(){
                System.out.println("run by: " + getName());
            }
        };

        namedThread.start();
        System.out.println("Current name : " + Thread.currentThread().getName());

        MyRunnable runnable = new MyRunnable("My Runnable Thread");
        runnable.someOtherMethods();

        Thread runnableThread = new Thread(runnable, "Runnable thread");

        runnableThread.start();

        Thread  infiniteThread = new Thread("My name is infinity") {
            public void run(){
                for(int i = 0; i<10; i++) {
                    try {
                        System.out.println("waiting: " + getName() + " i = " + i);
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("run by: " + getName());
            }
        };

        infiniteThread.start();
    }
}
