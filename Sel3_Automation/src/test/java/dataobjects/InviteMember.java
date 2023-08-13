package dataobjects;

import lombok.Getter;
import lombok.Setter;
import utils.common.Utilities;
import utils.common.constants.Constant;

@Getter
@Setter
public class InviteMember {
    private String firstName;
    private String lastName;
    private String userName;
    private String birthday;
    private String profile;
    private String phone;
    private String address;

    public InviteMember() {}

    public InviteMember(String firstName, String lastName, String userName, String birthday,
                        String profile, String phone, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.birthday = birthday;
        this.profile = profile;
        this.birthday = phone;
        this.profile = address;
    }

    public static InviteMember generateRandomMember() {
        InviteMember inviteMember = new InviteMember();
        inviteMember.setFirstName("First" + Utilities.generateString(4));
        inviteMember.setLastName("Last" + Utilities.generateString(4));
        inviteMember.setUserName(Utilities.generateString(5) + Constant.EMAIL_TAIL);
        inviteMember.setAddress(Utilities.generateString(10));
        inviteMember.setPhone("0" + Utilities.generateNumber(9));
        inviteMember.setBirthday(Utilities.toDate("MM/dd/yyyy"));
        inviteMember.setProfile(Constant.PATH);
        return inviteMember;
    }
    public InviteMember generateRandomMember(String profile) {
        InviteMember inviteMember = generateRandomMember();
        inviteMember.setProfile(profile);
        return inviteMember;
    }

}
