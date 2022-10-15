package com.maldanna.authenta.model;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerData {
    @NotBlank(message ="mpn should not be blank")
    String MPN;
    @NotBlank(message = "manufacturer should not be blank")
    String manufacturer;
    String Commands;

}
