/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Omar Uriel Rodriguez Castañeda
 */
@Entity 
@Table(name = "enfermedad")
public class Enfermedad implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_enfermedad")
    private Long idEnfermedad;
    @Column(name = "nombre_enfermedad", length = 50)
    private String nombreEnfermedad;
    @Column(name = "sintomas", length = 100)
    private String sintomas;
    @Column(name = "otros", length = 200)
    private String otros;
    @ManyToOne//(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_vacuna")
    private Vacuna vacuna;

    public Enfermedad(Long idEnfermedad, String nombreEnfermedad, String sintomas, String otros, Vacuna vacuna) {
        super();
        this.idEnfermedad = idEnfermedad;
        this.nombreEnfermedad = nombreEnfermedad;
        this.sintomas = sintomas;
        this.otros = otros;
        this.vacuna = vacuna;
    }
    
    
    
    public Enfermedad(){
        this.idEnfermedad = 0L;
    }

    public Long getIdEnfermedad() {
        return idEnfermedad;
    }

    public void setIdEnfermedad(Long idEnfermedad) {
        this.idEnfermedad = idEnfermedad;
    }

    public String getNombreEnfermedad() {
        return nombreEnfermedad;
    }

    public void setNombreEnfermedad(String nombreEnfermedad) {
        this.nombreEnfermedad = nombreEnfermedad;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getOtros() {
        return otros;
    }

    public void setOtros(String otros) {
        this.otros = otros;
    }

    public Vacuna getVacuna() {
        return vacuna;
    }

    public void setVacuna(Vacuna vacuna) {
        this.vacuna = vacuna;
    }
    
    
}
