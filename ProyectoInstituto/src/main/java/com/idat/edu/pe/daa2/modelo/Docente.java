package com.idat.edu.pe.daa2.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "docente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Docente.findAll", query = "SELECT d FROM Docente d")
    , @NamedQuery(name = "Docente.findByIdDocente", query = "SELECT d FROM Docente d WHERE d.idDocente = :idDocente")
    , @NamedQuery(name = "Docente.findByNombreDocente", query = "SELECT d FROM Docente d WHERE d.nombreDocente = :nombreDocente")
    , @NamedQuery(name = "Docente.findByEdadDocente", query = "SELECT d FROM Docente d WHERE d.edadDocente = :edadDocente")
    , @NamedQuery(name = "Docente.findByCorreoDocente", query = "SELECT d FROM Docente d WHERE d.correoDocente = :correoDocente")})

public class Docente implements Serializable{

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDocente")
    private Integer idDocente;
    @Basic(optional = false)
    @Column(name = "nombreDocente")
    private String nombreDocente;
    @Column(name = "edadDocente")
    private String edadDocente; 
    @Column(name = "correoDocente")
    private String correoDocente; 

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "docente",fetch=FetchType.LAZY)
    @JsonBackReference(value="docente_cur")
    private List<Curso> cursosList;
    @JoinColumn(name = "profesion", referencedColumnName = "idProfesion")
    @ManyToOne(optional = false)
    private Profesion profesion;

   public Docente() {
    }

    public Docente(Integer idDocente) {
        this.idDocente = idDocente;
    }

    public Docente(Integer idDocente, String nombreDocente) {
        this.idDocente = idDocente;
        this.nombreDocente = nombreDocente;
    }

	public Integer getIdDocente() {
		return idDocente;
	}

	public void setIdDocente(Integer idDocente) {
		this.idDocente = idDocente;
	}

	public String getNombreDocente() {
		return nombreDocente;
	}

	public void setNombreDocente(String nombreDocente) {
		this.nombreDocente = nombreDocente;
	}

	public String getEdadDocente() {
		return edadDocente;
	}

	public void setEdadDocente(String edadDocente) {
		this.edadDocente = edadDocente;
	}

	public String getCorreoDocente() {
		return correoDocente;
	}

	public void setCorreoDocente(String correoDocente) {
		this.correoDocente = correoDocente;
	}

	@XmlTransient
	public List<Curso> getCursosList() {
		return cursosList;
	}

	public void setCursosList(List<Curso> cursosList) {
		this.cursosList = cursosList;
	}

	public Profesion getProfesion() {
		return profesion;
	}

	public void setProfesion(Profesion profesion) {
		this.profesion = profesion;
	}

	
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocente != null ? idDocente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docente)) {
            return false;
        }
        Docente other = (Docente) object;
        if ((this.idDocente == null && other.idDocente != null) || (this.idDocente != null && !this.idDocente.equals(other.idDocente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "idat.edu.pe.daa2.modelo.Docente[ idDocente=" + idDocente+ " ]";
    }


    
}
