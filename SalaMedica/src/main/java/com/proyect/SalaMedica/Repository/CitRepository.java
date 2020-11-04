package com.proyect.SalaMedica.Repository;

import com.proyect.SalaMedica.Models.Cita;
import com.proyect.SalaMedica.Models.Empleados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CitRepository {


    @Autowired
    private MongoTemplate mongoTemplate;

    public Cita save(Cita cita){
        return mongoTemplate.save(cita);
    }

    public List<Cita> finalAll(){
        return mongoTemplate.findAll(Cita.class);
    }

    public Cita find(String identificacion){
        return mongoTemplate.find(new Query().addCriteria(Criteria.where("identificacionCliente").is(identificacion)), Cita.class).get(0);
    }

}
