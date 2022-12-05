package org.example.password;

public class User {
    private String password;

    public void initPassword(PasswordGenerator passwordGenerator) { // 낮은 결합
//        RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator(); // 강한 결합
        String password = passwordGenerator.generatePassword();
        /**
         * 비밀번호는 최소 8자 이상 12자 이하여야 한다.
         */
        if(password.length() >= 8 && password.length() <= 12 ) {
            this.password = password;
        }
    }

    public String getPassord() {
        return password;
    }

}
