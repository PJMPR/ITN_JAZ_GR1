package pl.pjatk.JoaKoe;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class DialogService {

    private final LoginMessages message;

    public DialogService(LoginMessages message) {
        this.message = message;
    }

    public LoginMessages getLoginMessages(){
        return message;
    }
}


