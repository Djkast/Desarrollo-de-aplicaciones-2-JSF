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
import utng.datos.VacunaDAO;
import utng.modelo.Vacuna;

/**
 *
 * @author Omar Uriel Rodriguez Castañeda
 */
@ManagedBean
@SessionScoped
public class VacunaBean implements Serializable{
    private List<Vacuna> vacunas;
    private Vacuna vacuna;
    public VacunaBean(){}

    public List<Vacuna> getVacunas() {
        return vacunas;
    }

    public void setVacunas(List<Vacuna> vacunas) {
        this.vacunas = vacunas;
    }

    public Vacuna getVacuna() {
        return vacuna;
    }

    public void setVacuna(Vacuna vacuna) {
        this.vacuna = vacuna;
    }
    
    public String listar(){
        VacunaDAO dao = new VacunaDAO();
        try {
            vacunas = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Vacunas";
    }
    
    public String eliminar(){
        VacunaDAO dao = new VacunaDAO();
        try {
            dao.delete(vacuna);
            vacunas = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Eliminar";
    }
    
    public String iniciar(){
        vacuna = new Vacuna();
        return "Iniciar";
    }
    
    public String guardar(){
        VacunaDAO dao = new VacunaDAO();
        try {
            if(vacuna.getIdVacuna() != 0){
                dao.update(vacuna);
            }else{
                dao.insert(vacuna);
            }
            vacunas = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Guardar";
    }
    
    public String cancelar(){
        return "Cancelar";
    }
    
    public String editar(Vacuna vacuna){
        this.vacuna = vacuna;
        return "Editar";
    }
    
}
