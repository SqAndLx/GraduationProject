package com.practice.ExecutorPool;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


@Component
@Slf4j
public class SyncExecutor {

    @Getter
    private ExecutorService executorService;

    //线程池大小如果没有配置默认为5
    @Value("${ThreadCount:5}")
    private int threadCount;


    /**
     * 初始化创建线程池
     */
    @PostConstruct
    private void exector() {
        ExecutorService eService = new ThreadPoolExecutor(threadCount, threadCount, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(100), (r, executor) -> {
            if (!executor.isShutdown()) {
                try {
                    executor.getQueue().put(r);
                } catch (InterruptedException e) {
                    log.error("多线程队列溢出，任务执行失败！", e);
                }
            }
        });
        executorService = eService;
    }

}
