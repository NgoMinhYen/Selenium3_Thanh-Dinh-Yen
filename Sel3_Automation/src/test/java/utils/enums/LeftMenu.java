package utils.enums;



public enum LeftMenu {
    ADMIN("Admin"),
    PIM("PIM"),
    LEAVE("Leave"),
    TIME("Time"),
    RECRUITMENT("Recruitment"),
    MY_INFO("My Info"),
    PERFORMANCE("Performance"),
    DASHBOARD("Dashboard"),
    DIRECTORY("Directory"),
    MAINTENANCE("Maintenance"),
    BUZZ("Buzz");

    private String value;

    LeftMenu(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
