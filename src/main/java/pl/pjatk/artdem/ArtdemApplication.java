package pl.pjatk.artdem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class ArtdemApplication implements CommandLineRunner {

	DbContext db;

	public ArtdemApplication(DbContext db) {
		this.db = db;
	}

	public static void main(String[] args) {
		SpringApplication.run(ArtdemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		System.out.println(db.getConnectionString());
	}

}
