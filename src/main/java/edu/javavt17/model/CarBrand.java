package edu.javavt17.model;

import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "brand")
@NamedQuery(name = "CarBrand.findAll", query = "select c from CarBrand c")
public class CarBrand implements Serializable {
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private int idBrand;
    @NotEmpty @Column(unique=true, nullable=false)
    private String name;

    @Column private short foundedYear;

    @Column private String headquarter;

    public CarBrand() {}

    public void setIdBrand(int idBrand) {
        this.idBrand = idBrand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFoundedYear(short foundedYear) {
        this.foundedYear = foundedYear;
    }

    public void setHeadquarter(String headquarter) {
        this.headquarter = headquarter;
    }

    public int getIdBrand() {
        return idBrand;
    }

    public String getName() {
        return name;
    }

    public short getFoundedYear() {
        return foundedYear;
    }

    public String getHeadquarter() {
        return headquarter;
    }

    @Override
    public String toString() {
        return "CarBrand{" +
                "idBrand=" + idBrand +
                ", name='" + name + '\'' +
                ", foundedYear=" + foundedYear +
                ", headquarter='" + headquarter + '\'' +
                '}';
    }
}