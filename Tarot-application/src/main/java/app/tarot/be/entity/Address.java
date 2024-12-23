package app.tarot.be.entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @NotNull(message = "City cannot be null")
    private String city;

    @NotNull(message = "District cannot be null")
    private String district;

    @NotNull(message = "Ward cannot be null")
    private String ward;

    @NotNull(message = "Postal code cannot be null")
    private String postalCode;

    @NotNull(message = "Address detail cannot be null")
    private String addressDetail;
}
