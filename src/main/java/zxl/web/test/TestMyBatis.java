package zxl.web.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import zxl.web.domain.Student;
import zxl.web.mapper.StudentMapper;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestMyBatis {
    @Autowired
    StudentMapper mapper;

    @Test
    public void testMyBatis()throws Exception{
        List<Student>lists=mapper.queryAll();
        for(Student student:lists){
            System.out.println(student);
        }
    }

}
