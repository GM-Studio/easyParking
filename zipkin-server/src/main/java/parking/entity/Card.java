package parking.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Squirrel-Chen
 */
public class Card implements Serializable {

    private static final long serialVersionUID = 8935811131708242891L;
    private int card_id;
//    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date card_create_time;
//    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date card_update_time;

    private int member_id;

    @Override
    public String toString() {
        return "Card{" +
                "card_id=" + card_id +
                ", card_create_time=" + card_create_time +
                ", card_update_time=" + card_update_time +
                ", member_id=" + member_id +
                '}';
    }

    public Card(){}


    public Card(int card_id, Date card_create_time, Date card_update_time, int member_id) {
        this.card_id = card_id;
        this.card_create_time = card_create_time;
        this.card_update_time = card_update_time;
        this.member_id=member_id;
    }

    public int getCard_id() {
        return card_id;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }

    public Date getCard_create_time() {
        return card_create_time;
    }

    public void setCard_create_time(Date card_create_time) {
        this.card_create_time = card_create_time;
    }

    public Date getCard_update_time() {
        return card_update_time;
    }

    public void setCard_update_time(Date card_update_time) {
        this.card_update_time = card_update_time;
    }
}
