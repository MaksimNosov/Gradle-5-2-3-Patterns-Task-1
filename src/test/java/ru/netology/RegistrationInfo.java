package ru.netology;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class RegistrationInfo {

    private final String name;
    private final String phone;
    private final String cardNumber;


//    public RegistrationInfo(String name, String phone, String cardNumber) {
//        this.name = name;
//        this.phone = phone;
//        this.cardNumber = cardNumber;
//    }

//    public String getName() {
//        return name;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public String getCardNumber() {
//        return cardNumber;
//    }
}
