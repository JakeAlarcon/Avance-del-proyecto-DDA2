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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "profesion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesion.findAll", query = "SELECT p FROM Profesion p")
    , @NamedQuery(name = "Profesion.findByIdProfesion", query = "SELECT p FROM Profesion p WHERE p.idProfesion = :idProfesion")
    , @NamedQuery(name = "Profesion.findByNombreProfesion", query = "SELECT p FROM Profesion p WHERE p.nombreProfesion = :nombreProfesion")
    , @NamedQuery(name = "Profesion.findByCentroEstudio", query = "SELECT p FROM Profesion p WHERE p.centroEstudio = :centroEstudio")})

public class Profesion implements Serializable{

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProfesion")
    private Integer idProfesion;
    @Basic(optional = false)
    @Column(name = "nombreProfesion")
    private String nombreProfesion;
    @Basic(optional = false)
    @Column(name = "centroEstudio")
    private String centroEstudio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profesion")
    @JsonBackReference(value="prof_docen")
    private List<Docente> docenteList;

   public Profesion() {
    }

    public Profesion(Integer idProfesion) {
        this.idProfesion = idProfesion;
    }

	public Profesion(Integer idProfesion, String nombreProfesion, String centroEstudio) {
		super();
		this.idProfesion = idProfesion;
		this.nombreProfesion = nombreProfesion;
		this.centroEstudio = centroEstudio;
	}

	public Integer getIdProfesion() {
		return idProfesion;
	}

	public void setIdProfesion(Integer idProfesion) {
		this.idProfesion = idProfesion;
	}

	public String getNombreProfesion() {
		return nombreProfesion;
	}

	public void setNombreProfesion(String nombreProfesion) {
		this.nombreProfesion = nombreProfesion;
	}

	public String getCentroEstudio() {
		return centroEstudio;
	}

	public void setCentroEstudio(String centroEstudio) {
		this.centroEstudio = centroEstudio;
	}
	
	@XmlTransient 
	public List<Docente> getDocenteList() {
		return docenteList;
	}

	public void setDocenteList(List<Docente> docenteList) {
		this.docenteList = docenteList;
	}
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProfesion != null ? idProfesion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesion)) {
            return false;
        }
        Profesion other = (Profesion) object;
        if ((this.idProfesion == null && other.idProfesion != null) || (this.idProfesion != null && !this.idProfesion.equals(other.idProfesion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "idat.edu.pe.daa2.modelo.Profesion[ idProfesion=" + idProfesion + " ]";
    }

    
}
