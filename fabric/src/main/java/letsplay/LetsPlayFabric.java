package letsplay;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;

public class LetsPlayFabric implements ModInitializer {

	@Override
	public void onInitialize() {
		LetsPlay.init();
		ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> LetsPlay.onPlayerJoin(server));
		ServerPlayConnectionEvents.DISCONNECT.register((handler, server) -> LetsPlay.onPlayerQuit(server));
	}
}
