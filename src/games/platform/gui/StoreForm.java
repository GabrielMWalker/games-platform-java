package games.plataform.gui;

import games.plataform.actions.ClientActions;
import games.plataform.connection.DataBase;
import games.plataform.fitters.ClientsFitter;
import games.plataform.fitters.GamesFitter;
import games.plataform.models.Client;
import games.plataform.models.Game;
import games.plataform.utils.DbGlobal;

import java.sql.SQLException;
import java.util.ArrayList;

public class StoreForm extends javax.swing.JInternalFrame {

    DataBase db;
    
    private ArrayList<Client> clients;
    private ArrayList<Game> games;
    
    private Client selectedClient;
    private Game selectedGame;

    public StoreForm() {
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        try{
            db = DbGlobal.getDb();
            initComponents();
            populateComboBoxes();
        }catch(IllegalStateException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void populateComboBoxes() {
        try {
            this.clients = ClientsFitter.getAllClients(db.getConnection());
            this.clients.forEach((client) -> clientsComboBox.addItem(client.getName()));
            this.games = GamesFitter.getAllGames(db.getConnection());
            this.games.forEach((game) -> gamesComboBox.addItem(game.getName()));
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        clientsComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        gamesComboBox = new javax.swing.JComboBox<>();
        buyGameButton = new javax.swing.JButton();

        setBorder(null);
        setMaximizable(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(850, 509));

        jLabel3.setText("Realizar uma compra:");

        jLabel1.setText("Usuário");

        clientsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientsComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setText("Jogo");

        gamesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gamesComboBoxActionPerformed(evt);
            }
        });

        buyGameButton.setText("Comprar");
        buyGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyGameButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clientsComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gamesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(buyGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gamesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buyGameButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clientsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(377, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clientsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientsComboBoxActionPerformed
        int selectedItem = clientsComboBox.getSelectedIndex();
        this.selectedClient = this.clients.get(selectedItem);
    }//GEN-LAST:event_clientsComboBoxActionPerformed

    private void gamesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gamesComboBoxActionPerformed
        int selectedItem = gamesComboBox.getSelectedIndex();
        this.selectedGame = this.games.get(selectedItem);
    }//GEN-LAST:event_gamesComboBoxActionPerformed

    private void buyGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyGameButtonActionPerformed
        buyGameButton.setEnabled(false);
        ClientActions.buyOneGame(selectedClient, selectedGame, db.getConnection());
        buyGameButton.setEnabled(true);
    }//GEN-LAST:event_buyGameButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buyGameButton;
    private javax.swing.JComboBox<String> clientsComboBox;
    private javax.swing.JComboBox<String> gamesComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}