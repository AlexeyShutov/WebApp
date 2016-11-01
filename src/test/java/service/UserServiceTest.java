package service;

import com.dms.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class UserServiceTest extends BaseServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void findAllUsers() {
        Assert.isTrue(!userService.getAll().isEmpty());
    }
}
