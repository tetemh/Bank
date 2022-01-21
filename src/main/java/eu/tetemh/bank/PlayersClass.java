package eu.tetemh.bank;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class PlayersClass {

    private static final ArrayList<Player> playersInfos = new ArrayList();

    public static ArrayList getAllPlayersInfos(){
        return playersInfos;
    }

    public static void addPlayer(Player player) {
        playersInfos.add(player);
    }

    public static void removePlayer(Player player){
        playersInfos.remove(player);
    }
}
