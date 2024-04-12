package edu.miu.cs489.ADSApp;

import edu.miu.cs489.ADSApp.model.*;
import edu.miu.cs489.ADSApp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Formatter;
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
//        addAddresses();
//        addPatients();
//        addDentists();
//        addSurgeries();
//        addAppointments();

        //Show All Appointment with Custom query;
        showAppointment();
    }

    //TEST ADDRESS CRUD(){
    private void addAddresses() {
        // Creating address objects
        addNewAddress("802 N 8th Street", "Fairfield", "Iowa", "52556");
        addNewAddress("123 Main Street", "Anytown", "California", "90001");
        addNewAddress("456 Elm Street", "Springfield", "Illinois", "62701");
        addNewAddress("789 Oak Avenue", "Portland", "Oregon", "97201");
        addNewAddress("101 Pine Street", "Seattle", "Washington", "98101");

        System.out.println("===Address Inserted ===");
        System.out.println(getAllAddress());
    }

    private void showAppointment() {
        List<AppointmentResult> appointmentResults = new ArrayList<>();
        List<Appointment> appointments = getAllAppointment();

        appointments.forEach(appointment -> {
            System.out.println(appointment.getDentist().getDentistId());
            Dentist d = getDentistById(appointment.getDentist().getDentistId());
            String dentistName = d.getFirstName() + " " + d.getLastName();
            Patient p = getPatientById(appointment.getPatient().getPatientId());
            Integer patNo = p.getPatientId();
            String patName = p.getFirstName() + " " + p.getLastName();
            String appointmentDateTime = appointment.getAppointmentDate() + " " + appointment.getAppointmentTime();
            Integer surgeryNo = appointment.getSurgery().getSurgeryId();
            appointmentResults.add(new AppointmentResult(dentistName, patNo, patName, appointmentDateTime, surgeryNo));
        });


        System.out.println("Appointment with Full Information");

        Formatter fmt = new Formatter();
        fmt.format("%15s %15s %15s %15s %15s\n", "dentistName", "patNo", "patName", "appointmentDateTime", "surgeryNo");
        appointmentResults.forEach(a -> {
            fmt.format("%15s %15s %15s %15s %15s\n", a.getDentistName(), a.getPatNo(), a.getPatName(), a.getAppointmentDateTime(), a.getSurgeryNo());
        });
        System.out.println(fmt);
    }

    //TEST PATIENT CRUD
    private void addPatients() {
        // Creating patient objectt
        addNewPatient("Gillian", "White", "926-3747-309", "gillian.white@gmail.com", getAddressById(1), "12/10/1988");
        addNewPatient("John", "Doe", "123-45-6789", "john.doe@example.com", getAddressById(2), "05/20/1975");
        addNewPatient("Alice", "Johnson", "987-65-4321", "alice.johnson@example.com", getAddressById(3), "08/15/1990");
        addNewPatient("Michael", "Smith", "555-66-7777", "michael.smith@example.com", getAddressById(4), "03/25/1983");
        addNewPatient("Emily", "Brown", "111-22-3333", "emily.brown@example.com", getAddressById(5), "11/08/1995");

        System.out.println("===Patient Inserted ===");
        System.out.println(getAllAddress());
    }

    private void addDentists() {
        addNewDentist("John", "Smith", "145-2374-331", "johnsmith@example.com", "Surgery");
        addNewDentist("Emily", "Johnson", "245-5896-782", "emily.j@example.com", "Orthodontics");
        addNewDentist("Michael", "Brown", "345-7823-912", "mbrown@example.com", "Endodontics");
        addNewDentist("Sarah", "Davis", "445-1234-567", "sdavis@example.com", "Periodontics");
        addNewDentist("David", "Martinez", "545-9876-234", "david.m@example.com", "Pediatric Dentistry");
    }

    private void addAppointments() {
        addNewAppointment("04/12/2024", "10:30 A.M", "Confirm", getPatientById(1), getSurgeryById(2), getDentistById(1));
        addNewAppointment("04/12/2024", "11:15 A.M", "Confirm", getPatientById(2), getSurgeryById(3), getDentistById(2));
        addNewAppointment("04/13/2024", "02:00 P.M", "Confirm", getPatientById(3), getSurgeryById(4), getDentistById(3));
        addNewAppointment("04/13/2024", "03:30 P.M", "Confirm", getPatientById(4), getSurgeryById(1), getDentistById(4));
        addNewAppointment("04/14/2024", "09:00 A.M", "Confirm", getPatientById(5), getSurgeryById(5), getDentistById(5));
        addNewAppointment("04/14/2024", "10:45 A.M", "Confirm", getPatientById(1), getSurgeryById(2), getDentistById(1));
        addNewAppointment("04/15/2024", "01:30 P.M", "Confirm", getPatientById(2), getSurgeryById(3), getDentistById(2));
        addNewAppointment("04/15/2024", "03:15 P.M", "Confirm", getPatientById(3), getSurgeryById(4), getDentistById(3));
        addNewAppointment("04/16/2024", "08:45 A.M", "Confirm", getPatientById(4), getSurgeryById(1), getDentistById(4));
        addNewAppointment("04/16/2024", "11:00 A.M", "Confirm", getPatientById(5), getSurgeryById(5), getDentistById(5));
    }

    private void addSurgeries() {
        addNewSurgery("Tooth Whitening", getAddressById(1), "332-3768-001");
        addNewSurgery("Root Canal Treatment", getAddressById(2), "442-8899-002");
        addNewSurgery("Dental Implants", getAddressById(3), "553-1122-003");
        addNewSurgery("Wisdom Tooth Extraction", getAddressById(4), "664-3344-004");
        addNewSurgery("Gum Surgery", getAddressById(5), "775-5566-005");
    }


    //ADDRESS TABLE CRUD METHODS
    private Address addNewAddress(String street, String city, String state, String zipCode) {
        return addressService.saveAddress(new Address(0, street, city, state, zipCode));
    }

    private List<Address> getAllAddress() {
        return addressService.getAllAddress();
    }

    private Address getAddressById(Integer addressId) {
        return addressService.getAddressById(addressId);
    }

    private Address updateAddress(Address address) {
        return addressService.updateAddress(address);
    }

    private void deleteAddressById(Integer addressId) {
        addressService.deleteAddressById(addressId);
    }


    //PATIENT TABLE CRUD METHODS
    private Patient addNewPatient(String firstName, String lastName, String contactPhoneNo, String email, Address address, String dob) {
        return patientService.savePatient(new Patient(0, firstName, lastName, contactPhoneNo, email, address, dob));
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
        return dentistService.saveDentist(new Dentist(0, firstName, lastName, contactNo, email, specialization));
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
        return surgeryService.saveSurgery(new Surgery(0, name, address, telephone));
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
        return appointmentService.saveAppointment(new Appointment(0, apptDate, apptTime, status, patientId, surgeryId, dentistId));
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
//    private User addNewUser(String username, String password, String name, Role role) {
//        return userService.saveUser(new User(null, username, password, name, role));
//    }

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
