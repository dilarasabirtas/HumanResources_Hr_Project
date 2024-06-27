package repisitory;


//Depo sınıfı olduğu için repository  ekliyoruz başına, veritabanı ile iletişim buradan sağlanıyor
// extends ile Jpa ile intelij de bulunan kütüphaneye erişim sağlayıp arka planda kodları çalıştırabiliyoruz


import model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Bu anatasyon, bu sınıfın bir Spring veritabanı deposu olduğunu belirtir.
public interface Employeerepository extends JpaRepository<Employee,Long> {

}

//JPA--> CRUD(create, read, update, delete) işlemleri için gerekli metotları sağlar.