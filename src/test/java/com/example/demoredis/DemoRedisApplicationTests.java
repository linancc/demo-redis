package com.example.demoredis;

import com.example.demoredis.entity.Student;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoRedisApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("student:1", "linan");
        Assertions.assertThat(redisTemplate.opsForValue().get("student:1")).isEqualTo("linan");
    }

    @Test
    public void test02() {
        stringRedisTemplate.opsForValue().set("student:2", "linan");
        Assertions.assertThat(stringRedisTemplate.opsForValue().get("student:2")).isEqualTo("linan");
    }

    @Test
    public void test03() {
        Student student3 = new Student();
        student3.setName("linan");
        student3.setId("3");
        student3.setHobbies(Arrays.asList("coding", "write blog", "eat chicken"));
        redisTemplate.opsForValue().set("student:3", student3);
    }

}
