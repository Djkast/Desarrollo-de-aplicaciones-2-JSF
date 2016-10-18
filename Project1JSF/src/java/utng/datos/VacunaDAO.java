/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.datos;

import org.hibernate.HibernateException;
import utng.modelo.Vacuna;

/**
 *
 * @author Omar Uriel Rodriguez Castañeda
 */
public class VacunaDAO extends DAO<Vacuna>{

    public VacunaDAO() {
        super(new Vacuna());
    }
    
    public Vacuna getOneById(Vacuna vacuna)throws HibernateException{
        return super.getOneById(vacuna.getIdVacuna());
    }
}
