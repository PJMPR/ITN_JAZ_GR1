package pl.pjatk.JoaKoe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Person {
    
	private String name;

    public Person() {}
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void PrzedstawSie() {
        System.out.println("Nazywam się: " + getName());
    }

}
