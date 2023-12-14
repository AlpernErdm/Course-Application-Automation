package kodlama.io.ders.dataAccess.abstracts;

import kodlama.io.ders.entities.concretes.LangTech;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LangTechRepository  extends JpaRepository<LangTech,Integer> {
}
