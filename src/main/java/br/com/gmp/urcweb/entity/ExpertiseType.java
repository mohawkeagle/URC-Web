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
@Table(name = "expertise_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExpertiseType.findAll", query = "SELECT e FROM ExpertiseType e"),
    @NamedQuery(name = "ExpertiseType.findByIdexpertiseType", query = "SELECT e FROM ExpertiseType e WHERE e.idexpertiseType = :idexpertiseType"),
    @NamedQuery(name = "ExpertiseType.findByName", query = "SELECT e FROM ExpertiseType e WHERE e.name = :name")})
public class ExpertiseType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idexpertise_type")
    private Long idexpertiseType;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idexpertiseType")
    private List<Expertise> expertiseList;

    public ExpertiseType() {
    }

    public ExpertiseType(Long idexpertiseType) {
        this.idexpertiseType = idexpertiseType;
    }

    public Long getIdexpertiseType() {
        return idexpertiseType;
    }

    public void setIdexpertiseType(Long idexpertiseType) {
        this.idexpertiseType = idexpertiseType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<Expertise> getExpertiseList() {
        return expertiseList;
    }

    public void setExpertiseList(List<Expertise> expertiseList) {
        this.expertiseList = expertiseList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idexpertiseType != null ? idexpertiseType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExpertiseType)) {
            return false;
        }
        ExpertiseType other = (ExpertiseType) object;
        if ((this.idexpertiseType == null && other.idexpertiseType != null) || (this.idexpertiseType != null && !this.idexpertiseType.equals(other.idexpertiseType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gmp.urcweb.entity.ExpertiseType[ idexpertiseType=" + idexpertiseType + " ]";
    }
    
}
