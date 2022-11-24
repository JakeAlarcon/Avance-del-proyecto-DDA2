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
@Table(name = "sede")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sede.findAll", query = "SELECT se FROM Sede se")
    , @NamedQuery(name = "Sede.findByIdSede", query = "SELECT se FROM Sede se WHERE se.idSede = :idSede")
    , @NamedQuery(name = "Sede.findByNombreSede", query = "SELECT se FROM Sede se WHERE se.nombreSede = :nombreSede")
    , @NamedQuery(name = "Sede.findByDireccionSede", query = "SELECT se FROM Sede se WHERE se.direccionSede = :direccionSede")})

public class Sede implements Serializable{



    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSede")
    private Integer idSede;
    @Basic(optional = false)
    @Column(name = "nombreSede")
    private String nombreSede;
    @Column(name = "direccionSede")
    private String direccionSede;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sede",fetch=FetchType.LAZY)
    @JsonBackReference(value="sede_car")
    private List<Carrera> carreraList;

       public Sede() {
    }

    public Sede(Integer idSede) {
        this.idSede = idSede;
    }

    public Sede(Integer idSede, String nombreSede) {
        this.idSede = idSede;
        this.nombreSede = nombreSede;
    }

	public Sede(String nombreSede, String direccionSede) {
		super();
		this.nombreSede = nombreSede;
		this.direccionSede = direccionSede;
	}

	public Integer getIdSede() {
		return idSede;
	}

	public void setIdSede(Integer idSede) {
		this.idSede = idSede;
	}

	public String getNombreSede() {
		return nombreSede;
	}

	public void setNombreSede(String nombreSede) {
		this.nombreSede = nombreSede;
	}

	public String getDireccionSede() {
		return direccionSede;
	}

	public void setDireccionSede(String direccionSede) {
		this.direccionSede = direccionSede;
	}

	@XmlTransient
	public List<Carrera> getCarreraList() {
		return carreraList;
	}

	public void setCarreraList(List<Carrera> carreraList) {
		this.carreraList = carreraList;
	}


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSede != null ? idSede .hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sede)) {
            return false;
        }
        Sede other = (Sede) object;
        if ((this.idSede  == null && other.idSede  != null) || (this.idSede  != null && !this.idSede .equals(other.idSede ))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "idat.edu.pe.daa2.modelo.Sede[ idSede =" + idSede + " ]";
    }

	public Sede buscarPorID(int i) {
		// TODO Auto-generated method stub
		return null;
	}
    
}
