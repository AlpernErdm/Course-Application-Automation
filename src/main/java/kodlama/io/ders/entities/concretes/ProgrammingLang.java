package kodlama.io.ders.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name="langs") //db tablosu
@Data //getter-setter oluşturur
@AllArgsConstructor //parameter ctor
@NoArgsConstructor //noparameter ctor
@Entity //db varlığı olduğunu bildirir
public class ProgrammingLang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto-increment
    @Column(name = "id")
    private int id;

    @Column(name = "kursAd")
    private String kursAd;

    @OneToMany(mappedBy = "programmingLang",cascade = CascadeType.ALL)
    private List<LangTech> langTeches;



}
