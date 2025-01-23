package com.icsd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String pincode;
}

//@Entity
//public class Address {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    private String addressLine1;
//    private String addressLine2;
//    private String city;
//    private String state;
//    private String pincode;
//
//    // Constructors
//    public Address() {
//    }
//
//    public Address(int id, String addressLine1, String addressLine2, String city, String state, String pincode) {
//        this.id = id;
//        this.addressLine1 = addressLine1;
//        this.addressLine2 = addressLine2;
//        this.city = city;
//        this.state = state;
//        this.pincode = pincode;
//    }
//
//    // Getters and Setters
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getAddressLine1() {
//        return addressLine1;
//    }
//
//    public void setAddressLine1(String addressLine1) {
//        this.addressLine1 = addressLine1;
//    }
//
//    public String getAddressLine2() {
//        return addressLine2;
//    }
//
//    public void setAddressLine2(String addressLine2) {
//        this.addressLine2 = addressLine2;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getState() {
//        return state;
//    }
//
//    public void setState(String state) {
//        this.state = state;
//    }
//
//    public String getPincode() {
//        return pincode;
//    }
//
//    public void setPincode(String pincode) {
//        this.pincode = pincode;
//    }
//}
