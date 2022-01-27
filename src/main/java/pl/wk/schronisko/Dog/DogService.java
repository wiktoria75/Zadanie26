package pl.wk.schronisko.Dog;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogService {

    private DogRepository dogRepository;

    public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public List<Dog> findLeastHelpedDogs() {
        return dogRepository.findTop10ByOrderByHelpCount();
    }

    public void save(Dog dog) {
        dogRepository.save(dog);
    }

    public void remove(Long id) {
        dogRepository.deleteById(id);
    }

    public List<Dog> findAll() {
        return dogRepository.findAll();
    }

    public List<Dog> findByCaretakerId(Long id) {
        return dogRepository.findByCaretaker_Id(id);
    }

    public Dog findById(Long id) {
        Optional<Dog> dogOptional = dogRepository.findById(id);
        if (dogOptional.isPresent()) {
            return dogOptional.get();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public List<Dog> findBySort(String sort) {
        switch (sort) {
            case "puppy":
                return dogRepository.findByAgeBefore(2);
            case "small":
                return dogRepository.findByWeightBetweenAndAgeAfter(1, 17, 2);
            case "medium":
                return dogRepository.findByWeightBetweenAndAgeAfter(17, 34, 2);
            case "large":
                return dogRepository.findByWeightBetweenAndAgeAfter(34, 90, 2);
            default:
                return dogRepository.findAll();
        }
    }

    public List<Dog> getDogs(String sort, Long caretakerId) {
        List<Dog> dogs = null;
        if (sort != null) {
            dogs = findBySort(sort);
        } else if (caretakerId != null) {
            dogs = findByCaretakerId(caretakerId);
        } else if (dogs == null) {
            dogs = findAll();
        }
        return dogs;
    }

    public Dog getDog(Long id) {
        Dog dog;
        if (id == null) {
            dog = new Dog();
        } else {
            dog = findById(id);
        }
        return dog;
    }

    public void help(Long id) {
        Optional<Dog> dogOptional = dogRepository.findById(id);
        if (dogOptional.isPresent()) {
            Dog dog = dogOptional.get();
            dog.setHelpCount(dog.getHelpCount() + 1);
            dogRepository.save(dog);
        }
    }
}
