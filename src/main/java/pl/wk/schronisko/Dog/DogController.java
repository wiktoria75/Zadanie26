package pl.wk.schronisko.Dog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.wk.schronisko.Careteker.CaretakerService;

@Controller
public class DogController {

    private DogService dogService;
    private CaretakerService caretakerService;

    public DogController(DogService dogService, CaretakerService caretakerService) {
        this.dogService = dogService;
        this.caretakerService = caretakerService;
    }

    @GetMapping("/lista")
    String list(Model model, @RequestParam(required = false) String sort, @RequestParam(required = false) Long caretakerId) {
        model.addAttribute("dogs", dogService.getDogs(sort, caretakerId));
        return "list";
    }

    @GetMapping("/pomagaj")
    String help(@RequestParam Long id) {
        dogService.help(id);
        return "redirect:/";
    }

    @GetMapping("/pies")
    String dog(Model model, @RequestParam Long id) {
        model.addAttribute("dog", dogService.findById(id));
        return "dog";
    }

    @GetMapping("/edytuj")
    String edit(Model model, @RequestParam(required = false) Long id) {
        model.addAttribute("dog", dogService.getDog(id));
        model.addAttribute("caretakers", caretakerService.findAll());
        model.addAttribute("sexes", Sex.values());
        return "form";
    }

    @PostMapping("/zapisz")
    String save(Dog dog) {
        dogService.save(dog);
        return "redirect:/lista";
    }

    @GetMapping("/usun")
    String save(@RequestParam Long id) {
        dogService.remove(id);
        return "redirect:/lista";
    }
}
