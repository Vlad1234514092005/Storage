package com.tvo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Good {
    private String name;
    private String manufacturer;
    private String description;
    private int quantity;
    private float price;
}
