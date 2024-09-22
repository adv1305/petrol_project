package com.petrol.petrol_project.output;

public class Output {

    private String orderNo;
    private String time;
    private String date; // Add date field
    private String additionalComment;
    private String additionalNotes;
    private String cardCVV;
    private String cardExpiryDate;
    private String cardNumber;
    private String city;
    private String email;
    private String fuelType;
    private String fullName;
    private String phone;
    private String pincode;
    private String serviceAmount;
    private String state;
    private String streetAddress;
    private String vehicleModel;
    private String vehicleRegNo;

    public Output() {
    }

    public Output(String orderNo, String time, String date, String additionalComment, String additionalNotes, String cardCVV,
                  String cardExpiryDate, String cardNumber, String city, String email, String fuelType,
                  String fullName, String phone, String pincode, String serviceAmount, String state,
                  String streetAddress, String vehicleModel, String vehicleRegNo) {
        this.orderNo = orderNo;
        this.time = time;
        this.date = date; // Initialize date
        this.additionalComment = additionalComment;
        this.additionalNotes = additionalNotes;
        this.cardCVV = cardCVV;
        this.cardExpiryDate = cardExpiryDate;
        this.cardNumber = cardNumber;
        this.city = city;
        this.email = email;
        this.fuelType = fuelType;
        this.fullName = fullName;
        this.phone = phone;
        this.pincode = pincode;
        this.serviceAmount = serviceAmount;
        this.state = state;
        this.streetAddress = streetAddress;
        this.vehicleModel = vehicleModel;
        this.vehicleRegNo = vehicleRegNo;
    }

    // Getters and setters
    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date; // Getter for date
    }

    public void setDate(String date) {
        this.date = date; // Setter for date
    }

    public String getAdditionalComment() {
        return additionalComment;
    }

    public void setAdditionalComment(String additionalComment) {
        this.additionalComment = additionalComment;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    public String getCardCVV() {
        return cardCVV;
    }

    public void setCardCVV(String cardCVV) {
        this.cardCVV = cardCVV;
    }

    public String getCardExpiryDate() {
        return cardExpiryDate;
    }

    public void setCardExpiryDate(String cardExpiryDate) {
        this.cardExpiryDate = cardExpiryDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getServiceAmount() {
        return serviceAmount;
    }

    public void setServiceAmount(String serviceAmount) {
        this.serviceAmount = serviceAmount;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleRegNo() {
        return vehicleRegNo;
    }

    public void setVehicleRegNo(String vehicleRegNo) {
        this.vehicleRegNo = vehicleRegNo;
    }
}
