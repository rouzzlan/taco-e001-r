package com.falcontech.tacoe001r.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "Taco")
public class Taco {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  private String name;
  @Column(name = "taco_order_id", updatable = false)
  private Long tacoOrderId;
  @Column(name = "created_at")
  @CreationTimestamp
  private Timestamp createdAt;
  @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
  @JoinTable(name = "Taco_to_Ingredient",
      joinColumns = @JoinColumn(name = "taco_id"),
      inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
  @ToString.Exclude
  private Set<Ingredient> ingredients = new HashSet<>();


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Taco that = (Taco) o;
    return id != null && Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
