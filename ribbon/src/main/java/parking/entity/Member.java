package parking.entity;

import java.io.Serializable;
import java.security.SecureRandom;

/**
 * @author Squirrel-Chen
 */
public class Member implements Serializable {

    private static final long serialVersionUID = 5954962153392484505L;
    private int id;
    private String memberName;

    public int getId() {
        return id;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
}
