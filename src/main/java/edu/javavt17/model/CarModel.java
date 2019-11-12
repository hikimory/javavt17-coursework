package edu.javavt17.model;

import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="model")
@NamedQuery(name="CarModel.findAll", query="select m from CarModel m")
public class CarModel implements Serializable {
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private int idModel;

    @Column(insertable = false, updatable = false)
    private int idBrand;

    @ManyToOne
    @JoinColumn(name = "idBrand")
    private CarBrand carBrand;

    @NotEmpty @Column
    private String modelName;
    @Column private String generation;
    @Column private short productionYear;
    @Column private byte doors;
    @Column private byte seats;
    @Column private short maximumSpeed;

    public CarModel() {}

    public int getIdModel() {
        return idModel;
    }

    public int getIdBrand() {
        return idBrand;
    }

    public CarBrand getCarBrand() {
        return carBrand;
    }

    public String getModelName() {
        return modelName;
    }

    public String getGeneration() {
        return generation;
    }

    public short getProductionYear() {
        return productionYear;
    }

    public byte getDoors() {
        return doors;
    }

    public byte getSeats() {
        return seats;
    }

    public short getMaximumSpeed() {
        return maximumSpeed;
    }

    public void setIdModel(int idModel) {
        this.idModel = idModel;
    }
    public void setIdBrand(int idBrand) {
        this.idBrand = idBrand;
    }

    public void setCarBrand(CarBrand carBrand) {
        this.carBrand = carBrand;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    public void setProductionYear(short productionYear) {
        this.productionYear = productionYear;
    }

    public void setDoors(byte doors) {
        this.doors = doors;
    }

    public void setSeats(byte seats) {
        this.seats = seats;
    }

    public void setMaximumSpeed(short maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }

    @Override
    public String toString() {
        return "CarModel{" +
                "idModel=" + idModel +
                ", carBrand=" + carBrand.getName() +
                ", idBrand=" + idBrand +
                ", modelName='" + modelName + '\'' +
                ", generation='" + generation + '\'' +
                ", productionYear=" + productionYear +
                ", doors=" + doors +
                ", seats=" + seats +
                ", maximumSpeed=" + maximumSpeed +
                '}';
    }
}