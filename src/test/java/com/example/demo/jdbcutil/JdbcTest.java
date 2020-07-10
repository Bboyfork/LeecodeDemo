package com.example.demo.jdbcutil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * jdbc 测试
 * */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcTest {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void Test01(){
        jdbcTemplate.execute("delete from student where id = 52;");
        jdbcTemplate.execute("insert into student (id,name,course,score) VALUES (55,'王二','bbc',32)");
    }

}
