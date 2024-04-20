package com.personalProject.CarDealership.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "makes")
public class MakeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "make_id")
    private long makeId;
    private String make;
    private String model;
    @OneToMany(mappedBy = "carMake", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CarModel> cars;

    public MakeModel(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public MakeModel() {
    }

    public long getMakeId() {
        return makeId;
    }

    public void setMakeId(long makeId) {
        this.makeId = makeId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<CarModel> getModels() {
        return cars;
    }

    public void setModels(List<CarModel> models) {
        this.cars = cars;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

}
