package utils.enums;

public enum MyInfoMenu {
    PERSONAL_DETAILS("Personal Details"),
    CONTACT_DETAILS("Contact Details"),
    EMERGENCY_CONTACTS("Emergency Contacts"),
    DEPENDENTS("Dependents"),
    IMMIGRATION("Immigration"),
    JOB("Job"),
    SALARY("Salary"),
    TAX_EXEMPTIONS("Tax Exemptions"),
    REPORT_TO("Report-to"),
    QUALIFICATIONS("Qualifications"),
    MEMBERSHIPS("Memberships");

    private String value;
    MyInfoMenu(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
