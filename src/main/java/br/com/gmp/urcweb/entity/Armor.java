/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gmp.urcweb.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kaciano
 */
@Entity
@Table(name = "armor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Armor.findAll", query = "SELECT a FROM Armor a"),
    @NamedQuery(name = "Armor.findByIdarmor", query = "SELECT a FROM Armor a WHERE a.idarmor = :idarmor"),
    @NamedQuery(name = "Armor.findByName", query = "SELECT a FROM Armor a WHERE a.name = :name"),
    @NamedQuery(name = "Armor.findByDescription", query = "SELECT a FROM Armor a WHERE a.description = :description"),
    @NamedQuery(name = "Armor.findByArmorClass", query = "SELECT a FROM Armor a WHERE a.armorClass = :armorClass"),
    @NamedQuery(name = "Armor.findByMovementReduction", query = "SELECT a FROM Armor a WHERE a.movementReduction = :movementReduction"),
    @NamedQuery(name = "Armor.findByPrice", query = "SELECT a FROM Armor a WHERE a.price = :price")})
public class Armor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idarmor")
    private Long idarmor;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 500)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "armor_class")
    private int armorClass;
    @Column(name = "movement_reduction")
    private Integer movementReduction;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private long price;
    @JoinColumn(name = "idorigin", referencedColumnName = "idorigin")
    @ManyToOne(optional = false)
    private Origin idorigin;
    @JoinColumn(name = "idarmor_type", referencedColumnName = "idarmor_type")
    @ManyToOne(optional = false)
    private ArmorType idarmorType;
    @JoinColumn(name = "idalignment", referencedColumnName = "idalignment")
    @ManyToOne(optional = false)
    private Alignment idalignment;

    public Armor() {
    }

    public Armor(Long idarmor) {
        this.idarmor = idarmor;
    }

    public Armor(Long idarmor, int armorClass, long price) {
        this.idarmor = idarmor;
        this.armorClass = armorClass;
        this.price = price;
    }

    public Long getIdarmor() {
        return idarmor;
    }

    public void setIdarmor(Long idarmor) {
        this.idarmor = idarmor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public Integer getMovementReduction() {
        return movementReduction;
    }

    public void setMovementReduction(Integer movementReduction) {
        this.movementReduction = movementReduction;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Origin getIdorigin() {
        return idorigin;
    }

    public void setIdorigin(Origin idorigin) {
        this.idorigin = idorigin;
    }

    public ArmorType getIdarmorType() {
        return idarmorType;
    }

    public void setIdarmorType(ArmorType idarmorType) {
        this.idarmorType = idarmorType;
    }

    public Alignment getIdalignment() {
        return idalignment;
    }

    public void setIdalignment(Alignment idalignment) {
        this.idalignment = idalignment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idarmor != null ? idarmor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Armor)) {
            return false;
        }
        Armor other = (Armor) object;
        if ((this.idarmor == null && other.idarmor != null) || (this.idarmor != null && !this.idarmor.equals(other.idarmor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gmp.urcweb.entity.Armor[ idarmor=" + idarmor + " ]";
    }
    
}
