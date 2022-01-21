package eu.tetemh.bank;

import eu.tetemh.bank.bd.SqlConnection;
import eu.tetemh.bank.events.OnJoin;
import eu.tetemh.bank.tools.Const;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Bank extends JavaPlugin {

    private static Bank instance;
    private static SqlConnection sql;

    @Override
    public void onEnable() {

        System.out.println(Const.PRFIX + "Hello i'm started");
        sql = new SqlConnection("jdbc:mysql://", "loaclhost", "survie_1_18_1", "root", "");
        getSql().connection();

        getServer().getPluginManager().registerEvents(new OnJoin(this), this);
    }

    @Override
    public void onDisable() {
        getSql().disconnect();
    }

    public Bank getInstance(){
        return instance;
    }
    public SqlConnection getSql(){
        return sql;
    }
}
