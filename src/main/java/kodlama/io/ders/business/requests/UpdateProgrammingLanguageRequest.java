package kodlama.io.ders.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateProgrammingLanguageRequest {
    private int id;
    private String kursAd;
}
