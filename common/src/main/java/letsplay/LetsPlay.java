package letsplay;

import letsplay.mappings.Utilities;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.MinecraftServer;

public class LetsPlay {

	public static final String MOD_ID = "letsplay";

	public static void init() {

	}

	public static void onPlayerJoin(MinecraftServer server) {
		final CommandSourceStack commandSourceStack = server.createCommandSourceStack();
		runCommand(server, commandSourceStack, "/chunky pause");
		System.out.println("Server player count: " + server.getPlayerCount());
	}

	public static void onPlayerQuit(MinecraftServer server) {
		final int playerCount = server.getPlayerCount();
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
