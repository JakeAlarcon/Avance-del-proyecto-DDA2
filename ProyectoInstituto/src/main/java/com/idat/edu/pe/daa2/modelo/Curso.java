package com.idat.edu.pe.daa2.modelo;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c")
    , @NamedQuery(name = "Curso.findByIdCurso", query = "SELECT c FROM Curso  c WHERE c.idCurso = :idCurso")
    , @NamedQuery(name = "Curso.findByNombreCurso", query = "SELECT c FROM Curso c WHERE c.nombreCurso = :nombreCurso")
    , @NamedQuery(name = "Curso.findByCreditoCurso", query = "SELECT c FROM Curso c WHERE c.creditoCurso = :creditoCurso")})

public class Curso implements Serializable{

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCurso")
    private Integer idCurso;
    @Basic(optional = false)
    @Column(name = "nombreCurso")
    private String nombreCurso;
    @Basic(optional = false)
    @Column(name = "creditoCurso")
    private String creditoCurso;

    @JoinColumn(name = "alumno", referencedColumnName = "idAlumno")
    @ManyToOne(optional = false)
    private Alumno alumno;
    @JoinColumn(name = "docente", referencedColumnName = "idDocente")
    @ManyToOne(optional = false)
    private Docente docente;
    @JoinColumn(name = "carrera", referencedColumnName = "idCarrera")
    @ManyToOne(optional = false)
    
    private Carrera carrera;

        public Curso() {
    }

    public Curso(Integer idCurso) {
        this.idCurso = idCurso;
    }

	public Curso(Integer idCurso, String nombreCurso, String creditoCurso) {
		super();
		this.idCurso = idCurso;
		this.nombreCurso = nombreCurso;
		this.creditoCurso = creditoCurso;
	}

	public Integer getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	public String getCreditoCurso() {
		return creditoCurso;
	}

	public void setCreditoCurso(String creditoCurso) {
		this.creditoCurso = creditoCurso;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	   @Override
	    public int hashCode() {
	        int hash = 0;
	        hash += (idCurso != null ? idCurso.hashCode() : 0);
	        return hash;
	    }

	    @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof Curso)) {
	            return false;
	        }
	        Curso other = (Curso) object;
	        if ((this.idCurso == null && other.idCurso != null) || (this.idCurso != null && !this.idCurso.equals(other.idCurso))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        return "idat.edu.pe.daa2.modelo.Curso[ idCurso=" + idCurso + " ]";
	    }
}
