package pl.pjatk.JoaKoe.repositories;

import pl.pjatk.JoaKoe.model.Accident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccidentRepository extends JpaRepository<Accident, Integer> {
}