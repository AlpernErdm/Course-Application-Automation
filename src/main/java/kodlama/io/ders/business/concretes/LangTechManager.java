package kodlama.io.ders.business.concretes;

import kodlama.io.ders.business.abstracts.LangTechService;
import kodlama.io.ders.business.core.utilities.mapper.ModelMapperService;
import kodlama.io.ders.business.requests.CreateRequestLangTech;
import kodlama.io.ders.business.requests.GetByIdLangTechResponse;
import kodlama.io.ders.business.requests.UpdateLangTechRequest;
import kodlama.io.ders.business.responses.GetAllLangTechResponse;
import kodlama.io.ders.dataAccess.abstracts.LangTechRepository;
import kodlama.io.ders.dataAccess.abstracts.ProgrammingLangRepository;
import kodlama.io.ders.entities.concretes.LangTech;
import kodlama.io.ders.entities.concretes.ProgrammingLang;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LangTechManager implements LangTechService {
    private final ProgrammingLangRepository programmingLangRepository;
    private final LangTechRepository langTechRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public List<GetAllLangTechResponse> getAll() {
        List<LangTech> langTechList = langTechRepository.findAll();

        return langTechList.stream()
                .map(langTech -> modelMapperService.forResponse()
                        .map(langTech, GetAllLangTechResponse.class)).toList();

    }

    @Override
    public GetByIdLangTechResponse getById(int id) {

       LangTech langTech=this.langTechRepository.findById(id).orElseThrow();
       return this.modelMapperService.forResponse().map(langTech, GetByIdLangTechResponse.class);
    }

    @Override
    public void add(CreateRequestLangTech createLangTechRequest) throws Exception {
        ProgrammingLang programmingLang = programmingLangRepository.findById(createLangTechRequest.getProgrammingLangId()).get();

        LangTech langTech = new LangTech();
        langTech.setLangTechName(createLangTechRequest.getLangTechName());
        langTech.setProgrammingLang(programmingLang);
        langTechRepository.save(langTech);
    }

    @Override
    public void delete(int id) {
        langTechRepository.deleteById(id);
    }

    @Override
    public void update(@PathVariable int id, UpdateLangTechRequest updateLangTechRequest, ProgrammingLang programmingLang) throws Exception {
       LangTech langTech=this.langTechRepository.findById(id).orElseThrow();
       langTech.setLangTechName(updateLangTechRequest.getLangTechName());
       this.langTechRepository.save(langTech);
    }
}
