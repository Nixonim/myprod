import dao.UsersDao;
import dto.UsersDto;
import entity.Users;
import service.UsersService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class aTest {

    private UsersDto usersDto;
    private UsersService usersService;
    private UsersDao usersDao;
    private Users users;

    @BeforeEach
     void prepare() {
        System.out.println("Before Each " + this);
       this.usersDto = Mockito.mock(UsersDto.class);
        this.usersService = Mockito.mock(UsersService.class);
        this.usersDao = Mockito.mock(UsersDao.class);
        this.users = Mockito.mock(Users.class);

    }

    @Test
    void createTestCase() {
        Mockito.doReturn(2).when(usersService).create(usersDto);
        Integer i = usersService.create(usersDto);
        Assertions.assertEquals(2,i);

    }
//    @Test
//    void Test () {
//        assertTrue(true);
//    }
}


