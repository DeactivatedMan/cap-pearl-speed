package me.deac.capPearlSpeed;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.EnderPearl;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public final class CapPearlSpeed extends JavaPlugin {

    private double maxSpeed;
    private boolean killPearls;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
        saveConfig();

        maxSpeed = getConfig().getDouble("max-speed");
        killPearls = getConfig().getBoolean("kill-pearl");
        long runEvery = getConfig().getLong("run-every");

        Bukkit.getScheduler().runTaskTimer(this, this::IteratePearls, runEvery, runEvery);
    }

    private void IteratePearls() {
        for (World world : Bukkit.getWorlds()) {
            for (EnderPearl pearl : world.getEntitiesByClass(EnderPearl.class)) {

                Vector velocity = pearl.getVelocity();

                if (velocity.length() > maxSpeed) {
                    getLogger().info("Pearl is speeding! "+ velocity.length());

                    if (killPearls) pearl.remove();
                    else pearl.setVelocity(velocity.normalize().multiply(maxSpeed));
                }

            }
        }
    }
}
