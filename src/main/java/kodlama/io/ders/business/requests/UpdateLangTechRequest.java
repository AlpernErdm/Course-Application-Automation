package kodlama.io.ders.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateLangTechRequest {
    private String langTechName;
    private String programmingLang;
}
