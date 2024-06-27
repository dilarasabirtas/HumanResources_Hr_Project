package Controller;

import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.EmployeeService;

import java.util.List;
import java.util.Optional;

@RestController //Bu anotasyon bu sınıfın bir kontrol sınıfı/Restfıl web servisi olduğunu belirtir.
@RequestMapping("/api/employees") //Temerl URL'ini belirtlir.
public class EmployeeController {

    @Autowired //New'lemek için kullanıyoruz.
    private EmployeeService employeeService;

    @PostMapping("/hire") //Bu anotasyon ile işaretlenen bu metot, bir çalışanı işe almak için kullanılır.
    public Employee hireEmployee(@RequestBody Employee employee){
        return employeeService.hireEmployee(employee); //RequestBody ile kodun tüm hepsini çağırdık
    }

    @GetMapping //Çalışanları getirmek için service sınıfımızdan oluşturduğumuz 'getAllEmployees'
    //metodunu çağırarak döndürüyoruz.
    public List<Employee> getAllEmployees(){
        return employeeService.getEmployeesAll();
    }
    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeByID(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

}
