package games.platform.dbModels;

public class Games {

    /**
     * Get the query string to get all games from all publishers
     *
     * @return all games from all publishers
     */
    public static String getGames() {
        return "SELECT g.id, g.name, g.description, g.release_date, g.price, g.publisher_id, p.name as publisher_name, d.price_discount , d.expire_date, "
                + "CASE WHEN d.price_discount > 0 THEN "
                + "ROUND(g.price * (d.price_discount/100), 2) "
                + "ELSE g.price END as final_price "
                + "FROM game as g "
                + "INNER JOIN publisher as p ON (g.publisher_id = p.id) "
                + "LEFT JOIN discount as d ON (d.game_id = g.id and current_date() <= d.expire_date);";
    }

    /**
     * Get the query string to get all games from one publishers
     *
     * @param publisherId publisher id to get the games
     * @return all games from the publisher
     */
    public static String getGames(int publisherId) {
        return getGames().concat(" WHERE publisher.id = " + publisherId);
    }

}
