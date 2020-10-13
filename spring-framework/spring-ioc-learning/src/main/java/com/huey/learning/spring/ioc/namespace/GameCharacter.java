package com.huey.learning.spring.ioc.namespace;

import java.beans.ConstructorProperties;

/**
 * @author huey
 */
public class GameCharacter {

    private String type;
    private Integer level;
    private Weapon weapon;

    public GameCharacter() {
        super();
    }

    @ConstructorProperties({"type", "level", "weapon"})
    public GameCharacter(String type, Integer level, Weapon weapon) {
        this.type = type;
        this.level = level;
        this.weapon = weapon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "GameCharacter{" + "type='" + type + '\'' + ", level=" + level + ", weapon=" + weapon + '}';
    }

}
