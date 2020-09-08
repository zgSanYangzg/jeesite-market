package com.jeesite.modules.utils;

import java.util.concurrent.*;

public abstract class TimeOverApi {

    public abstract String process();

    //实际调用方法
    public String deal() {
        String finallyResult = null;
        Callable<String> task = new Callable<String>() {
            @Override
            public String call() throws Exception {
//                Thread.sleep(5000); 故意错误
                return process();

            }
        };
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(task);

        try {
            finallyResult = future.get(3, TimeUnit.SECONDS);

        } catch (InterruptedException e) {
            System.out.println("处理中断啦....");
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("处理异常啦....");
            e.printStackTrace();
        } catch (TimeoutException e) {
            System.out.println("处理超时啦....");
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
        return finallyResult;
    }
}
