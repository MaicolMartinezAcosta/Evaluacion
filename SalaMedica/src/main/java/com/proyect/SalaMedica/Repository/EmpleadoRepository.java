package com.proyect.SalaMedica.Repository;

import com.mongodb.client.result.UpdateResult;
import com.proyect.SalaMedica.Models.Cliente;
import com.proyect.SalaMedica.Models.Empleados;
import com.proyect.SalaMedica.Models.Especialidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpleadoRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Empleados save(Empleados empleados){
        return mongoTemplate.save(empleados);
    }

    public List<Empleados> finalAll(){
        return mongoTemplate.findAll(Empleados.class);
    }

    public Empleados find(String identificacion){
        return mongoTemplate.find(new Query().addCriteria(Criteria.where("identificacion").is(identificacion)), Empleados.class).get(0);
    }

    public UpdateResult addCard(String idEmplo, Especialidad especialidad){
        return mongoTemplate.updateFirst(
                new Query().addCriteria(Criteria.where("identificacion").is(idEmplo)),
                new Update().addToSet("especialidad",especialidad),
                Empleados.class
        );
    }

}
