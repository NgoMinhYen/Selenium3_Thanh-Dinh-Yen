package utils.enums;

public enum UserRole {
    ADMIN("Admin"),
    PARTNER("Partner"),
    MEMBER(" Member");

    private String value;

    UserRole(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
