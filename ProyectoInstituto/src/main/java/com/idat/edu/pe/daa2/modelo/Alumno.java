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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "alumno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alumno.findAll", query = "SELECT a FROM Alumno a")
    , @NamedQuery(name = "Alumno.findByIdAlumno", query = "SELECT a FROM Alumno a WHERE a.idAlumno = :idAlumno")
    , @NamedQuery(name = "Alumno.findByNombreAlumno", query = "SELECT a FROM Alumno a WHERE a.nombreAlumno = :nombreAlumno")
    , @NamedQuery(name = "Alumno.findByEdadAlumno", query = "SELECT a FROM Alumno a WHERE a.edadAlumno = :edadAlumno")
    , @NamedQuery(name = "Alumno.findByDireccionAlumno", query = "SELECT a FROM Alumno a WHERE a.direccionAlumno = :direccionAlumno")
    , @NamedQuery(name = "Alumno.findByCorreoAlumno", query = "SELECT a FROM Alumno a WHERE a.correoAlumno = :correoAlumno")})

public class Alumno implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAlumno")
    private Integer idAlumno;
    @Basic(optional = false)
    @Column(name = "nombreAlumno")
    private String nombreAlumno;
    @Column(name = "edadAlumno")
    private String edadAlumno;
    @Column(name = "direccionAlumno")
    private String direccionAlumno;
    @Column(name = "correoAlumno")
    private String correoAlumno;
  
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno",fetch=FetchType.LAZY)
    @JsonBackReference(value="alumno_cur")
    private List<Curso> alumnosList;

    public Alumno() {
    }

    public Alumno(Integer idAlumno, String string, String string2) {
        this.idAlumno = idAlumno;
    }

    public Alumno(Integer idAlumno, String nombreAlumno) {
        this.idAlumno = idAlumno;
        this.nombreAlumno = nombreAlumno;
    }

	public Alumno(String nombreAlumno, String edadAlumno, String direccionAlumno, String correoAlumno) {
		super();
		this.nombreAlumno = nombreAlumno;
		this.edadAlumno = edadAlumno;
		this.direccionAlumno = direccionAlumno;
		this.correoAlumno = correoAlumno;
	}

	public Integer getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getNombreAlumno() {
		return nombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	public String getEdadAlumno() {
		return edadAlumno;
	}

	public void setEdadAlumno(String edadAlumno) {
		this.edadAlumno = edadAlumno;
	}

	public String getDireccionAlumno() {
		return direccionAlumno;
	}

	public void setDireccionAlumno(String direccionAlumno) {
		this.direccionAlumno = direccionAlumno;
	}

	public String getCorreoAlumno() {
		return correoAlumno;
	}

	public void setCorreoAlumno(String correoAlumno) {
		this.correoAlumno = correoAlumno;
	}

    @XmlTransient
	public List<Curso> getAlumnosList() {
		return alumnosList;
	}

	public void setAlumnosList(List<Curso> alumnosList) {
		this.alumnosList = alumnosList;
	}
    

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlumno != null ? idAlumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.idAlumno == null && other.idAlumno != null) || (this.idAlumno != null && !this.idAlumno.equals(other.idAlumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "idat.edu.pe.daa2.modelo.Alumno[ idAlumno=" + idAlumno + " ]";
    }

	public Alumno buscarPorID(int i) {
		// TODO Auto-generated method stub
		return null;
	}
    
}
