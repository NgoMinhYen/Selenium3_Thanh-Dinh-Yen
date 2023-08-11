package utils.enums;

public enum UserActions {
    YES("Yes");

    private String value;

    UserActions(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
