package com.lovethefeel.async;

import com.lovethefeel.async.application.GitHubLookupService;
import com.lovethefeel.async.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

/**
 * There is also a CommandLineRunner that injects the GitHubLookupService and calls that service three times to demonstrate the method is executed asynchronously.
 */
@Component
public class AppRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    private final GitHubLookupService gitHubLookupService;

    public AppRunner(GitHubLookupService gitHubLookupService) {
        this.gitHubLookupService = gitHubLookupService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Start the clock
        long start = System.currentTimeMillis();

        // Kick of multiple, asynchronous lookups
        CompletableFuture<User> page1 = gitHubLookupService.findUser("PivotalSoftware");
        logger.info("--> First Call");
        CompletableFuture<User> page2 = gitHubLookupService.findUser("CloudFoundry");
        logger.info("--> Second Call");
        CompletableFuture<User> page3 = gitHubLookupService.findUser("Spring-Projects");
        logger.info("--> Third Call");

        // Wait until they are all done
        logger.info("--> Call Wait Response");
        CompletableFuture.allOf(page1, page2, page3).join();

        // Print results, including elapsed time
        logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
        logger.info("--> " + page1.get());
        logger.info("--> " + page2.get());
        logger.info("--> " + page3.get());
    }

    /**
     * The application shows logging output, showing each query to GitHub. With the help of the allOf factory method, we create an array of CompletableFuture objects. By calling the join method, it is possible to wait for the completion of all of the CompletableFuture objects.
     *
     * The following listing shows typical output from this sample application:
     *
     * CompletableFutre - 편하게 비동기 작업을 할 수 있지만, 별도의 쓰레드를 생성해서 처리하기 때문에 의도치 않게 시스템 성능을 떨어뜨릴 수 있다. 가능하면 flux 의 다양한 연산자를 사용해서 flux 로 처리한다.
     */
}
