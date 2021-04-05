package hiber.model;

import javax.persistence.*;

@Entity(name="cars")
public class Car {

    @Id
    @GeneratedValue
    @Column(name="car_id")
    private Long car_id;

    @Column(name="model")
    private String model;

    @Column(name="series")
    private int series;

    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    private User user;

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public Car() {}

    public Long getCar_id() {
        return car_id;
    }
//
//    public void setCar_id(int car_id) {
//        this.car_id = car_id;
//    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "model car = '" + model +
                "', series car = '" + series + "'";
    }
}
