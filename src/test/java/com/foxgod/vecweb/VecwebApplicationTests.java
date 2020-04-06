package com.foxgod.vecweb;

import com.foxgod.monitor.Server;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VecwebApplicationTests {

    @Test
    void contextLoads() throws Exception {


        Server server=new Server();
        server.info();
        System.out.println(server.getCpu().toString());
        System.out.println(server.getMem().getTotal());

//        String HashName = "MD5";
//        Object credentils = "123456";
//        Object salt = ByteSource.Util.bytes("test");
//        int hashInt = 1024;
//        Object result = new SimpleHash(HashName, credentils, salt, hashInt);
//        System.out.println(result);
    }


}
