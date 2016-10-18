/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.datos;

import org.hibernate.HibernateException;
import utng.modelo.Enfermedad;

/**
 *
 * @author Omar Uriel Rodriguez Castañeda
 */
public class EnfermedadDAO extends DAO<Enfermedad>{
    
    public EnfermedadDAO() {
        super(new Enfermedad());
    }
    
    public Enfermedad getOneById(Enfermedad enfermedad)throws HibernateException{
        return super.getOneById(enfermedad.getIdEnfermedad());
    }
    
}
