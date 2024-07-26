package edu.icet.org.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {
    private Long id;
    private String name;
    private Boolean isAvailable;
    private String rentalPerDay;
    private String finePerDay;

}
