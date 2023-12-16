package kodlama.io.ders.business.concretes;

import kodlama.io.ders.business.abstracts.ProgrammingLangService;
import kodlama.io.ders.business.requests.CreateRequestLang;
import kodlama.io.ders.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.ders.business.responses.GetAllLangResponse;
import kodlama.io.ders.dataAccess.abstracts.ProgrammingLangRepository;
import kodlama.io.ders.entities.concretes.ProgrammingLang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProgrammingLangManager implements ProgrammingLangService {
    private final ProgrammingLangRepository programmingLangRepository;

    @Autowired
    public ProgrammingLangManager(ProgrammingLangRepository programmingLangRepository) {
        this.programmingLangRepository = programmingLangRepository;
    }

    @Override
    public List<GetAllLangResponse> getall() {
        List<ProgrammingLang> programmingLangs = programmingLangRepository.findAll(); //veritabanından brand'leri çekiyoruz
        List<GetAllLangResponse> langResponses = new ArrayList<GetAllLangResponse>(); //boş bir dizi oluşturuyoruz
        for (ProgrammingLang programmingLang : programmingLangs) { //Entity olan brandi tek tek dolaşarak brands üzerinde döndürüyoruz
            GetAllLangResponse responseItem = new GetAllLangResponse();//yeni bir nesne oluşturduk ve bunun üzerinde işlem yapıcaz
            responseItem.setId(programmingLang.getId());//Brand entityden dönen id değerlerini responseitem in ıcındeki ıd nın içine atıyoruz
            responseItem.setKursAd(programmingLang.getKursAd());//Brand entityden dönen name değerlerini responseitem in ıcındeki ıd nın içine atıyoruz
            langResponses.add(responseItem);//en sonda responseItem içine yeni bir nesne ekleniyor
        }
        return langResponses;//oluşturduğumuz listenin içine ekleniyor
    }

    @Override
    public void add(CreateRequestLang createRequestLang) throws Exception {
        ProgrammingLang programmingLanguage = new ProgrammingLang();//yeni bir dil objesi oluiturdum
        programmingLanguage.setKursAd(createRequestLang.getKursAd());//yeni creatlediğim nesnenin adını set ettim
        this.programmingLangRepository.save(programmingLanguage);//bu şekilde repoya kaydettim
    }

    @Override
    public String delete(int id) {
        this.programmingLangRepository.deleteById(id);

        return "Başarıyla silindi";
    }

    @Override
    public String update(int id, UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {

        Optional<ProgrammingLang> programmingLang = this.programmingLangRepository.findById(id); //null check için kullanılır

        if (programmingLang.isPresent()) { //isPresent içi null mu kontrol ediyor
            ProgrammingLang existingLang = programmingLang.get(); //İd sini belirttiğimiz objeyi alıyoruz

            // Güncelleme işlemleri
            existingLang.setKursAd(updateProgrammingLanguageRequest.getKursAd());
            // Güncellenmiş veriyi kaydetme
            this.programmingLangRepository.save(existingLang);

            return "Başarıyla güncellendi";
        } else {
            return "Güncellenecek dil bulunamadı";
        }
    }



    @Override
        public void getById(int id) {
            ProgrammingLang programmingLanguage = programmingLangRepository.findById(id).orElse(null);

        }
    }

