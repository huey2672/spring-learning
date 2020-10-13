package com.huey.learning.spring.ioc.namespace;

import java.beans.ConstructorProperties;

/**
 * @author huey
 */
public class Weapon {

    private String type;
    private Double weightKg;

    public Weapon() {
        super();
    }

    @ConstructorProperties({"type", "weightKg"})
    public Weapon(String type, Double weightKg) {
        this.type = type;
        this.weightKg = weightKg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(Double weightKg) {
        this.weightKg = weightKg;
    }

    @Override
    public String toString() {
        return "Weapon{" + "type='" + type + '\'' + ", weightKg=" + weightKg + '}';
    }

}
