import org.junit.jupiter.api.Test;
import patterns.builder.User;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class BuilderTests {
    @Test
    void builderTest(){
        User user = User.builder()
                .name("Ivan")
                .surname("Ivanov")
                .gender(false)
                .age(32)
                .city("Vladivostok")
                .dateOfBirth(LocalDate.of(1994, 5, 23))
                .language(Arrays.asList("Russian", "English"))
                .build();

    assertNotNull(user);
    assertEquals("Ivan", user.getName());
    }

    @Test
    void builderNewTest() {
        User newUser = User.builder()
                .name("Pavel")
                .surname("Pavlov")
                .gender(false)
                .age(30)
                .city("Khabarovsk")
                .language(Arrays.asList("Russian", "Deutch"))
                .build();

        assertNotNull(newUser);
        assertEquals(30, newUser.getAge());
        assertEquals("Khabarovsk", newUser.getCity());
        assertNotEquals(32, newUser.getAge());
    }
}
