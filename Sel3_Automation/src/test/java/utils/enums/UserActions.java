package utils.enums;

public enum UserActions {
    YES("Yes"),
    SAVE("Save"),
    ENTER_NAME("Enter Name"),
    ENTER_WEBSITE("Enter Website"),
    ADD_PARTNER("Add Partner");

    private String value;

    UserActions(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
