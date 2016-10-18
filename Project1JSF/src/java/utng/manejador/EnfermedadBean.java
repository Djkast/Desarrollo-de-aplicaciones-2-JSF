/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.manejador;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.datos.EnfermedadDAO;
import utng.datos.VacunaDAO;
import utng.modelo.Enfermedad;
import utng.modelo.Vacuna;


/**
 *
 * @author Omar Uriel Rodriguez Castañeda
 */
@ManagedBean(name = "enfermedadBean")
@SessionScoped
public class EnfermedadBean implements Serializable{
    private List<Enfermedad> enfermedades;
    private Enfermedad enfermedad;
    private List<Vacuna> vacunas;
    
    public EnfermedadBean(){
        enfermedad= new Enfermedad();
        enfermedad.setVacuna(new Vacuna());
    }

    public List<Enfermedad> getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(List<Enfermedad> enfermedades) {
        this.enfermedades = enfermedades;
    }

    public Enfermedad getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(Enfermedad enfermedad) {
        this.enfermedad = enfermedad;
    }

    public List<Vacuna> getVacunas() {
        return vacunas;
    }

    public void setVacunas(List<Vacuna> vacunas) {
        this.vacunas = vacunas;
    }
    
    public String listar(){
        EnfermedadDAO dao = new EnfermedadDAO();
        try {
            enfermedades = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Enfermedades";
    }
    
    public String eliminar(){
        EnfermedadDAO dao = new EnfermedadDAO();
        try {
            dao.delete(enfermedad);
            enfermedades = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Eliminar";
    }
    
    public String iniciar(){
        enfermedad = new Enfermedad();
        enfermedad.setVacuna(new Vacuna());
        try {
            vacunas = new VacunaDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Iniciar";
    }
    
    public String guardar(){
        EnfermedadDAO dao = new EnfermedadDAO();
        try {
            if(enfermedad.getIdEnfermedad()!= 0){
                dao.update(enfermedad);
            }else{
                dao.insert(enfermedad);
            }
            enfermedades = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Guardar";
    }
    
    public String cancelar(){
        return "Cancelar";
    }
    
    public String editar(Enfermedad enfermedad){
        this.enfermedad = enfermedad;
        return "Editar";
    }
    
}
