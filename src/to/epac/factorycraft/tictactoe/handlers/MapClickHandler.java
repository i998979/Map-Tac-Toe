package to.epac.factorycraft.tictactoe.handlers;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Hanging;
import org.bukkit.entity.ItemFrame;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.hanging.HangingBreakEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import to.epac.factorycraft.tictactoe.TicTacToe;
import to.epac.factorycraft.tictactoe.tictactoe.Game;
import to.epac.factorycraft.tictactoe.utils.Utils;

public class MapClickHandler implements Listener {
	
	private TicTacToe plugin = TicTacToe.inst();
	
	@EventHandler
	public void cellClick(PlayerInteractEntityEvent event) {
		Entity entity = event.getRightClicked();
		Location loc = entity.getLocation();
		
		if(entity instanceof ItemFrame) {
			for (Game game : plugin.getGameManager().getGames()) {
				if (Utils.locContains(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ(),
						game.getBottom(), game.getTop())) {
					event.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler
	public void onHangingBreak(HangingBreakEvent event) {
		Hanging entity = event.getEntity();
		Location loc = entity.getLocation();
		
		if (entity instanceof ItemFrame) {
			for (Game game : plugin.getGameManager().getGames()) {
				if (Utils.locContains(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ(),
						game.getBottom(), game.getTop())) {
					event.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler
	public void onFrameDamage(EntityDamageEvent event) {
		Entity entity = event.getEntity();
		Location loc = entity.getLocation();
		
		if (entity instanceof ItemFrame) {
			for (Game game : plugin.getGameManager().getGames()) {
				if (Utils.locContains(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ(),
						game.getBottom(), game.getTop())) {
					event.setCancelled(true);
				}
			}
		}
	}
}
