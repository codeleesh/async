package com.lovethefeel.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * To run a sample, you can create an executable jar.
 * Spring’s @Async annotation works with web applications, but you need not set up a web container to see its benefits.
 * The following listing (from src/main/java/com/example/asyncmethod/AsyncMethodApplication.java) shows how to do so:
 *
 * The @EnableAsync annotation switches on Spring’s ability to run @Async methods in a background thread pool.
 * This class also customizes the Executor by defining a new bean.
 * Here, the method is named taskExecutor, since this is the specific method name for which Spring searches.
 * In our case, we want to limit the number of concurrent threads to two and limit the size of the queue to 500.
 * There are many more things you can tune.
 * If you do not define an Executor bean, Spring creates a SimpleAsyncTaskExecutor and uses that.
 */
@SpringBootApplication
public class AsyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsyncApplication.class, args);
    }
}
