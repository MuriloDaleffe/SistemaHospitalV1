package br.com.hospitalif.DAO2;

import br.com.hospitalif.model.Gerente;

import javax.persistence.EntityManager;

public class GerenteDAO extends GenericDAO<Long, Gerente> {

    public GerenteDAO(EntityManager em) {
        super(em);
    }

}
