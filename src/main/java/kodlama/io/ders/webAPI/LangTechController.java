package kodlama.io.ders.webAPI;

import kodlama.io.ders.business.abstracts.LangTechService;
import kodlama.io.ders.business.core.utilities.mapper.ModelMapperService;
import kodlama.io.ders.business.requests.CreateRequestLangTech;
import kodlama.io.ders.business.requests.GetByIdLangTechResponse;
import kodlama.io.ders.business.requests.UpdateLangTechRequest;
import kodlama.io.ders.business.responses.GetAllLangTechResponse;
import kodlama.io.ders.dataAccess.abstracts.LangTechRepository;
import kodlama.io.ders.entities.concretes.LangTech;
import kodlama.io.ders.entities.concretes.ProgrammingLang;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/langtech")
@RequiredArgsConstructor
public class LangTechController {
    private final LangTechService langTechService;
    private final LangTechRepository langTechRepository;
    private final ModelMapperService modelMapperService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)//
    public List<GetAllLangTechResponse> getAll() { // 200 döndürmesi için
       return langTechService.getAll();
    }
    @GetMapping("/{id}")
    public GetByIdLangTechResponse GetById(@PathVariable int id, GetByIdLangTechResponse getByIdLangTechResponse){
        LangTech langTech=this.langTechRepository.findById(id).orElseThrow();
        return this.modelMapperService.forResponse().map(langTech,GetByIdLangTechResponse.class);

    }
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody CreateRequestLangTech createRequestLangTech) throws Exception {
        langTechService.add(createRequestLangTech);
    }
    @PutMapping("/update/{id}")
    public void update(@PathVariable int id, @RequestBody UpdateLangTechRequest updateLangTechRequest ,ProgrammingLang programmingLang) throws Exception {
    langTechService.update(id,updateLangTechRequest,programmingLang);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value="id") int id){
        langTechService.delete(id);
    }
}
