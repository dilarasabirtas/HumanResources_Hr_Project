package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//Bu benim model sınıfım

@Entity //bu sınıfın model sınıfı olduğunu belirtiyor-sınıfın malzeme listesi gibi düşün
public class Employee {
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Id // Bu anatosyan 'id' alınanın birincil anahtar olduğunu gösterir
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Bu, id, alanının otomatik olarak arttılacağını belirtir.

    private Long Id; //Çalışanın benzersiz(unique) kimliği
    private  String name;//çalışanın adı
    private String position; //Çalışanın pozisyonu

    //Getter ve Setter metotları
    //Getter, özel alanların değerini okumak için kullanılır.
    //Setter, özel alanların değerini ayarlamak için kullanılır.

}
