package dataobjects;

import utils.common.Utilities;
import utils.common.constants.Constant;

public class Admin {
    private String firstName;
    private String lastName;
    private String userName;
    private String phone;
    private String profile;

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getProfile() {
        return profile;
    }

    public Admin() {}

    public Admin(String firstName, String lastName, String userName, String phone,
                  String profile) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.phone = phone;
        this.profile = profile;
    }

    public static Admin generateRandomAdmin() {
        Admin admin = new Admin();
        admin.setFirstName("First" + Utilities.generateString(10));
        admin.setLastName("Last" + Utilities.generateString(10));
        admin.setUserName(Utilities.generateString(8) + Constant.EMAIL_TAIL);
        admin.setPhone("0" + Utilities.generateNumber(9));
        return admin;
    }
    public static Admin generateRandomAdmin(String profile) {
        Admin admin = generateRandomAdmin();
        admin.setProfile(profile);
        return admin;
    }
    public String getFullName(){return firstName + " " + lastName;}

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
