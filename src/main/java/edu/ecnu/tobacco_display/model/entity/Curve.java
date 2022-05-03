package edu.ecnu.tobacco_display.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 烘烤曲线
 *
 * @author TruthK
 */
public class Curve {
    @JsonProperty("id")
    private int id;

    @JsonProperty("kind")
    private String kind;

    @JsonProperty("dry_or_wet")
    private String dryOrWet;

    @JsonProperty("curve")
    private String curve;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getDryOrWet() {
        return dryOrWet;
    }

    public void setDryOrWet(String dryOrWet) {
        this.dryOrWet = dryOrWet;
    }

    public String getCurve() {
        return curve;
    }

    public void setCurve(String curve) {
        this.curve = curve;
    }
}
