package edu.miu.cs489.ADSApp;

import edu.miu.cs489.ADSApp.model.Address;
import edu.miu.cs489.ADSApp.service.AddressService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdsAppApplication implements CommandLineRunner {

    private final AddressService addressService;

    public AdsAppApplication(AddressService addressService) {
        this.addressService = addressService;
    }

    public static void main(String[] args) {
        SpringApplication.run(AdsAppApplication.class, args);
    }

    private Address addNewAddress(String street, String city, String state, String zipCode) {
        return addressService.saveAddress(new Address(null, street, city, state, zipCode));
    }

    @Override
    public void run(String... args) throws Exception {
        //	System.out.println(addNewAddress("1000 N 4th Street", "Fairfield", "Iowa", "52557"));
    }
}
