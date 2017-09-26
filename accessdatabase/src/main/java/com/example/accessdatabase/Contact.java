package com.example.accessdatabase;

/**
 * Created by admin on 9/25/2017.
 */

public class Contact {
    String firstName, lastName, email, bloodType, favoriteColor;

    public Contact(String firstName, String lastName, String email, String bloodType, String favoriteColor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.bloodType = bloodType;
        this.favoriteColor = favoriteColor;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getFavoriteColor() {
        return favoriteColor;
    }

    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }
}
