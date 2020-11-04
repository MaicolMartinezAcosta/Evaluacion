package com.proyect.SalaMedica.Controlles;

import com.mongodb.client.result.UpdateResult;
import com.proyect.SalaMedica.Models.Cliente;
import com.proyect.SalaMedica.Models.Empleados;
import com.proyect.SalaMedica.Models.Especialidad;
import com.proyect.SalaMedica.Repository.ClienteRepository;
import com.proyect.SalaMedica.Repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600, methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/empleado")
public class EmpleadoController {


    @Autowired
    private EmpleadoRepository empleadoRepository;

    @GetMapping("/getEmployees")
    public List<Empleados> findAll(){
        return empleadoRepository.finalAll();
    }

    @PostMapping("/saveEmployee")
    public Empleados save(@RequestBody Empleados empleados){
            return empleadoRepository.save(empleados);
    }

    @GetMapping("/getEmployee/{identificacion}")
    public Empleados find (@PathVariable("identificacion") String identificacion){
        return  empleadoRepository.find(identificacion);
    }


    @PostMapping("/addCard/{idEmplo}/Card")
    public UpdateResult addCard(@PathVariable("idEmplo") String idEmplo, @RequestBody Especialidad especialidad){
        return empleadoRepository.addCard(idEmplo,especialidad);
    }

}
