package games.platform.models;

import java.util.Date;

public class Buy {

    private final int id;
    private final int client_id;
    private final String client_name;
    private final int game_id;
    private final String game_name;
    private final float game_price;
    private final int publisher_id;
    private final String publisher_name;
    private Date expire_date;
    private int price_discount;
    private double final_price;

    public Buy(int id, int client_id, String client_name, int game_id, String game_name, float game_price, int publisher_id, String publisher_name, double final_price) {
        this.id = id;
        this.client_id = client_id;
        this.client_name = client_name;
        this.game_id = game_id;
        this.game_name = game_name;
        this.game_price = game_price;
        this.publisher_id = publisher_id;
        this.publisher_name = publisher_name;
        this.final_price = final_price;
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
     * Get the value of client id
     *
     * @return the value of client id
     */
    public int getClientId() {
        return client_id;
    }

    /**
     * Get the value of client name
     *
     * @return the value of client name
     */
    public String getClientName() {
        return client_name;
    }

    /**
     * Get the client
     *
     * @return the client
     */
    public Client getClient() {
        return new Client(client_id, client_name, 0);
    }

    /**
     * Get the value of game id
     *
     * @return the value of game id
     */
    public int getGameId() {
        return game_id;
    }

    /**
     * Get the value of game name
     *
     * @return the value of game name
     */
    public String getGameName() {
        return game_name;
    }

    /**
     * Get the value of game price
     *
     * @return the value of game price
     */
    public float getGamePrice() {
        return game_price;
    }

    /**
     * Get the game
     *
     * @return the game
     */
    public Game getGame() {
        return new Game(game_id, game_name, "", null, game_price, publisher_id, publisher_name, price_discount, expire_date, final_price);
    }

    /**
     * Get the value of publisher id
     *
     * @return the value of publisher id
     */
    public int getPublisherId() {
        return publisher_id;
    }

    /**
     * Get the value of publisher name
     *
     * @return the value of publisher name
     */
    public String getPublisherName() {
        return publisher_name;
    }

    public double getFinal_price() {
        return final_price;
    }

    public void setFinal_price(double final_price) {
        this.final_price = final_price;
    }
}
