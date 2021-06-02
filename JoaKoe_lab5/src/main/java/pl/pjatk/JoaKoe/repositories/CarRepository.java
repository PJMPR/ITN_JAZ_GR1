package pl.pjatk.JoaKoe.repositories;


import pl.pjatk.JoaKoe.contract.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {

    List<Car> findByModel(String name);
}