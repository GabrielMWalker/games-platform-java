package games.platform.crud.models;

import games.platform.logger.AppLogger;
import games.platform.utils.LoggerGlobal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Discount {

    /**
     * Create publisher in the database
     *
     * @param discounts publisher to be created
     * @param dbConnection database connection
     * @return message
     */
    public static String createDiscount(games.platform.models.Discounts discounts, Connection dbConnection) {
        try ( PreparedStatement pstmt = dbConnection.prepareStatement("INSERT INTO discount VALUES (null, ?, ?, ?)")) {
            pstmt.setInt(1, discounts.getGame_id());
            pstmt.setDate(2, (Date) discounts.getExpire_date());
            pstmt.setInt(3, discounts.getPrice_discount());

            pstmt.executeUpdate();
            pstmt.close();

            LoggerGlobal.getLogger().addLog(AppLogger.getInfoLevel(), "Desconto Inserido: " + discounts.getId());
            return ("Desconto Inserido");
        } catch (SQLException ex) {
            LoggerGlobal.getLogger().addLog(AppLogger.getSevereLevel(), "Erro em: " + ex.getMessage());
            return ("Erro em: " + ex.getMessage());
        }
    }

    /**
     * Get the query string to get all clients
     *
     * @param discounts publisher with new informations
     * @param dbConnection database connection
     * @return message
     */
    public static String updateDiscount(games.platform.models.Discounts discounts, Connection dbConnection) {
        try ( PreparedStatement pstmt = dbConnection.prepareStatement("UPDATE discount SET game_id = ?, expire_date = ?, price_discount = ? WHERE id = ?")) {
            pstmt.setInt(1, discounts.getGame_id());
            pstmt.setDate(2, (Date) discounts.getExpire_date());
            pstmt.setInt(3, discounts.getPrice_discount());
            pstmt.setInt(4, discounts.getId());

            pstmt.executeUpdate();
            pstmt.close();

            LoggerGlobal.getLogger().addLog(AppLogger.getInfoLevel(), "Desconto Atualizado: " + discounts.getId());
            return ("Desconto Atualizado");
        } catch (SQLException ex) {
            LoggerGlobal.getLogger().addLog(AppLogger.getSevereLevel(), "Erro em: " + ex.getMessage());
            return ("Erro em: " + ex.getMessage());
        }
    }

    /**
     * Remove publisher from the database
     *
     * @param discounts publisher to be removed
     * @param dbConnection database connection
     * @return message
     */
    public static String removeDiscount(games.platform.models.Discounts discounts, Connection dbConnection) {
        try ( PreparedStatement pstmt = dbConnection.prepareStatement("DELETE FROM discount WHERE id = ?")) {
            pstmt.setInt(1, discounts.getId());

            pstmt.executeUpdate();
            pstmt.close();

            LoggerGlobal.getLogger().addLog(AppLogger.getInfoLevel(), "Desconto Removido: " + discounts.getId());
            return ("Desconto Removido");
        } catch (SQLException ex) {
            LoggerGlobal.getLogger().addLog(AppLogger.getSevereLevel(), "Erro em: " + ex.getMessage());
            return ("Erro em: " + ex.getMessage());
        }
    }

}
