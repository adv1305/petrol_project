package com.petrol.petrol_project.users;

public class Users {
    private String username;

    private String email;
    private long phone;

    public Users(String username, String email,long phone) {
        this.username = username;
        this.email = email;
        this.phone = phone;
    }

    public Users() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }
}
