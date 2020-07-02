package com.changjiu.bean;

/**
 * @author doubleBear
 * @create 2020 07 01 15:44
 */
public class Business99Data {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Business99Data{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
