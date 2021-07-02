package pl.pjatk.JoaKoe.repositories;


import pl.pjatk.JoaKoe.model.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressRepository extends JpaRepository<Adress, Integer> {
}
