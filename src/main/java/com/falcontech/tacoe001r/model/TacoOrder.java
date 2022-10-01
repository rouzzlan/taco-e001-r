package com.falcontech.tacoe001r.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "Taco_Order")
public class TacoOrder {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "placed_at")
  @CreationTimestamp
  private Timestamp placedAt;
  @Column(name = "delivery_Name")
  private String deliveryName;
  @Column(name = "delivery_Street")
  private String deliveryStreet;
  @Column(name = "delivery_City")
  private String deliveryCity;
  @Column(name = "delivery_State")
  private String deliveryState;
  @Column(name = "delivery_Zip")
  private String deliveryZip;
  @Column(name = "cc_number")
  private String ccNumber;
  @Column(name = "cc_expiration")
  private String ccExpiration;
  @Column(name = "cc_cvv")
  private String ccCVV;
  private String email;
  @OneToMany(cascade = {CascadeType.PERSIST}, orphanRemoval = true, fetch = FetchType.EAGER)
  @JoinColumn(name = "taco_order_id")
  @ToString.Exclude
  private Set<Taco> tacos = new HashSet<>();
  @Column(name = "orderer_id")
  private UUID orderer_id;
}
