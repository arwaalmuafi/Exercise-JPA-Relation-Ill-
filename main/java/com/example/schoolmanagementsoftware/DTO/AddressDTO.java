package com.example.schoolmanagementsoftware.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    private Integer teacher_id;
    @NotEmpty
    @Size(min = 3,message = "area should be more 3")
    private String area;
    @NotEmpty
    @Size(min = 3,message = "street should be more then 3")
    private String street;
    @NotEmpty
    @Size(min = 3,message = "buildingNumber should be more then 3")
    private String buildingNumber;
}
