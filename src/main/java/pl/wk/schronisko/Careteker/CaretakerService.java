package pl.wk.schronisko.Careteker;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaretakerService {

    private CaretakerRepository caretakerRepository;

    public CaretakerService(CaretakerRepository caretakerRepository) {
        this.caretakerRepository = caretakerRepository;
    }

    public List<Caretaker> findAll() {
        return caretakerRepository.findAll();
    }
}
