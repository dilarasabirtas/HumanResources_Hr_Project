package service;


import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repisitory.Employeerepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService { // Bu anotasyon, bu sınıfın bir servis sınıfı olduğunu belirtir.


    @Autowired // Spring bu alanı otomatik olarak inject/enjekte eder
    private Employeerepository employeerepository;


    // CRUD'un C harfi
    public Employee hireEmployee(Employee employee) {
        // Yeni bir çalışanı veritabanına JPA'den gelen 'save' metodu ile kaydeder.
        return employeerepository.save(employee);
    }

    // CRUD' R harfi
    public List<Employee> getEmployeesAll() {
        // Tüm çalışanları veritabanından "findAll" metodu ile getirir.
        return employeerepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        // Belitilen kimlikteki çalışanı veritabanından getirir.
        return employeerepository.findById(id);
    }

    // CRUD' U harfi
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        //Belirtilen kimlikte çalışanı güncelleyen metot.
        Employee employee = employeerepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        //orElse yani if döngüsünün else kısmı gibi düşünebiliriz.
        //Aradığımız çalışan bulunamadığı durumlarda kullanıcıya böyle bi metin gösteriyoruz.
        employee.setName(employeeDetails.getName());
        employee.setPosition(employeeDetails.getPosition());
        return employeerepository.save(employee);
    }
    // CRUD'un D harfi
    public void fireEmployee(Long id) {
        //Belirtilen kimlikteki çalışanı silen metottur.
        Employee employee = employeerepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        //Silme işlemini yapan 'delete' metodunu JPA repisotory içerisinden çağırarak kullandık.
        employeerepository.delete(employee);
    }
}




