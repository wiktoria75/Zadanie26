package pl.wk.schronisko.Home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.wk.schronisko.Dog.DogService;

@Controller
public class HomeController {

    private DogService dogService;

    public HomeController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/")
    String home(Model model) {
        model.addAttribute("dogs", dogService.findLeastHelpedDogs());
        return "home";
    }
}
