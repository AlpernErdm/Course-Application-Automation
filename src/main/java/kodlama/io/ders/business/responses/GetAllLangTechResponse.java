package kodlama.io.ders.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllLangTechResponse {
    private int id;
    private String langTechName;
    private String programmingLang;
}
