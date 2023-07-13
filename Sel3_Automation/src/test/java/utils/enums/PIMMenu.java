package utils.enums;

public enum PIMMenu {
    CONFIGURATION("Configuration"),
    EMPLOYEE_LIST("Employee List"),
    ADD_EMPLOYEE("Add Employee"),
    REPORT("Reports");

    private String value;

    PIMMenu(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
