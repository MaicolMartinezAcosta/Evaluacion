package com.proyect.SalaMedica.Controlles;

import com.mongodb.client.result.UpdateResult;
import com.proyect.SalaMedica.Models.Cliente;
import com.proyect.SalaMedica.Models.Especialidad;
import com.proyect.SalaMedica.Models.HistorialClinico;
import com.proyect.SalaMedica.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600, methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/getClients")
    public List<Cliente> findAll(){
        return clienteRepository.finalAll();
    }

    @PostMapping("/saveClient")
    public Cliente save(@RequestBody Cliente cliente){
            return clienteRepository.save(cliente);
    }

    @GetMapping("/getClient/{identificacion}")
    public Cliente find (@PathVariable("identificacion") String identificacion){
        return  clienteRepository.find(identificacion);
    }

    @PostMapping("/addHisto/{idCli}/histo")
    public UpdateResult addHistoryAppointment(@PathVariable("idCli") String idCli, @RequestBody HistorialClinico histo){
        return clienteRepository.addHistoryAppointment(idCli,histo);
    }

}
