package utils.enums;



public enum LeftMenu {
    LOGOUT("Logout"),
    PARTNERS("Partners"),
    ACCOUNT("Accounts");

    private String value;

    LeftMenu(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
