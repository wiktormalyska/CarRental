package org.example.users;

import org.example.Vehicle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class User {
    private final String username;
    private final byte[] password;

    public String getUsername() {
        return username;
    }

    public byte[] getPassword() {
        return password;
    }

    public String getUserType() {
        return "null";
    }

    public User(String username, byte[] password){
        this.username = username;
        this.password = password;
    }
    @Override
    public String toString(){
        return "Username: " + username + ", Password: " + password + ", User Type: " + getUserType();
    }
    public String toCSV(){
        return getUserType() + "," + username + "," + password;
    }


}
