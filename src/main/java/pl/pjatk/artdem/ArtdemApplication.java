package pl.pjatk.artdem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class ArtdemApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ArtdemApplication.class, args);

		//-----------------LUB JEŻELI UŻYWAMY ADNOTACJI @Component------------------

/*		//Application Context:
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("pl.pjatk.artdem");
		context.refresh();

		//utwórz dwa obiekty komponentów które wcześniej utworzyliśmy.
		//MyFirstComponent first = context.getBean(MyFirstComponent.class);
		//MySecondComponent second = context.getBean(MySecondComponent.class);
		//MyThirdComponent third = context.getBean(MyThirdComponent.class);

		//Wywołaj utworzone wcześniej metody
		//first.printMe();
		//second.printMe();
		//third.printMe();

		//trzeci komponent wywołuje metody z komponentów 1 i 2:
		MyThirdComponent third = context.getBean(MyThirdComponent.class);
		third.printMe();*/


		//-----------------LUB JEŻELI UŻYWAMY  beans.xml: ------------------


		//w tym wypadku Spring wymaga istnienia kontstruktorów domyślnych! - skonfigurować w beans.xml
		//Application Context:
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		//trzeci komponent wywołuje metody z komponentów 1 i 2:
		MyThirdComponent third = context.getBean("third", MyThirdComponent.class);
		third.printMe();


	}

}
