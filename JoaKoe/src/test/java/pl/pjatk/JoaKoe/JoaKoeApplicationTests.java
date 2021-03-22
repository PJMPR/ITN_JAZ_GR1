package pl.pjatk.JoaKoe;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;



@SpringBootTest
class JoaKoeApplicationTests extends Mockito {

	@Test
	void annotationTest() {
		
		Person person = new Person();
		person.setName("Jan");
		Person person1 = new Person();
		person1.setName("Pawel");
		Assert.isTrue(person.getName() == "Jan");
		List<Person> p = new ArrayList<Person>();
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("pl.pjatk.JoaKoe");
		context.refresh();
		PersonDb db = context.getBean(PersonDb.class);
		Assert.isInstanceOf(Person[].class, db.getPersonArray());

		PersonRepository repository = context.getBean(PersonRepository.class);

		repository.save(person);
		repository.save(person1);
		repository.getDb();

		Person[] list = db.getPersonArray();
		Assert.isTrue(list.length==1000);
		Assert.isTrue(list[0]==person);


	}
	
	@Test
	void beanCofigTest(){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");;
		Person person = context.getBean("person", Person.class);
		person.setName("Jan");
		Assert.isTrue(person.getName() == "Jan");


	PersonDb db = context.getBean(PersonDb.class);
		Assert.isInstanceOf(Person[].class, db.getPersonArray());

		PersonRepository repository = context.getBean(PersonRepository.class);

		repository.save(person);
		repository.getDb();
		Person[] list = db.getPersonArray();
		Assert.isTrue(list.length==1000);
		Assert.isTrue(list[0]==person);

	}
}
