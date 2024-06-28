package com.example.HR.controller;

import com.example.HR.model.Employee;
import com.example.HR.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Bu anotasyon, bu sınıfın bir control sınıfı/RESTful web servisi olduğunu belirtir.
@RequestMapping("/api/employees") // Temel URL'ini belirtir.
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/hire") // Bu anotasyon ile işaretlenen bu metot, bir çalışanı işe almak için kullanılır.
    @Operation (summary = "Yeni personel kaydı yapar.")
    public Employee hireEmployee(@RequestBody Employee employee) {
        return employeeService.hireEmployee(employee);
    }

    @GetMapping /* Çalışanları getirmek için service sınfımızdan oluşturduğumuz "getAllEmployees"
     metotu çağırarak döndürüyoruz.*/
    @Operation (summary = "Belirli bir personeli ID numarasına göre getirir.")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        return  employeeService.getEmployeeById(id);
    }


    @PutMapping("/{id}") /* Belitilen kimlikteki çalışan bilgilerini bu metot
    ile update/güncelliyoruz.*/
    @Operation (summary = "Personelin bilgilerini günceller.")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
        return employeeService.updateEmployee(id, employeeDetails);
    }

    @DeleteMapping("/fire/{id}")
    @Operation (summary = "Personel kaydını siler..")
    public void fireEmployees(@PathVariable Long id) {
        employeeService.fireEmployee(id);
    }
}


// Config ---> Configuration --> ayarlamak