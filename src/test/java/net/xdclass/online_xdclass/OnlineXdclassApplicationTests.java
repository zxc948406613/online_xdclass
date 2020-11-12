package net.xdclass.online_xdclass;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.lang.Assert;
import net.xdclass.online_xdclass.model.entity.User;
import net.xdclass.online_xdclass.utils.JwtUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OnlineXdclassApplicationTests {

    @Test
    public void testGenJwt() {
        User user = new User();
        user.setId(66);
        user.setName("xdclass");
        user.setHeadImg("png");
        String token = JwtUtils.geneJwt(user);
        System.out.println(token);
        Claims claims = JwtUtils.checkJwt(token);
        System.out.println(claims.get("name"));
    }

}
