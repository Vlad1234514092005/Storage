package com.tvo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Good {
    private String name;
    private String manufacturer;
    private String description;
    private int quantity;
    private float price;
}
