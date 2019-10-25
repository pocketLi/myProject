import com.myProject.mapper.UserMapper;
import com.myProject.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import java.util.UUID;


public class MybatisTest {

    private SqlSession sqlSession;
    private UserMapper mapper;

    @Before
    public void start() throws IOException {
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void test1(){
        System.out.println(mapper.findAll());
    }

    @Test
    public void test2(){
        User user = new User();
        user.setId(UUID.randomUUID().toString().toUpperCase().replace("-","").substring(0,16));
        user.setUsername("小李");
        user.setPassword("123456");
        int i = mapper.insertOne(user);
        sqlSession.commit();
        System.out.println("插入"+i+"条");
    }

    @After
    public void end(){
        sqlSession.close();
    }
}
