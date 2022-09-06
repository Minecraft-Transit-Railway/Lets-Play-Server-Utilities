package letsplay;

import letsplay.mappings.Utilities;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;

import java.util.HashSet;
import java.util.Set;

public class LetsPlay {

	public static final String MOD_ID = "letsplay";

	public static void init() {

	}

	public static void onPlayerJoin(MinecraftServer server) {
		final CommandSourceStack commandSourceStack = server.createCommandSourceStack();
		runCommand(server, commandSourceStack, "/chunky pause");
	}

	public static void onPlayerQuit(MinecraftServer server, ServerPlayer player) {
		final Set<ServerPlayer> players = new HashSet<>(server.getPlayerList().getPlayers());
		players.remove(player);
		final int playerCount = players.size();

		if (playerCount == 0) {
			final CommandSourceStack commandSourceStack = server.createCommandSourceStack();
			runCommand(server, commandSourceStack, "/chunky continue");
			runCommand(server, commandSourceStack, "/chunky quiet 600");
		} else {
			System.out.println("Server player count: " + playerCount);
		}
	}

	private static void runCommand(MinecraftServer server, CommandSourceStack commandSourceStack, String command) {
		System.out.println("Running command " + command);
		Utilities.sendCommand(server, commandSourceStack, command);
	}
}
