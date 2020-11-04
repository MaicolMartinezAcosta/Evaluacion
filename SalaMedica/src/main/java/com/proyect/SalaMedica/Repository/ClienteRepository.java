package com.proyect.SalaMedica.Repository;

import com.mongodb.client.result.UpdateResult;
import com.proyect.SalaMedica.Models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Cliente save(Cliente cliente){
        return mongoTemplate.save(cliente);
    }

    public List<Cliente> finalAll(){
        return mongoTemplate.findAll(Cliente.class);
    }

    public Cliente find(String identificacion){
        return mongoTemplate.find(new Query().addCriteria(Criteria.where("identificacion").is(identificacion)), Cliente.class).get(0);
    }

    public UpdateResult addHistoryAppointment(String idCli, HistorialClinico historialClinico){
        return mongoTemplate.updateFirst(
                new Query().addCriteria(Criteria.where("identificacion").is(idCli)),
                new Update().addToSet("historialClinico",historialClinico),
                Cliente.class
        );
    }

}
