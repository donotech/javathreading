package java_threading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureDemo {
    static ExecutorService executorService = Executors.newFixedThreadPool(10);

    static void cfExample() throws InterruptedException, ExecutionException {
        CompletableFuture<Void> cf = CompletableFuture.runAsync(()->{
            System.out.println("Running a runnable task");
        }, executorService);
        System.out.println("Returned Value- " + cf.get());
    }

    static void cfSupplyExample() throws InterruptedException, ExecutionException {
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(()->{
            System.out.println("Running a task");
            return "Task Completed";
        }, executorService);

        System.out.println("Returned Value- " + cf.get());
    }

    static void cfThenApplyExample() throws InterruptedException, ExecutionException {
        StringBuilder sb = new StringBuilder();
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(()->{
            return "Completable";
        }, executorService).thenApplyAsync(s->sb.append(s).append("Future").toString(), executorService);
        System.out.println("Returned Value- " + cf.get());
    }

    static void cfExampleCombine() throws InterruptedException, ExecutionException {
        CompletableFuture<String> cf = getHello().thenCombineAsync(getWorld(),
                (s1, s2)->s1+ " " +s2, executorService);
        System.out.println("Value- " + cf.get());
    }

    static CompletableFuture<String> getHello(){
        return CompletableFuture.supplyAsync(()->{return "Hello";}, executorService);
    }

    static CompletableFuture<String> getWorld(){
        return CompletableFuture.supplyAsync(()->{return "World";}, executorService);
    }

    public static void main(String[] args) {
        try {
            cfExample();
            cfSupplyExample();
            cfThenApplyExample();
            cfExampleCombine();
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
