package kodlama.io.ders.business.concretes;

import kodlama.io.ders.business.abstracts.LangTechService;
import kodlama.io.ders.business.requests.CreateRequestLang;
import kodlama.io.ders.business.requests.CreateRequestLangTech;
import kodlama.io.ders.business.responses.GetAllLangResponse;
import kodlama.io.ders.business.responses.GetAllLangTechResponse;
import kodlama.io.ders.dataAccess.abstracts.LangTechRepository;
import kodlama.io.ders.entities.concretes.LangTech;
import kodlama.io.ders.entities.concretes.ProgrammingLang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class LangTechManager implements LangTechService {
    private ProgrammingLang programmingLang;
    private final LangTechRepository langTechRepository;
@Autowired
    public LangTechManager(LangTechRepository langTechRepository) {
        this.langTechRepository = langTechRepository;
    }

    @Override
    public List<GetAllLangTechResponse> getAll() {
        List<LangTech> langTechList =langTechRepository.findAll();

        List<GetAllLangTechResponse> getAllLangTechResponses = new ArrayList<>();

        for (LangTech langTech: langTechList){
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
        return null;
    }

    @Override
    public void add(CreateRequestLangTech createLangTechRequest, ProgrammingLang programmingLang) throws Exception {
//        List<CreateRequestLangTech>createRequestLangTechList=new ArrayList<>();
//        for (LangTech langTech:langTechList) {
//            CreateRequestLangTech responseItem=new CreateRequestLangTech();
//            responseItem.setLangTechName(langTech.getLangTechName());
//            responseItem.setProgrammingLang(langTech.getProgrammingLang());
//            createRequestLangTechList.add(responseItem);
//        }
    }

    @Override
    public void delete(int id) {
    langTechRepository.deleteById(id);



    }

    @Override
    public void update(int id, CreateRequestLangTech createLangTechRequest, ProgrammingLang programmingLang) throws Exception {
    LangTech langTech=new LangTech();
    langTech.setLangTechName(langTech.getLangTechName());
    langTech.setProgrammingLang(langTech.getProgrammingLang());
    langTech.setId(langTech.getId());
    langTechRepository.save(langTech);
    }
}
