package kodlama.io.ders.dataAccess.abstracts;

import kodlama.io.ders.entities.concretes.ProgrammingLang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgrammingLangRepository extends JpaRepository<ProgrammingLang,Integer> {


}
