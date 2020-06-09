package com.example.demo;

import com.demo.test14.service.CommodityService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void test(){
        try {
            String sql = "select name,cno from student2";
            List<String> strings = jdbcTemplate.queryForList(sql, String.class);
            System.out.println(strings);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
        }
    }

    long timed = 0L;

    @Before
    public void start(){
        System.out.println("开始压测");
        timed = System.currentTimeMillis();
    }

    public void end(){
        System.out.println("测试完成，执行时长："+ (System.currentTimeMillis()- timed) );
    }

    private static final int THREAD_NUM = 1000;
    private CountDownLatch countDownLatch = new CountDownLatch(THREAD_NUM);
/*
    @Autowired
    private CommodityService commodityService;

    @Test
    public void test2(){
        for (int i = 0; i < THREAD_NUM; i++) {
            final String code = "code-" + (i +1);
            Thread thread = new Thread(() -> {
                try {
                    countDownLatch.await();
                    Map<String, Object> result = commodityService.queryCommodity(code);
                    System.out.println("查询结束，结果：" + result);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(Thread.currentThread().getName() + "线程执行出现异常" + e.getMessage());
                }
            });
            thread.setName("price-thread-" + code);
            thread.start();
            countDownLatch.countDown();
        }

    }
    */
}
