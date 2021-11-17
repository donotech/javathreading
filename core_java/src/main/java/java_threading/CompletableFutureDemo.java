package java_threading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {
    static void cfExample() throws InterruptedException, ExecutionException {
        CompletableFuture<Void> cf = CompletableFuture.runAsync(()->{
            System.out.println("Running a runnable task");
        });
        System.out.println("Returned Value- " + cf.get());
    }

    static void cfSupplyExample() throws InterruptedException, ExecutionException {
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(()->{
            System.out.println("Running a task");
            return "Task Completed";
        });

        System.out.println("Returned Value- " + cf.get());
    }

    static void cfThenApplyExample() throws InterruptedException, ExecutionException {
        StringBuilder sb = new StringBuilder();
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(()->{
            return "Completable";
        }).thenApplyAsync(s->sb.append(s).append("Future").toString());
        System.out.println("Returned Value- " + cf.get());
    }

    static void cfExampleCombine() throws InterruptedException, ExecutionException {
        CompletableFuture<String> cf = getHello().thenCombine(getWorld(), (s1, s2)->s1+ " " +s2);
        System.out.println("Value- " + cf.get());
    }

    static CompletableFuture<String> getHello(){
        return CompletableFuture.supplyAsync(()->{return "Hello";});
    }

    static CompletableFuture<String> getWorld(){
        return CompletableFuture.supplyAsync(()->{return "World";});
    }

    public static void main(String[] args) {
        try {
            cfExample();
            cfSupplyExample();
            cfThenApplyExample();
            cfExampleCombine();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
