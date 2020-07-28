package con.peter.test;

import com.google.common.collect.Lists;
import com.peter.JPAApplication;
import com.peter.dao.BisMultiRepository;
import com.peter.dao.UserRepository;
import com.peter.pojo.BisMulti;
import com.peter.pojo.User;
import com.peter.utill.ExcelReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JPAApplication.class)
public class UserRepositoryTest {

    @Autowired
    UserRepository usersDao;

    @Autowired
    BisMultiRepository bisMultiRepository;

    @Autowired
    ExcelReader excelReader;


    @Test
    public void testSave() {
        User user = new User();
        user.setUserName("ls");
        user.setUserAge(24);
        usersDao.save(user);
    }


    @Test
    public void findAllBisMulti(){


        List<BisMulti> all = bisMultiRepository.findAll();
        System.out.println(all);

    }
    @Test
    @Transactional
    public void insertBisMulti(){
        List<BisMulti> bisMultis = excelReader.readerExcel();
        List<List<BisMulti>> partition = Lists.partition(bisMultis, 1000);
        partition.parallelStream().forEach(
                bisMulti->{
                    bisMultiRepository.saveAll(bisMulti);
                }
        );
    }


}
