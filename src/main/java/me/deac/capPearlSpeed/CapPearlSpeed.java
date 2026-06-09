package me.deac.capPearlSpeed;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.EnderPearl;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public final class CapPearlSpeed extends JavaPlugin {

    private double maxSpeed;
    private boolean killPearls;
    private boolean devMode;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
        saveConfig();

        maxSpeed = getConfig().getDouble("max-speed");
        killPearls = getConfig().getBoolean("kill-pearl");
        devMode = getConfig().getBoolean("dev-mode");
        long runEvery = getConfig().getLong("run-every");

        Bukkit.getScheduler().runTaskTimer(this, this::IteratePearls, runEvery, runEvery);
    }

    private void IteratePearls() {
        for (World world : Bukkit.getWorlds()) {
            for (EnderPearl pearl : world.getEntitiesByClass(EnderPearl.class)) {

                Vector velocity = pearl.getVelocity();
                if (devMode) getLogger().info("Pearl is at: "+ velocity.length());

                if (velocity.length() > maxSpeed) {

                    if (killPearls) pearl.remove();
                    else pearl.setVelocity(velocity.normalize().multiply(maxSpeed));
                }

            }
        }
    }
}
