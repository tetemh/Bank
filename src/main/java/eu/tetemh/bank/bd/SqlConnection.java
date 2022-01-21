package eu.tetemh.bank.bd;

import org.bukkit.entity.Player;

import java.sql.*;

public class SqlConnection {

    private Connection connection;
    private String urlbase, host, database, user, pass;

    public SqlConnection(String urlbase, String host, String database, String user, String pass) {
        this.urlbase = urlbase;
        this.host = host;
        this.database = database;
        this.user = user;
        this.pass = pass;
    }

    public Connection getConnection() { return connection; }

    public boolean isConnected() { return connection != null; }

    public void connection() {
        if(!isConnected()) {
            try {
                connection = DriverManager.getConnection(urlbase + host + "/" + database, user, pass);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        System.out.println("BD Connected");
    }

    public void disconnect() {
        if(isConnected()) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void createAccount (Player player) {
        if(!hasAccount(player)) {
            try {
                PreparedStatement p = connection.prepareStatement("INSERT INTO player_data (uuid,player_name) VALUES (?,?)");
                p.setString(1, player.getUniqueId().toString());
                p.setString(2, player.getName());
                p.execute();
                p.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean hasAccount(Player player) {

        try {
            PreparedStatement p = connection.prepareStatement("SELECT uuid FROM player_data WHERE uuid = ?");
            p.setString(1, player.getUniqueId().toString());
            ResultSet result = p.executeQuery();
            boolean hasAccount = result.next();
            p.close();
            return hasAccount;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
