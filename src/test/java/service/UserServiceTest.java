package service;

import com.dms.domain.model.Authority;
import com.dms.domain.model.User;
import com.dms.service.AuthorityService;
import com.dms.service.CurrentPositionService;
import com.dms.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.HashSet;
import java.util.Set;

@Transactional
public class UserServiceTest extends BaseServiceTest {

    public static boolean init = true;

    @Autowired
    private UserService userService;

    @Autowired
    private CurrentPositionService currentPositionService;

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    public void findAllUsers() {
        Assert.isTrue(!userService.getAll().isEmpty());
    }

    @Before
    public void createTempUser() {
        if (init) {
            User newUser = new User();
            newUser.setFirstName("Temp");
            newUser.setLastName("User");
            newUser.setEmail("dummy@gmail.com");
            newUser.setUsername("tempuser");
            String password = "tempuser";
            newUser.setPassword(bCryptPasswordEncoder.encode(password));
            newUser.setEnabled(true);
            newUser.setCurrentPosition(currentPositionService.getById(100));
            Set<Authority> authorities = new HashSet<>();
            authorities.add(authorityService.getById(2));
            newUser.setAuthorities(authorities);
            userService.add(newUser);
            init = false;
        }
    }

    @Test
    public void findUserByUsername() {
        String username = "admin";
        User user = userService.getByUsername(username);
        Assert.notNull(user);
        Assert.isTrue(username.equals(user.getUsername()));
    }

    @Test
    public void addUser() {
        User newUser = new User();
        newUser.setFirstName("Alan");
        newUser.setLastName("Walker");
        newUser.setEmail("awalker@gmail.com");
        newUser.setUsername("alanwalker");
        String password = "asdl123";
        newUser.setPassword(bCryptPasswordEncoder.encode(password));
        newUser.setEnabled(true);
        newUser.setCurrentPosition(currentPositionService.getById(100));
        Set<Authority> authorities = new HashSet<>();
        authorities.add(authorityService.getById(2));
        newUser.setAuthorities(authorities);
        userService.add(newUser);
        User persistedUser = userService.getByUsername("alanwalker");
        Assert.isTrue(newUser.getUsername().equals(persistedUser.getUsername()));
        Assert.isTrue(newUser.getEmail().equals(persistedUser.getEmail()));
    }

    @Test
    public void updateUser() {
        User userPersisted = userService.getByUsername("alex");
        userPersisted.setFirstName("Alex");
        userPersisted.setEmail("alex@yahoo.com");
        userService.update(userPersisted);
        User userUpdated = userService.getByUsername("alex");
        Assert.isTrue(userPersisted.getFirstName().equals(userUpdated.getFirstName()));
        Assert.isTrue(userPersisted.getEmail().equals(userUpdated.getEmail()));
    }

    @Test
    public void deleteUser() {
        User userPersisted = userService.getByUsername("alex");
        Assert.notNull(userPersisted);
        userService.delete(userPersisted.getId());
    }
}
