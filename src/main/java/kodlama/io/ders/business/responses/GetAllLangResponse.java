package kodlama.io.ders.business.responses;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllLangResponse {
    private int id; //hepsini getall ile alırken id-name istenir
    private String kursAd;
}
