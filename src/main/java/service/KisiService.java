package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import model.Kisi;

import repository.KisiRepository;

@Service
public class KisiService {
	
	public static KisiRepository kisiRepository;
	
	// Dependency Injection bunu yapmayıp klasik yöntemle çağırsaydık birbirine sıkı sıkı bağlı olacaktı, birinini
	//ömrü ötekine bağlı oluyor, kolay ayrılmıyor
	@Autowired// Spring buna ihtiyaç duyduğunda (çalıştırıldığında, runtime), oluşturuyor, normalde boşuna çalışmasın diye alttaki
	public KisiService(KisiRepository kisiRepository) {
		KisiService.kisiRepository = kisiRepository;
	}
	
	
	public List<Kisi> tumKisileriGetir(){
		return kisiRepository.findAll();
	}
	
	// Veritabanina Kisi ekleyen servis metodu
		public Kisi kisiEkle(Kisi kisi) {
			return kisiRepository.save(kisi);//repos. sayesinde database e depoluyor
		}
		
		
	public String idIleKisiSil(Integer id)	{
		
		if(kisiRepository.findById(id)==null) {
		throw new EmptyResultDataAccessException(id);
			
		}
		
		kisiRepository.deleteById(id);
		
		return id +" id'li kişi silindi";
		
	}
	
		
	//PUT 
//	PUT , kaynağın var olup olmadığını kontrol etmek içindir, ardından güncellemek ,
//	aksi takdirde yeni kaynak oluşturmak içindir. PATCH her zaman sadece bir kaynağı güncellemek içindir.
//  PUT için, id belirterek yazarız, bu id li kişi yoksa yenisini oluşturur
//	  "id":77,
//    "ad": "xxx",
//    "soyad": "ver",
//    "yas": 66}
		
		public Kisi kisiGuncelle (Kisi guncelKisi) {
			
			return kisiRepository.save(guncelKisi);
		}
		
	//PATCH
		

		public Kisi idIleKisiGüncelle(Integer id, Kisi updateKisi) {
			
	Kisi eskiKisi=kisiRepository.findById(id).orElseThrow(()->new IllegalStateException(id+"li kisi bulunamadı"));
			
	if(updateKisi.getAd()!=null) {
		eskiKisi.setAd(updateKisi.getAd());
	}
	
	if(updateKisi.getSoyad()!=null) {
		eskiKisi.setSoyad(updateKisi.getSoyad());
	}
	if(updateKisi.getYas()!=0) {
		eskiKisi.setYas(updateKisi.getYas());
	}
	return kisiRepository.save(eskiKisi);
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
