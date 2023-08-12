package utils.enums;

public enum UserActions {
    YES("Yes"),
    NO("No"),
    SAVE("Save"),
    CANCEL("Cancel"),
    SEARCH("Search..."),
    EDIT("Edit"),
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
