package edu.miu.cs489.ADSApp;

import edu.miu.cs489.ADSApp.model.*;
import edu.miu.cs489.ADSApp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class AdsAppApplication implements CommandLineRunner {

    @Autowired
    private AddressService addressService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private DentistService dentistService;

    @Autowired
    private SurgeryService surgeryService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(AdsAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //runAddressCRUD();
        runPatientCRUD();
    }

    //TEST ADDRESS CRUD(){
    private void runAddressCRUD(){
        // Creating address objects
        addNewAddress("802 N 8th Street", "Fairfield", "Iowa", "52556");
        addNewAddress("123 Main Street", "Anytown", "California", "90001");
        addNewAddress("456 Elm Street", "Springfield", "Illinois", "62701");
        addNewAddress("789 Oak Avenue", "Portland", "Oregon", "97201");
        addNewAddress("101 Pine Street", "Seattle", "Washington", "98101");

        System.out.println("Inserted Addresses:");
        System.out.println(getAllAddress());
    }

    //TEST PATIENT CRUD
    private void runPatientCRUD(){


        // Creating patient objectt
        Address address1 = getAddressById(1);
        addNewPatient("Gillian", "White", "926-3747-309", "gillian.white@gmail.com", address1, "12/10/1988");
//        addNewPatient("John", "Doe", "123-45-6789", "john.doe@example.com", getAddressById(2), "05/20/1975");
//        addNewPatient("Alice", "Johnson", "987-65-4321", "alice.johnson@example.com", getAddressById(3), "08/15/1990");
//        addNewPatient("Michael", "Smith", "555-66-7777", "michael.smith@example.com", getAddressById(4), "03/25/1983");
//        addNewPatient("Emily", "Brown", "111-22-3333", "emily.brown@example.com", getAddressById(5), "11/08/1995");

    }

    //ADDRESS TABLE CRUD METHODS
    private Address addNewAddress(String street, String city, String state, String zipCode) {
        return addressService.saveAddress(new Address(null, street, city, state, zipCode));
    }

    private List<Address> getAllAddress(){
        return addressService.getAllAddress();
    }

    private Address getAddressById(Integer addressId){
        return addressService.getAddressById(addressId);
    }

    private Address updateAddress(Address address){
        return addressService.updateAddress(address);
    }

    private void deleteAddressById(Integer addressId){
        addressService.deleteAddressById(addressId);
    }


    //PATIENT TABLE CRUD METHODS
    private Patient addNewPatient(String firstName, String lastName, String contactPhoneNo, String email, Address address, String dob) {
        return patientService.savePatient(new Patient(null, firstName, lastName, contactPhoneNo, email, address, dob));
    }

    private List<Patient> getAllPatient() {
        return patientService.getAllPatient();
    }

    private Patient getPatientById(Integer patientId) {
        return patientService.getPatientById(patientId);
    }

    private Patient updatePatient(Patient patient) {
        return patientService.updatePatient(patient);
    }

    private void deletePatientById(Integer patientId) {
        patientService.deletePatientById(patientId);
    }


    //DENTIST TABLE CRUD METHODS
    private Dentist addNewDentist(String firstName, String lastName, String contactNo, String email, String specialization) {
        return dentistService.saveDentist(new Dentist(null, firstName, lastName, contactNo, email, specialization));
    }

    private List<Dentist> getAllDentists() {
        return dentistService.getAllDentists();
    }

    private Dentist getDentistById(Integer dentistId) {
        return dentistService.getDentistById(dentistId);
    }

    private Dentist updateDentist(Dentist dentist) {
        return dentistService.updateDentist(dentist);
    }

    private void deleteDentistById(Integer dentistId) {
        dentistService.deleteDentistById(dentistId);
    }

    //SURGERY CRUD methods
    private Surgery addNewSurgery(String name, Address address, String telephone) {
        return surgeryService.saveSurgery(new Surgery(null, name, address, telephone));
    }

    private List<Surgery> getAllSurgeries() {
        return surgeryService.getAllSurgeries();
    }

    private Surgery getSurgeryById(Integer surgeryId) {
        return surgeryService.getSurgeryById(surgeryId);
    }

    private Surgery updateSurgery(Surgery surgery) {
        return surgeryService.updateSurgery(surgery);
    }

    private void deleteSurgeryById(Integer surgeryId) {
        surgeryService.deleteSurgery(surgeryId);
    }


    //APPOINTMENT TABLE CRUD METHODS
    private Appointment addNewAppointment(String apptDate, String apptTime, String status, Patient patientId, Surgery surgeryId, Dentist dentistId) {
        return appointmentService.saveAppointment(new Appointment(null, apptDate, apptTime, status, patientId, surgeryId, dentistId));
    }

    private List<Appointment> getAllAppointment() {
        return appointmentService.getAllAppointment();
    }

    private Appointment getAppointmentById(Integer appointmentId) {
        return appointmentService.getAppointmentById(appointmentId);
    }

    private Appointment updateAppointment(Appointment appointment) {
        return appointmentService.updateAppointment(appointment);
    }

    private void deleteAppointmentById(Integer appointmentId) {
        appointmentService.deleteAppointmentById(appointmentId);
    }


    //ROLE TABLE CRUD METHODS
    private Role addNewRole(String name) {
        return roleService.saveRole(new Role(null, name));
    }

    private List<Role> getAllRole() {
        return roleService.getAllRoles();
    }

    private Role getRoleById(Integer roleId) {
        return roleService.getRoleById(roleId);
    }

    private Role updateRole(Role role) {
        return roleService.updateRole(role);
    }

    private void deleteRole(Integer roleId) {
        roleService.deleteRoleById(roleId);
    }

    //USER TABLE CRUD METHODS
    private User addNewUser(String username, String password, String name, Role role) {
        return userService.saveUser(new User(null, username, password, name, role));
    }

    private List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    private User getUserById(Integer userId) {
        return userService.getUserById(userId);
    }

    private User updateUser(User user) {
        return userService.updateUser(user);
    }

    private void deleteUserById(Integer userId) {
        userService.deleteUserById(userId);
    }
}
