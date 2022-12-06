package org.example.password;

public class CorrectFixedPasswordGenerator implements PasswordGenerator {

    @Override
    public String generatePassword() {
        return "abcedfgh"; // 8글자
    }
}
