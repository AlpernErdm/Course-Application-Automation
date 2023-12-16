package kodlama.io.ders.webAPI;

import kodlama.io.ders.business.abstracts.LangTechService;
import kodlama.io.ders.business.requests.CreateRequestLangTech;
import kodlama.io.ders.business.responses.GetAllLangTechResponse;
import kodlama.io.ders.entities.concretes.ProgrammingLang;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/langtech")
@RequiredArgsConstructor
public class LangTechController {
    private final LangTechService langTechService;

    @GetMapping("/getall")
    public List<GetAllLangTechResponse> getAll() {
        return langTechService.getAll();
    }
    @PostMapping("/add")
    public void add(@RequestBody CreateRequestLangTech createRequestLangTech) throws Exception {
        langTechService.add(createRequestLangTech);
    }
    @PutMapping("/update/{id}")
    public void update(@PathVariable int id, @RequestBody CreateRequestLangTech  createRequestLangTech,ProgrammingLang programmingLang) throws Exception {
    langTechService.update(id,createRequestLangTech,programmingLang);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value="id") int id){
        langTechService.delete(id);
    }
}
