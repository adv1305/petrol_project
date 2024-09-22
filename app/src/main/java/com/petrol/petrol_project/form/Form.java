package com.petrol.petrol_project.form;

public class Form {
    private String fuelType;
    private String fullName;
    private String email;
    private String phone;
    private String vehicleModel;
    private String vehicleRegNo;
    private String serviceAmount;
    private String additionalComment;
    private String streetAddress;
    private String city;
    private String state;
    private String pincode;
    private String cardNumber;
    private String cardExpiryDate;
    private String cardCVV;
    private String additionalNotes;
    private String requestId;
    private String date;
    private String time;

    public Form() {
        // Required empty constructor
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Form(String fuelType, String fullName, String email, String phone, String vehicleModel, String vehicleRegNo, String serviceAmount, String additionalComment, String streetAddress, String city, String state, String pincode, String cardNumber, String cardExpiryDate, String cardCVV, String additionalNotes, String date, String time) {
        this.fuelType = fuelType;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.vehicleModel = vehicleModel;
        this.vehicleRegNo = vehicleRegNo;
        this.serviceAmount = serviceAmount;
        this.additionalComment = additionalComment;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.cardNumber = cardNumber;
        this.cardExpiryDate = cardExpiryDate;
        this.cardCVV = cardCVV;
        this.additionalNotes = additionalNotes;
        this.date = date;
        this.time = time;
    }

    // Getters and setters
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getServiceAmount() {
        return serviceAmount;
    }

    public void setServiceAmount(String serviceAmount) {
        this.serviceAmount = serviceAmount;
    }

    public String getAdditionalComment() {
        return additionalComment;
    }

    public void setAdditionalComment(String additionalComment) {
        this.additionalComment = additionalComment;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardExpiryDate() {
        return cardExpiryDate;
    }

    public void setCardExpiryDate(String cardExpiryDate) {
        this.cardExpiryDate = cardExpiryDate;
    }

    public String getCardCVV() {
        return cardCVV;
    }

    public void setCardCVV(String cardCVV) {
        this.cardCVV = cardCVV;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
