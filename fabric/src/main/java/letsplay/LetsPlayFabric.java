package letsplay;

import net.fabricmc.api.ModInitializer;

public class LetsPlayFabric implements ModInitializer {

	@Override
	public void onInitialize() {
		LetsPlay.init();
	}
}
