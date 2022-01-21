package eu.tetemh.bank.events;

import eu.tetemh.bank.PlayersClass;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class OnQuit implements Listener {

    public void onQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();

        PlayersClass.removePlayer(player);
    }

}
