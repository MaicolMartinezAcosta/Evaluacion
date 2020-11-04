package com.proyect.SalaMedica;

import com.proyect.SalaMedica.Controlles.CitaController;
import com.proyect.SalaMedica.Controlles.ClienteController;
import com.proyect.SalaMedica.Controlles.EmpleadoController;
import com.proyect.SalaMedica.Models.*;
import com.proyect.SalaMedica.Repository.CitRepository;
import com.proyect.SalaMedica.Repository.ClienteRepository;
import com.proyect.SalaMedica.Repository.EmpleadoRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BusinessUnitTest {

    @Mock
    private ClienteRepository clienteRepository;
    @Mock
    private EmpleadoRepository empleadoRepository;
    @Mock
    private CitRepository citRepository;


    @InjectMocks
    private ClienteController clienteController;
    @InjectMocks
    private EmpleadoController empleadoController;
    @InjectMocks
    private CitaController citaController;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void  saveClient () {

        String identificacion = "1123123";
        String name = "maicol";
        String telefono = "12345";

        Cliente client = new Cliente();

        client.setIdentificacion(identificacion);
        client.setNombre(name);
        client.setTelefono(telefono);

        clienteController.save(client);

        verify(clienteRepository, times(1))
                .save(client);
    }

    @Test
    public void  SearchClient () {

        String identificacion = "1193524499";

        clienteController.find(identificacion);

        verify(clienteRepository, times(1))
                .find(identificacion);
    }

    @Test
    public void  SearchAllClients () {
        clienteController.findAll();
        verify(clienteRepository, times(1))
                .finalAll();
    }


    @Test
    public void  saveEmployee () {

        String identificacion = "1123123";
        String name = "maicol";
        String telefono = "12345";
        String cargo = "enfermero";

        Empleados empleado = new Empleados();

        empleado.setIdentificacion(identificacion);
        empleado.setNombre(name);
        empleado.setTelefono(telefono);
        empleado.setCargo(cargo);
        empleadoController.save(empleado);
        verify(empleadoRepository, times(1))
                .save(empleado);
    }

    @Test
    public void  SaveCardEmployee () {
        String idemple = "1123123";
        String idTarje = "123123";
        String especialidad = "Oftalmología";

        Especialidad espec = new Especialidad();

        espec.setIdTarjeta(idTarje);
        espec.setEspecialidad(especialidad);

        empleadoController.addCard(idemple,espec);
        verify(empleadoRepository, times(1))
                .addCard(idemple,espec);
    }


    @Test
    public void  SearchEmployee () {

        String identificacion = "1193524499";

        empleadoController.find(identificacion);

        verify(empleadoRepository, times(1))
                .find(identificacion);
    }

    @Test
    public void  SearchAllEmployees () {
        empleadoController.findAll();
        verify(empleadoRepository, times(1))
                .finalAll();
    }


    @Test
    public void  saveAppointment () {

         String identificacionCliente = "1193524499";
         String identificacionEmpleado = "52735928";
         String horaIni = "7:30 AM";
         String tipoCita = "General";
         String descriptionCit = "Cita general despues de 1 año";

        Cita cita = new Cita();
        cita.setIdentificacionCliente(identificacionCliente);
        cita.setIdentificacionEmpleado(identificacionEmpleado);
        cita.setHoraIni(horaIni);
        cita.setTipoCita(tipoCita);
        cita.setDescripcionCita(descriptionCit);

        citaController.save(cita);
        verify(citRepository, times(1))
                .save(cita);
    }

    @Test
    public void  SearchAppointment () {
        String identificacion = "1193524499";
        citaController.find(identificacion);
        verify(citRepository, times(1))
                .find(identificacion);
    }

    @Test
    public void  SearchAllAppointments () {
        citaController.findAll();
        verify(citRepository, times(1))
                .finalAll();
    }



    @Test
    public void  addHistoryMedicClict () {

        String identificacionCliente = "1193524499";
        String identificacionEmpleado = "52735928";
        String horaIni = "7:30 AM";
        String tipoCita = "General";
        String descriptionCit = "Cita general despues de 1 año";

        HistorialClinico historialClinico = new HistorialClinico();
        historialClinico.setIdentificacionCliente(identificacionCliente);
        historialClinico.setIdentificacionEmpleado(identificacionEmpleado);
        historialClinico.setHoraIni(horaIni);
        historialClinico.setTipoCita(tipoCita);
        historialClinico.setDescripcionCita(descriptionCit);

        clienteController.addHistoryAppointment(identificacionCliente,historialClinico);
        verify(clienteRepository, times(1))
                .addHistoryAppointment(identificacionCliente,historialClinico);
    }

}
