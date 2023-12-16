package kodlama.io.ders.webAPI;

import kodlama.io.ders.business.abstracts.ProgrammingLangService;
import kodlama.io.ders.business.requests.CreateRequestLang;
import kodlama.io.ders.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.ders.business.responses.GetAllLangResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ders")
public class LangController {
    private final ProgrammingLangService programmingLangService;

    @Autowired
    public LangController(ProgrammingLangService programmingLangService) {
        this.programmingLangService = programmingLangService;
    }

    @GetMapping("/getAll")
    public List<GetAllLangResponse> getAll() {
        return programmingLangService.getall();

    }

    @PostMapping("/add")
    public void add(@RequestBody CreateRequestLang createRequestLang) throws Exception {
        programmingLangService.add(createRequestLang);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        return programmingLangService.delete(id);
    }

    @PutMapping("/update/{id}")
    public void update( @PathVariable int id,@RequestBody UpdateProgrammingLanguageRequest  updateProgrammingLanguageRequest) {
        programmingLangService.update(id,updateProgrammingLanguageRequest);
    }

    @GetMapping("/getbyid")
    public void getById(int id) {
        programmingLangService.getById(id);
    }

}
