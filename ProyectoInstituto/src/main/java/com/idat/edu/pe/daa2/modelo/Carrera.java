package com.idat.edu.pe.daa2.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "carrera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carrera.findAll", query = "SELECT ca FROM Carrera ca")
    , @NamedQuery(name = "Carrera.findByIdCarrera", query = "SELECT ca FROM Carrera ca WHERE ca.idCarrera = :idCarrera")
    , @NamedQuery(name = "Carrera.findByNombreCarrera", query = "SELECT ca FROM Carrera ca WHERE ca.nombreCarrera = :nombreCarrera")
    , @NamedQuery(name = "Carrera.findByTotalCreditos", query = "SELECT ca FROM Carrera ca WHERE ca.totalCreditos = :totalCreditos")})


public class Carrera implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCarrera")
    private Integer idCarrera;
    @Basic(optional = false)
    @Column(name = "nombreCarrera")
    private String nombreCarrera;
    @Basic(optional = false)
    @Column(name = "totalCreditos")
    private String totalCreditos;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carrera")
    @JsonBackReference(value="carrera_cur")
    private List<Curso> cursoList;
    @JoinColumn(name = "sede", referencedColumnName = "idSede")
    @ManyToOne(optional = false)
    private Sede sede;

    public Carrera() {
    }

    public Carrera(Integer idCarrera) {
        this.idCarrera = idCarrera;
    }

	public Carrera(Integer idCarrera, String nombreCarrera, String totalCreditos) {
		super();
		this.idCarrera = idCarrera;
		this.nombreCarrera = nombreCarrera;
		this.totalCreditos = totalCreditos;
	}

	public Integer getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(Integer idCarrera) {
		this.idCarrera = idCarrera;
	}

	public String getNombreCarrera() {
		return nombreCarrera;
	}

	public void setNombreCarrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
	}

	public String getTotalCreditos() {
		return totalCreditos;
	}

	public void setTotalCreditos(String totalCreditos) {
		this.totalCreditos = totalCreditos;
	}

	@XmlTransient
	public List<Curso> getCursoList() {
		return cursoList;
	}

	public void setCursoList(List<Curso> cursoList) {
		this.cursoList = cursoList;
	}

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCarrera != null ? idCarrera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carrera)) {
            return false;
        }
        Carrera other = (Carrera) object;
        if ((this.idCarrera == null && other.idCarrera != null) || (this.idCarrera != null && !this.idCarrera.equals(other.idCarrera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "idat.edu.pe.daa2.modelo.Carrera[ idCarrera=" + idCarrera + " ]";
    }
    
	
}
