package service.security;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptEncoderTest {

    @Test
    public void encodePassword() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode("alex");
        System.out.println(encodedPassword);
        encodedPassword = passwordEncoder.encode("admin");
        System.out.println(encodedPassword);
    }
}
