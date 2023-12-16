package kodlama.io.ders.business.concretes;

import kodlama.io.ders.business.abstracts.LangTechService;
import kodlama.io.ders.business.requests.CreateRequestLangTech;
import kodlama.io.ders.business.responses.GetAllLangTechResponse;
import kodlama.io.ders.dataAccess.abstracts.LangTechRepository;
import kodlama.io.ders.dataAccess.abstracts.ProgrammingLangRepository;
import kodlama.io.ders.entities.concretes.LangTech;
import kodlama.io.ders.entities.concretes.ProgrammingLang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LangTechManager implements LangTechService {
    private final ProgrammingLangRepository programmingLangRepository;
    private final LangTechRepository langTechRepository;

    @Autowired
    public LangTechManager(ProgrammingLangRepository programmingLangRepository, LangTechRepository langTechRepository) {
        this.programmingLangRepository = programmingLangRepository;
        this.langTechRepository = langTechRepository; //Db yi inject ettik
    }

    @Override
    public List<GetAllLangTechResponse> getAll() {
        List<LangTech> langTechList = langTechRepository.findAll();

        List<GetAllLangTechResponse> getAllLangTechResponses = new ArrayList<>();

        for (LangTech langTech : langTechList) {
            GetAllLangTechResponse getAllLangTechResponse = new GetAllLangTechResponse();
            getAllLangTechResponse.setId(langTech.getId());
            getAllLangTechResponse.setLangTechName(langTech.getLangTechName());
            getAllLangTechResponse.setProgrammingLang(langTech.getProgrammingLang().getKursAd());

            getAllLangTechResponses.add(getAllLangTechResponse);
        }


        return getAllLangTechResponses;

    }

    @Override
    public CreateRequestLangTech getById(int id) {

        CreateRequestLangTech responseItem = new CreateRequestLangTech();
        responseItem.setLangTechName(langTechRepository.getReferenceById(id).getLangTechName());
        return responseItem;
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
    public void update(int id, CreateRequestLangTech createLangTechRequest, ProgrammingLang programmingLang) throws Exception {
        LangTech langTech = new LangTech();
        langTech.setLangTechName(langTech.getLangTechName());
        langTech.setProgrammingLang(langTech.getProgrammingLang());
        langTech.setId(langTech.getId());
        langTechRepository.save(langTech);
    }
}
