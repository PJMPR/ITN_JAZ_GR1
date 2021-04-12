package pl.pjatk.JoaKoe;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.pjatk.JoaKoe.*;

@Component
public class LoginMessages {


    private String User;

    @Value("${message.witaj}")
    String helloMessage;

    @Value("${message.whoIs}")
    String whoIs;

    @Value("${message.logAs}")
    String logAs;


    public String hello(){
        return helloMessage;
    }

    public String getUserHello(){
        return whoIs;
    }

    public void setUsername(String username){
        User = username;
    }

    public String getLoggedAsMessage(){
        return logAs + " " + User;
    }

}
