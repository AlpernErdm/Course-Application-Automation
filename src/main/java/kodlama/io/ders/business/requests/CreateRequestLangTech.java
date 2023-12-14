package kodlama.io.ders.business.requests;

import kodlama.io.ders.entities.concretes.ProgrammingLang;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRequestLangTech {
    private String langTechName;
    private ProgrammingLang programmingLang ;
}
