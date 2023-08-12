package dataobjects;

import utils.common.Utilities;
import utils.common.constants.Constant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Partner {
    private String name;
    private String website;
    private String startDate;
    private String expiredDate;
    private String description;
    private String profile;

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
        partner.setName("Name " + Utilities.generateString(5) + " " + sToday);
        partner.setWebsite("https://" + Utilities.generateString(10) + ".com");
        partner.setStartDate(sToday);
        partner.setExpiredDate(sFutureDay);
        partner.setDescription(Utilities.generateString(20));
        partner.setProfile(Constant.PATH_IMG03);
        return partner;
    }

}
