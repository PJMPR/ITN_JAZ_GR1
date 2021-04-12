package pl.pjatk.JoaKoe;

import org.springframework.test.context.ActiveProfiles;
import pl.pjatk.JoaKoe.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@ActiveProfiles(profiles = "pl")
class JoaKoeApplicationTestsPL {
    @Autowired
    DialogService dialog;

    @Test
    void contextLoads() {
        LoginMessages messages = dialog.getLoginMessages();
        String welcome = messages.hello();
        assertThat(welcome, equalTo("Dzień dobry"));
        String provideUsername = messages.getUserHello();
        assertThat(provideUsername, equalTo("podaj nazwe uzytkownika:"));
        messages.setUsername("admin");
        String loggedAsMessage = messages.getLoggedAsMessage();
        assertThat(loggedAsMessage, equalTo("Zalogowany jako admin"));

        messages.setUsername("Pawel");
        loggedAsMessage = messages.getLoggedAsMessage();
        assertThat(loggedAsMessage, equalTo("Zalogowany jako pawel"));
    }
}
@SpringBootTest
@ActiveProfiles(profiles = "eng")
class JoaKoeApplicationTestsENG {

	@Autowired
	DialogService dialog;

	@Test
	void contextLoads() {

		LoginMessages messages = dialog.getLoginMessages();

		String welcome = messages.hello();
		assertThat(welcome, equalTo("Welcome"));
		String provideUsername = messages.getUserHello();

		assertThat(provideUsername, equalTo("Give login:"));
		messages.setUsername("admin");
		String loggedAsMessage = messages.getLoggedAsMessage();
		assertThat(loggedAsMessage, equalTo("Logged as admin"));

		messages.setUsername("Pawel");

		loggedAsMessage = messages.getLoggedAsMessage();

		assertThat(loggedAsMessage, equalTo("Logged as Pawel"));
	}
}
