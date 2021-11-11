package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Kisi;

public interface KisiRepository    extends JpaRepository<Kisi, Integer>    {
	//spring in kendi içinde olan bir interface den extends
	//kişiyi saklıyacak bir repository, primary key (id) integer old için içine birde Integer yazdık
//bu extends sayesinde ben JPA daki hazır metodları kullanabileceğim

}
