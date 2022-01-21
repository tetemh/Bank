package eu.tetemh.bank.events;

import eu.tetemh.bank.Bank;
import eu.tetemh.bank.PlayersClass;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnJoin implements Listener {

    private static Bank main;

    public OnJoin(Bank bank){
        bank = OnJoin.main;
    }



    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        main.getSql().createAccount(player);
        PlayersClass.addPlayer(player);
        player.sendMessage(PlayersClass.getAllPlayersInfos().toString());
    }
}
