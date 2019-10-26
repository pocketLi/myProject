
import com.myProject.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-mybatis.xml"})
public class SpringMybatisTest {

    @Autowired
    private UserService userServiceImpl;

    @Test
    public void test1(){
        System.out.println(userServiceImpl.findAll());
    }
}
