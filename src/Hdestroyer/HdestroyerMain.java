package com.Hdestroyer.plugin;

import com.Hdestroyer.plugin.command.Enclosure;
import com.Hdestroyer.plugin.command.Tool;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.List;

public class HdestroyerMain extends JavaPlugin {

    public static HdestroyerMain Plugin;
    private FileConfiguration config;
    public ItemStack wood;

    @Override
    public void onEnable() {
        Plugin = this;

        File folder = getDataFolder();
        if (!folder.exists()) {
            folder.mkdirs();
        }
        File configFile = new File(folder, "config.yml");
        if (!configFile.exists()) {
            saveResource("config.yml", true);
        }
        configFile = new File(HdestroyerMain.Plugin.getDataFolder(), "config.yml");
        this.config = YamlConfiguration.loadConfiguration(configFile);

        wood = new ItemStack(Material.STICK, 1);
        ItemMeta meta = wood.getItemMeta();
        if (meta != null) {
            meta.setDisplayName("§6界限棒");
            List<String> lore = config.getStringList("Lores");
            for (int i = 0; i < lore.size(); i++) {
                lore.set(i, ChatColor.translateAlternateColorCodes('&', lore.get(i)));
            }
            meta.setLore(lore);
            wood.setItemMeta(meta);
        }
        getServer().getPluginManager().registerEvents(new Enclosure(),this);
        getCommand("Hdestroyer").setExecutor(new Tool());

        getLogger().info("------------------------------------------");
        getLogger().info("__--__--__--§b插件§4已启动__--__--__--__");
        getLogger().info("__________________________________________");
    }

    @Override
    public void onDisable() {
        getLogger().info("§4插件正在卸载");
    }

    @Override
    public FileConfiguration getConfig() {
        return this.config;
    }
}
