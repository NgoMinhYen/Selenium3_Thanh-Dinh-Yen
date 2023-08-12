package utils.enums;

public enum EntityFields {
    EXPIRED_DATE("expiredDate"),
    START_DATE("subscriptionDate"),
    USER_PROFILE("User Profile"),
    INVITE_NEW_PARTNER("Invite New Partner"),
    WELCOME_TO_VOUCHER_PARADISE("Welcome to Voucher Paradise"),
    PHONE("Phone"),
    FIRST_NAME("First name");

    private String value;

    EntityFields(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
