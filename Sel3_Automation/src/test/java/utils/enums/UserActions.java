package utils.enums;

public enum UserActions {
    YES("Yes"),
    SAVE("Save"),
    CANCEL("Cancel"),
    ENTER_NAME("Enter Name"),
    ENTER_WEBSITE("Enter Website"),
    ENTER_DESCRIPTION("Enter Description"),
    ADD_PARTNER("Add Partner"),
    DELETE_PARTNER("Delete Partner");

    private String value;

    UserActions(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
