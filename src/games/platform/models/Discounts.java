package games.platform.models;

import java.util.Date;

public class Discounts {

    private int id;
    private int game_id;
    private float price_discount;
    private Date expire_date;

    public Discounts(int id, int game_id, float price_discount, Date expire_date) {
        this.id = id;
        this.game_id = game_id;
        this.price_discount = price_discount;
        this.expire_date = expire_date;
    }

    public int getId() {
        return id;
    }

    public int getGame_id() {
        return game_id;
    }

    public float getPrice_discount() {
        return price_discount;
    }

    public Date getExpire_date() {
        return expire_date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public void setPrice_discount(float price_discount) {
        this.price_discount = price_discount;
    }

    public void setExpire_date(Date expire_date) {
        this.expire_date = expire_date;
    }

}
