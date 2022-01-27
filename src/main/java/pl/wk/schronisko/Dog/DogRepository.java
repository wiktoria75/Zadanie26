package pl.wk.schronisko.Dog;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DogRepository extends JpaRepository<Dog, Long> {
    List<Dog> findTop10ByOrderByHelpCount();
    List<Dog> findByAgeBefore(int age);
    List<Dog> findByWeightBetweenAndAgeAfter(int bottom, int top, int age);
    List<Dog> findByCaretaker_Id(Long id);
}
