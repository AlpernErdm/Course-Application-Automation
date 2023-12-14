package kodlama.io.ders.business.abstracts;

import kodlama.io.ders.business.requests.CreateRequestLang;
import kodlama.io.ders.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.ders.business.responses.GetAllLangResponse;
import kodlama.io.ders.entities.concretes.ProgrammingLang;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProgrammingLangService {
        List<GetAllLangResponse> getall();
        void add(CreateRequestLang createRequestLang ) throws Exception;
        String update(int id,UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest);
        String delete(int id);
        void getById(int id);


}
