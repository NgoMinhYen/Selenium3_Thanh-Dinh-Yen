package dataobjects;

import lombok.Getter;
import lombok.Setter;
import utils.common.Utilities;
import utils.common.constants.Constant;
@Getter
@Setter
public class InvitePartner {
    private String firstName;
    private String lastName;
    private String userName;
    private String partner;
    private String profile;

    public InvitePartner() {}

    public InvitePartner(String firstName, String lastName, String userName, String partner,
                         String profile) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.partner = partner;
        this.profile = profile;
    }

    public static InvitePartner generateRandomAdmin() {
        InvitePartner invitePartner = new InvitePartner();
        invitePartner.setFirstName("First" + Utilities.generateString(4));
        invitePartner.setLastName("Last" + Utilities.generateString(4));
        invitePartner.setUserName(Utilities.generateString(5) + Constant.EMAIL_TAIL);
        invitePartner.setProfile(Constant.PATH);
        invitePartner.setPartner("CGV Cinemas");
        return invitePartner;
    }
    public InvitePartner generateRandomAdmin(String profile) {
        InvitePartner invitePartner = generateRandomAdmin();
        invitePartner.setProfile(profile);
        return invitePartner;
    }

}
