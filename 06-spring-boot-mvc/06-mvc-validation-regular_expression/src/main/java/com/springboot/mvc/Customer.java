package com.springboot.mvc;

import jakarta.validation.constraints.*;

public class Customer {
    private String firstName;
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")

    private String lastName;
    @Min(value = 0, message = "Must be greater than of equal to zero.")
    @Max(value = 10, message = "Must be greater than or equal to 10")
    private int freePasses;

    @Pattern(regexp = "^[0-9]{6}", message = "Only 6 digits")
    private String postalCode;

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(int freePasses) {
        this.freePasses = freePasses;
    }
}
