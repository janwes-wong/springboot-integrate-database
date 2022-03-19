package com.janwes;

import com.janwes.utils.SecurityUtil;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Janwes
 * @version 1.0.0
 * @package com.janwes
 * @date 2022/3/19 17:28
 * @description
 */
@SpringBootTest
public class SecurityTest {

    @Test
    public void init() {
        String password = SecurityUtil.encrypt("root");
        System.out.println(password);
    }
}
