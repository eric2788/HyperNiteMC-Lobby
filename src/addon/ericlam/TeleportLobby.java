package addon.ericlam;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static addon.ericlam.Variable.messagefile;

public class TeleportLobby {
    private static TeleportLobby tplobby;
    private Variable var = new Variable();
    private double X;
    private double Y;
    private double Z;
    private World lobby;


    public static TeleportLobby getInstance() {
        if(tplobby == null) tplobby = new TeleportLobby();
        return tplobby;
    }
    private void getNewSpawn(){
        if (needchangeSpawn()) {
            lobby = Bukkit.getWorld(Variable.lobbyfile.getString("spawntp.world"));
            X = Variable.lobbyfile.getDouble("spawntp.x");
            Y = Variable.lobbyfile.getDouble("spawntp.y");
            Z = Variable.lobbyfile.getDouble("spawntp.z");
        }
    }

    private boolean needchangeSpawn(){
        boolean changeX = X != Variable.lobbyfile.getDouble("spawntp.x");
        boolean changeY = Y != Variable.lobbyfile.getDouble("spawntp.y");
        boolean changeZ = Z != Variable.lobbyfile.getDouble("spawntp.z");
        boolean changeW = lobby != Bukkit.getWorld(Variable.lobbyfile.getString("spawntp.world"));
        return changeX || changeY || changeZ || changeW;
    }

    public boolean TeleportToLobby(Player player){
        getNewSpawn();
        if (lobby == null || Y == 0) {
            player.sendMessage(var.prefix() + ChatColor.RED+ "伺服器尚未設置重生點，因此無法傳送");
            return false;
        }
        Location spawn = new Location(lobby, X, Y, Z);
        player.teleport(spawn);
        return true;
    }
    public void TeleportToLobby(Player player, CommandSender sender){
        getNewSpawn();
        if (lobby == null || Y == 0){
            sender.sendMessage(var.prefix() + ChatColor.RED + "由於重生點尚未設置，因此無法傳送 " + ChatColor.YELLOW + player.getName() + ChatColor.RED + " 。");
            return;
        }
        Location spawn = new Location(lobby, X, Y, Z);
        player.teleport(spawn);
        sender.sendMessage(var.getFs().returnColoredMessage(messagefile, "Commands.spawn.be-send").replace("<player>",player.getName()));
    }
}