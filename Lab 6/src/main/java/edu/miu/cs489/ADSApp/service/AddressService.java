package edu.miu.cs489.ADSApp.service;

import edu.miu.cs489.ADSApp.model.Address;

import java.util.List;

public interface AddressService {
    Address saveAddress(Address address);

    List<Address> getAllAddress();

    Address getAddressById(Integer addressId);

    Address updateAddress(Address address);

    void deleteAddressById(Integer addressId);
}
