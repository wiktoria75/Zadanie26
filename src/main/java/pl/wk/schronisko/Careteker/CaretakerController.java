package pl.wk.schronisko.Careteker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.wk.schronisko.Dog.DogService;

@Controller
public class CaretakerController {

    private CaretakerService caretakerService;

    public CaretakerController(CaretakerService caretakerService) {
        this.caretakerService = caretakerService;
    }

    @GetMapping("/opiekunowie")
    String caretakers(Model model) {
        model.addAttribute("caretakers", caretakerService.findAll());
        return "caretakers";
    }
}
