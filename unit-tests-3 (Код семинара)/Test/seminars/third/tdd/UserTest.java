package seminars.third.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    User user;
    UserRepository userRepository;

    @BeforeEach
    void setup() {
        user = new User("user", "password", false);
        userRepository = new UserRepository();
    }

    @Test
    void CorrectUserData() {
        assertTrue(user.login("user", "password"));
    }

    @ParameterizedTest
    @CsvSource({
            "user, 1234",
            "root, password",
            "root, psw123"})
    void IncorrectData(String name, String pwd) {
        assertFalse(user.login(name, pwd));
    }

    @Test
    void userCreationFailed() {
        user = new User("user_0", "123psw", false);
        assertFalse(user.login("user_0", "psw123"));
    }

    /**
     * 3.7. Нужно добавить класс UserRepository (Хранилище для работы с пользователями)
     * (В метод передается пользователь, если он зарегистрирован в системе (authenticate возвращает true)
     * то он попадает в список пользователей системы.
     */
    @Test
    void userRepository() {

        user = new User("user", "psw123", false);
        userRepository.addUser(user);
        assertFalse(userRepository.findByName(user.name));
    }

    @Test
    void userRepositoryNA() {
        user = new User("user", "passwd", false);
        userRepository.addUser(user);
        assertFalse(userRepository.findByName(user.name));
    }

    @Test
    void adminHasAccessListUsers() {

        userRepository = new UserRepository();
        User NotRoot = new User("user0", "psw0", false);
        User NotRoot_1 = new User("user1", "psw1", false);

        NotRoot.login("user0", "psw0");
        NotRoot_1.login("user1", "psw1");

        userRepository.addUser(NotRoot);
        userRepository.addUser(NotRoot_1);
        userRepository.logoutAll();

        assertFalse(NotRoot.isAuthenticate);
    }
}