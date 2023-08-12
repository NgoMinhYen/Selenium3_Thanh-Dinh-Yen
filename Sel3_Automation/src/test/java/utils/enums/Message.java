package utils.enums;

public enum Message {
    USERNAME_INVALID_FORMAT("Username invalid format"),
    PASSWORD_IS_REQUIRED("Password is required"),
    PASSWORD_CHARACTERS("Password min length 8 characters"),
    USERNAME_IS_REQUIRED("Username is required"),
    NAME_IS_REQUIRED("Name is required"),
    DESCRIPTION_IS_REQUIRED("Description is required"),
    START_DATE_IS_REQUIRED("Start date is required"),
    EXPIRED_DATE_IS_REQUIRED("Expired date is required"),
    FILE_UPLOAD_SUPPORT("File upload support .png/.jpg"),
    DO_YOU_WANT_TO_LOGOUT("Do you want to logout?"),
    ARE_YOU_SURE_DELETE_THIS_PARTNER("Are you sure delete this partner?"),
    CREATED_PARTNER_SUCCESSFULLY("Created Partner successfully"),
    UPDATED_PARTNER_SUCCESSFULLY("Updated Partner successfully"),
    CREATED_ACCOUNT_SUCCESSFULLY("Create account success");

    private String value;

    Message(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
