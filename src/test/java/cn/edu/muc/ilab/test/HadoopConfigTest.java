package cn.edu.muc.ilab.test;

import cn.edu.muc.ilab.hbaseadmin.demo.User;
import cn.edu.muc.ilab.hbaseadmin.demo.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by Raymond on 2017/3/25.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HadoopConfigTest {
    @Autowired
    private UserRepository userRepository;
    @Test
    public void test() {
        List<User> all = userRepository.findAll();
        System.out.println(all.toString());
    }
}
