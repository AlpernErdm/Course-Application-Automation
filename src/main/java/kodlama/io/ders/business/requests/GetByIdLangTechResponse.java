package kodlama.io.ders.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetByIdLangTechResponse {
    private int id;
    private String langTechName;
    private String ProgrammingLangKursAd;
}
