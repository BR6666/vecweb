package com.foxgod.vecweb;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VecwebApplicationTests {

    @Test
    void contextLoads() {

        String HashName = "MD5";
        Object credentils = "123456";
        Object salt = ByteSource.Util.bytes("test");
        int hashInt = 1024;
        Object result = new SimpleHash(HashName, credentils, salt, hashInt);
        System.out.println(result);
    }

}
