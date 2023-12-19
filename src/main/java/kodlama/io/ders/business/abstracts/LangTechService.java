package kodlama.io.ders.business.abstracts;

import kodlama.io.ders.business.requests.CreateRequestLangTech;
import kodlama.io.ders.business.requests.GetByIdLangTechResponse;
import kodlama.io.ders.business.requests.UpdateLangTechRequest;
import kodlama.io.ders.business.responses.GetAllLangTechResponse;
import kodlama.io.ders.entities.concretes.ProgrammingLang;

import java.util.List;

public interface LangTechService {
    List<GetAllLangTechResponse> getAll();
    GetByIdLangTechResponse getById(int id);
    void add(CreateRequestLangTech createLangTechRequest) throws Exception;
    void delete(int id);
    void update(int id,UpdateLangTechRequest updateLangTechRequest, ProgrammingLang programmingLang) throws Exception;
}
