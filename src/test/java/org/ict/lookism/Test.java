package org.ict.lookism;

import org.hibernate.id.uuid.UuidGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.hibernate.id.UUIDGenerator;

@SpringBootTest
@Component
public class Test {
    @Value("${filesPath}")
    private String filesPath;

    @org.junit.jupiter.api.Test
    public void testMethod(){
        System.out.println(filesPath);
        System.out.println(System.getProperty("user.dir"));
    }
}
