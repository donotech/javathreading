package java_threading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceDemo {
    public static void simple_executor_service() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.execute(new Runnable() {
            public void run() {
                System.out.println("Asynchronous task");
            }
        });

        executorService.shutdown();
    }

    public static void executor_service_with_futures_and_runnable() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Future future = executorService.submit(new Runnable() {
            public void run() {
                System.out.println("Asynchronous task");
            }
        });

        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }

    public static void executor_service_with_futures_and_callable() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Future<String> future1 = executorService.submit(new Callable<String>() {
            public String call() {
                System.out.println("Asynchronous task 1");
                return "Task 1";
            }
        });


        try {
            String callableRespone = future1.get();
            System.out.println("Return from callable service " + callableRespone);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }

    public static void executor_service_with_multiple_callable() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<Callable<String>> callables = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            int finalI = i;
            callables.add(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    String mesg = "Return from callable " + finalI;
                    System.out.println("Finished callable " + finalI);
                    Thread.sleep(100);
                    return mesg;
                }
            });
        }

        List<Future<String>> futures = null;
        try {
            futures = executorService.invokeAll(callables);
            for(Future<String> future : futures){
                System.out.println("future.get = " + future.get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }


    public static void main(String[] args) {
        //simple_executor_service();
        //executor_service_with_futures_and_runnable();
        //executor_service_with_futures_and_callable();
        //executor_service_with_multiple_callable();
    }
}
