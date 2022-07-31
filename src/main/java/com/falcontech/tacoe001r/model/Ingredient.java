package com.falcontech.tacoe001r.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Ingredient")
public class Ingredient {
  @Id
  private String id;
  private String name;
  @Enumerated(EnumType.STRING)
  private Type type;

  @Column(name = "enabled")
  private Boolean isEnabled;

  public enum Type {
    @JsonProperty("WRAP")
    WRAP,
    @JsonProperty("PROTEIN")
    PROTEIN,
    @JsonProperty("VEGGIES")
    VEGGIES,
    @JsonProperty("CHEESE")
    CHEESE,
    @JsonProperty("SAUCE")
    SAUCE
  }

  public Ingredient(String name, Type type) {
    this.name = name;
    this.type = type;
  }
}
