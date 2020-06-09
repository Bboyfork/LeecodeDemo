package com.demo.test14.service;

import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * 请求合并demo
 * @author Bboy_fork
 * @date 2020年5月28日22:34:40
 * */
@Service
public class CommodityService {
/*
    class Request{
        String code;
    }

    LinkedBlockingQueue<Request> queue =  new LinkedBlockingQueue();

    @PostConstruct
    public void init(){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(()->{
            int size = queue.size();
            if(size == 0){
                return;
            }
            ArrayList<Request> requests = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                requests.add(queue.poll());
            }
            System.out.println("合并了"+ size+"条，但还没处理");

            List<String> cods = new ArrayList<>();
            for (Request request:requests) {
                cods.add(request.code);
            }

        },0,10, TimeUnit.MILLISECONDS);
    }


    public Map<String,Object> queryCommodity(String code) throws ExecutionException{
        Request request = new Request();
        request.code = code;
        queue.add(request);
    }
    */
}
