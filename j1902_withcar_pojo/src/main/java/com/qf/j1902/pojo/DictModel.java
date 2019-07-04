package com.qf.j1902.pojo;

public class DictModel {
    private Integer id;

    private String code;

    private String country;

    private String modelName;

    private Integer modelId;

    private Integer msrpMin;

    private Byte spaces;

    private Byte powers;

    private Byte comfort;

    private Byte cost;

    private Byte safety;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName == null ? null : modelName.trim();
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public Integer getMsrpMin() {
        return msrpMin;
    }

    public void setMsrpMin(Integer msrpMin) {
        this.msrpMin = msrpMin;
    }

    public Byte getSpaces() {
        return spaces;
    }

    public void setSpaces(Byte spaces) {
        this.spaces = spaces;
    }

    public Byte getPowers() {
        return powers;
    }

    public void setPowers(Byte powers) {
        this.powers = powers;
    }

    public Byte getComfort() {
        return comfort;
    }

    public void setComfort(Byte comfort) {
        this.comfort = comfort;
    }

    public Byte getCost() {
        return cost;
    }

    public void setCost(Byte cost) {
        this.cost = cost;
    }

    public Byte getSafety() {
        return safety;
    }

    public void setSafety(Byte safety) {
        this.safety = safety;
    }
}