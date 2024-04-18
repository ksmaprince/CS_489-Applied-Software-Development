package edu.cs489.adssysem.dto.address;

public record AddressRequest(
        String street,
        String city,
        String state,
        String zipCode
    ) {
}
