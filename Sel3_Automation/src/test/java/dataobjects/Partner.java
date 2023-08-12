package dataobjects;


import utils.common.Utilities;
import utils.common.constants.Constant;

public class Partner {
    private String name;
    private String website;
    private String startDate;
    private String expiredDate;
    private String description;
    private String profile;

    public void setName(String name) {
        this.name = name;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public String getWebsite() {
        return website;
    }


    public String getStartDate() {
        return startDate;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public String getDescription() {
        return description;
    }

    public String getProfile() {
        return profile;
    }

    public Partner() {}

    public Partner(String username, String password, String startDate, String expiredDate, String description, String profile) {
        this.name = username;
        this.website = password;
        this.startDate = startDate;
        this.expiredDate = expiredDate;
        this.description = description;
        this.profile = profile;
    }

    public static Partner generateRandomPartner() {
        String sToday = Utilities.toDate("MM/dd/yyyy");
        String sFutureDay = Utilities.fromDate("MM/dd/yyyy", 3);
        Partner partner = new Partner();
        partner.setName("Name " + sToday);
        partner.setWebsite("https://" + Utilities.generateString(10) + ".com");
        partner.setStartDate(sToday);
        partner.setExpiredDate(sFutureDay);
        partner.setDescription(Utilities.generateString(20));
        partner.setProfile(Constant.PATH_IMG03);
        return partner;
    }

}
