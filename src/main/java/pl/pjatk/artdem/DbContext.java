package pl.pjatk.artdem;

//Stwórz nową klasę która będzie zwykłym POJO (Plain Old Java Object) z kilkoma dowolnymi polami.
public class DbContext {

    private String url;
    private String username;
    private String password;

    public DbContext(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;

        //sprawdzenie czy działa:
        //System.out.println(url);
    }

    public String getConnectionString(){
        return "server=" + url +
                ";user=" + username +
                ";password=" + password;
    }

}
