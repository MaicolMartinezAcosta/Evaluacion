package com.proyect.SalaMedica.Controlles;

import com.mongodb.client.result.UpdateResult;
import com.proyect.SalaMedica.Models.Cita;
import com.proyect.SalaMedica.Models.HistorialClinico;
import com.proyect.SalaMedica.Repository.CitRepository;
import com.proyect.SalaMedica.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600, methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/cita")
public class CitaController {

    @Autowired
    private CitRepository citRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/getAppointment")
    public List<Cita> findAll(){
        return citRepository.finalAll();
    }

    @PostMapping("/saveAppointment")
    public Cita save(@RequestBody Cita cita){
        return citRepository.save(cita);
    }

    @GetMapping("/getAppointment/{identificacionCliente}")
    public Cita find (@PathVariable("identificacionCliente") String identificacionCliente){
        return  citRepository.find(identificacionCliente);
    }

}
