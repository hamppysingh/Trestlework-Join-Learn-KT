package com.trestle.redis.Cashing.Model;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@RedisHash("Student")
public class Student implements Serializable {
    Integer id;
    String name;
}
