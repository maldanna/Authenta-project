package com.maldanna.authenta.model;

import javax.validation.constraints.NotBlank;

public class CustomerData {
    @NotBlank(message ="mpn should not be blank")
    String MPN;
    @NotBlank(message = "manufacturer should not be blank")
    String manufacturer[];

}
