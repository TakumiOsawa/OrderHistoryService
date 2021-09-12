package com.ftgo.OrderHistoryService.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressOnDB {
    private String street1;
    private String street2;
    private String city;
    private String state;
    private String zip;
}
