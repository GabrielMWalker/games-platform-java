package games.platform.models;

import java.util.Date;

public class Game {
    
    private final int id;
    private int publisher_id;
    private final String publisher_name;
    private String name;
    private String description;
    private Date releaseDate;
    private Date expire_date;
    private float price;
    private int price_discount;
    
    public Game(int id, String name, String description, Date releaseDate, float price, int publisher_id, String publisher_name,int price_discount, Date expire_date) {
        this.id = id;
        this.publisher_id = publisher_id;
        this.publisher_name = publisher_name;
        this.name = name;
        this.description = description;
        this.releaseDate = releaseDate;
        this.price = getGameDiscount(price, price_discount);
        this.expire_date = expire_date;
        this.price_discount = price_discount;
        
    }
    
    private float getGameDiscount(float gamePrice, int gameDiscount){
        Integer discount = gameDiscount;
        if(discount != null){
            return gamePrice;
        }
        return gamePrice - (gamePrice * (gameDiscount/100));
    }
    
    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId() {
        return id;
    }
    
    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name the value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the value of description
     *
     * @return the value of description
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Set the value of description
     *
     * @param description the value of description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the value of releaseDate
     *
     * @return the value of releaseDate
     */
    public Date getReleaseDate() {
        return releaseDate;
    }
    
    /**
     * Set the value of releaseDate
     *
     * @param releaseDate the value of releaseDate
     */
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
    
    /**
     * Get the value of price
     *
     * @return the value of price
     */
    public float getPrice() {
        return price;
    }
    
    /**
     * Set the value of price
     *
     * @param price the value of price
     */
    public void setPrice(float price) {
        this.price = price;
    }
    
    /**
     * Get the value of publisher_id
     *
     * @return the value of publisher_id
     */
    public int getPublisherId() {
        return publisher_id;
    }
    
    /**
     * Set the value of publisherId
     *
     * @param publisher_id the value of publisherId
     */
    public void setPublisherId(int publisher_id) {
        this.publisher_id = publisher_id;
    }
    
    /**
     * Get the value of publisher_name
     *
     * @return the value of publisher_name
     */
    public String getPublisherName() {
        return publisher_name;
    }

    public Date getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(Date expire_date) {
        this.expire_date = expire_date;
    }

    public float getPrice_discount() {
        return price_discount;
    }

    public void setPrice_discount(int price_discount) {
        this.price_discount = price_discount;
    }   
    
}
