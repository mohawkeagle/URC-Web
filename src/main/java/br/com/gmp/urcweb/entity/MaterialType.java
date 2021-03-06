/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gmp.urcweb.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kaciano
 */
@Entity
@Table(name = "material_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaterialType.findAll", query = "SELECT m FROM MaterialType m"),
    @NamedQuery(name = "MaterialType.findByIdmaterialType", query = "SELECT m FROM MaterialType m WHERE m.idmaterialType = :idmaterialType"),
    @NamedQuery(name = "MaterialType.findByName", query = "SELECT m FROM MaterialType m WHERE m.name = :name")})
public class MaterialType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmaterial_type")
    private Long idmaterialType;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmaterialType")
    private List<Weapon> weaponList;

    public MaterialType() {
    }

    public MaterialType(Long idmaterialType) {
        this.idmaterialType = idmaterialType;
    }

    public Long getIdmaterialType() {
        return idmaterialType;
    }

    public void setIdmaterialType(Long idmaterialType) {
        this.idmaterialType = idmaterialType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<Weapon> getWeaponList() {
        return weaponList;
    }

    public void setWeaponList(List<Weapon> weaponList) {
        this.weaponList = weaponList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmaterialType != null ? idmaterialType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaterialType)) {
            return false;
        }
        MaterialType other = (MaterialType) object;
        if ((this.idmaterialType == null && other.idmaterialType != null) || (this.idmaterialType != null && !this.idmaterialType.equals(other.idmaterialType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gmp.urcweb.entity.MaterialType[ idmaterialType=" + idmaterialType + " ]";
    }
    
}
