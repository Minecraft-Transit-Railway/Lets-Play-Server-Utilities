package letsplay;

import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;

public class LetsPlayFabric implements DedicatedServerModInitializer {

	@Override
	public void onInitializeServer() {
		LetsPlay.init();
		ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> LetsPlay.onPlayerJoin(server));
		ServerPlayConnectionEvents.DISCONNECT.register((handler, server) -> LetsPlay.onPlayerQuit(server, handler.player));
	}
}
