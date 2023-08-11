package utils.enums;

public enum Message {
    USERNAME_INVALID_FORMAT("Username invalid format"),
    PASSWORD_IS_REQUIRED("Password is required"),
    PASSWORD_CHARACTERS("Password min length 8 characters"),
    USERNAME_IS_REQUIRED("Username is required"),
    DO_YOU_WANT_TO_LOGOUT("Do you want to logout?");

    private String value;

    Message(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
