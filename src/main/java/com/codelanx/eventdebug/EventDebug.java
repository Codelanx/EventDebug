/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelanx.eventdebug;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import org.bukkit.ChatColor;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.event.Event;
import org.bukkit.event.EventException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.block.BlockEvent;
import org.bukkit.event.block.BlockExpEvent;
import org.bukkit.event.block.BlockFadeEvent;
import org.bukkit.event.block.BlockFormEvent;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.BlockPistonEvent;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.event.block.EntityBlockFormEvent;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.block.NotePlayEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreeperPowerEvent;
import org.bukkit.event.entity.EntityBreakDoorEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityCombustByBlockEvent;
import org.bukkit.event.entity.EntityCombustByEntityEvent;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.entity.EntityCreatePortalEvent;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.entity.EntityPortalEnterEvent;
import org.bukkit.event.entity.EntityPortalEvent;
import org.bukkit.event.entity.EntityPortalExitEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.EntityTameEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.entity.EntityTeleportEvent;
import org.bukkit.event.entity.EntityUnleashEvent;
import org.bukkit.event.entity.ExpBottleEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.HorseJumpEvent;
import org.bukkit.event.entity.ItemDespawnEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.entity.PigZapEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.PlayerLeashEntityEvent;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.entity.SheepDyeWoolEvent;
import org.bukkit.event.entity.SheepRegrowWoolEvent;
import org.bukkit.event.entity.SlimeSplitEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.hanging.HangingBreakEvent;
import org.bukkit.event.hanging.HangingEvent;
import org.bukkit.event.hanging.HangingPlaceEvent;
import org.bukkit.event.inventory.BrewEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.event.inventory.FurnaceExtractEvent;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryCreativeEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.painting.PaintingBreakByEntityEvent;
import org.bukkit.event.painting.PaintingBreakEvent;
import org.bukkit.event.painting.PaintingEvent;
import org.bukkit.event.painting.PaintingPlaceEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerChannelEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerChatTabCompleteEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerInventoryEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerPreLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRegisterChannelEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerShearEntityEvent;
import org.bukkit.event.player.PlayerStatisticIncrementEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;
import org.bukkit.event.player.PlayerUnleashEntityEvent;
import org.bukkit.event.player.PlayerUnregisterChannelEvent;
import org.bukkit.event.player.PlayerVelocityEvent;
import org.bukkit.event.server.MapInitializeEvent;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.event.server.RemoteServerCommandEvent;
import org.bukkit.event.server.ServerCommandEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.event.server.ServiceEvent;
import org.bukkit.event.server.ServiceRegisterEvent;
import org.bukkit.event.server.ServiceUnregisterEvent;
import org.bukkit.event.vehicle.VehicleBlockCollisionEvent;
import org.bukkit.event.vehicle.VehicleCollisionEvent;
import org.bukkit.event.vehicle.VehicleCreateEvent;
import org.bukkit.event.vehicle.VehicleDamageEvent;
import org.bukkit.event.vehicle.VehicleDestroyEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.event.vehicle.VehicleEntityCollisionEvent;
import org.bukkit.event.vehicle.VehicleEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.event.vehicle.VehicleMoveEvent;
import org.bukkit.event.vehicle.VehicleUpdateEvent;
import org.bukkit.event.weather.LightningStrikeEvent;
import org.bukkit.event.weather.ThunderChangeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.weather.WeatherEvent;
import org.bukkit.event.world.ChunkEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.event.world.ChunkPopulateEvent;
import org.bukkit.event.world.ChunkUnloadEvent;
import org.bukkit.event.world.PortalCreateEvent;
import org.bukkit.event.world.SpawnChangeEvent;
import org.bukkit.event.world.StructureGrowEvent;
import org.bukkit.event.world.WorldEvent;
import org.bukkit.event.world.WorldInitEvent;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.event.world.WorldSaveEvent;
import org.bukkit.event.world.WorldUnloadEvent;
import org.bukkit.plugin.EventExecutor;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Class description for {@link EventDebug}
 *
 * @since 1.0.0
 * @author 1Rogue
 * @version 1.0.0
 */
public class EventDebug extends JavaPlugin implements Listener {
    
    private boolean enabled = true;
    @SuppressWarnings("rawtypes")
    public static final Set<Class<? extends Event>> EVENTS = Collections.unmodifiableSet(new HashSet(Arrays.asList( //fuck you java generics
        AsyncPlayerChatEvent.class,
        AsyncPlayerPreLoginEvent.class,
        BlockBreakEvent.class,
        BlockBurnEvent.class,
        BlockCanBuildEvent.class,
        BlockDamageEvent.class,
        BlockDispenseEvent.class,
        BlockExpEvent.class,
        BlockFormEvent.class,
        BlockFadeEvent.class,
        BlockFromToEvent.class,
        BlockGrowEvent.class,
        BlockIgniteEvent.class,
        BlockPhysicsEvent.class,
        BlockPistonEvent.class,
        BlockPistonExtendEvent.class,
        BlockPistonRetractEvent.class,
        BlockPlaceEvent.class,
        BlockRedstoneEvent.class,
        BlockSpreadEvent.class,
        BrewEvent.class,
        ChunkEvent.class,
        ChunkLoadEvent.class,
        ChunkPopulateEvent.class,
        ChunkUnloadEvent.class,
        ConversationAbandonedEvent.class,
        CraftItemEvent.class,
        CreatureSpawnEvent.class,
        CreeperPowerEvent.class,
        EnchantItemEvent.class,
        EntityBlockFormEvent.class,
        EntityBreakDoorEvent.class,
        EntityChangeBlockEvent.class,
        EntityCombustByBlockEvent.class,
        EntityCombustByEntityEvent.class,
        EntityCombustEvent.class,
        EntityCreatePortalEvent.class,
        EntityDamageByBlockEvent.class,
        EntityDamageByEntityEvent.class,
        EntityDamageEvent.class,
        EntityDeathEvent.class,
        EntityExplodeEvent.class,
        EntityInteractEvent.class,
        EntityPortalEnterEvent.class,
        EntityPortalEvent.class,
        EntityPortalExitEvent.class,
        EntityRegainHealthEvent.class,
        EntityShootBowEvent.class,
        EntityTameEvent.class,
        EntityTargetEvent.class,
        EntityTargetLivingEntityEvent.class,
        EntityTeleportEvent.class,
        EntityUnleashEvent.class,
        EventException.class,
        EventExecutor.class,
        ExpBottleEvent.class,
        ExplosionPrimeEvent.class,
        FoodLevelChangeEvent.class,
        FurnaceBurnEvent.class,
        FurnaceExtractEvent.class,
        FurnaceSmeltEvent.class,
        HangingBreakByEntityEvent.class,
        HangingBreakEvent.class,
        HangingEvent.class,
        HangingPlaceEvent.class,
        HorseJumpEvent.class,
        InventoryClickEvent.class,
        InventoryCloseEvent.class,
        InventoryCreativeEvent.class,
        InventoryDragEvent.class,
        InventoryInteractEvent.class,
        InventoryMoveItemEvent.class,
        InventoryOpenEvent.class,
        InventoryPickupItemEvent.class,
        ItemDespawnEvent.class,
        ItemSpawnEvent.class,
        LeavesDecayEvent.class,
        LightningStrikeEvent.class,
        MapInitializeEvent.class,
        NotePlayEvent.class,
        PaintingBreakByEntityEvent.class,
        PaintingBreakEvent.class,
        PaintingEvent.class,
        PaintingPlaceEvent.class,
        PigZapEvent.class,
        PlayerAchievementAwardedEvent.class,
        PlayerAnimationEvent.class,
        PlayerBedEnterEvent.class,
        PlayerBedLeaveEvent.class,
        PlayerBucketEmptyEvent.class,
        PlayerBucketEvent.class,
        PlayerBucketFillEvent.class,
        PlayerChangedWorldEvent.class,
        PlayerChannelEvent.class,
        PlayerChatEvent.class,
        PlayerChatTabCompleteEvent.class,
        PlayerCommandPreprocessEvent.class,
        PlayerDeathEvent.class,
        PlayerDropItemEvent.class,
        PlayerEditBookEvent.class,
        PlayerEggThrowEvent.class,
        PlayerExpChangeEvent.class,
        PlayerFishEvent.class,
        PlayerGameModeChangeEvent.class,
        PlayerInteractAtEntityEvent.class,
        PlayerInteractEntityEvent.class,
        PlayerInteractEvent.class,
        PlayerInventoryEvent.class,
        PlayerItemBreakEvent.class,
        PlayerItemConsumeEvent.class,
        PlayerItemHeldEvent.class,
        PlayerJoinEvent.class,
        PlayerKickEvent.class,
        PlayerLeashEntityEvent.class,
        PlayerLevelChangeEvent.class,
        PlayerLoginEvent.class,
        PlayerMoveEvent.class,
        PlayerPickupItemEvent.class,
        PlayerPortalEvent.class,
        PlayerPreLoginEvent.class,
        PlayerQuitEvent.class,
        PlayerRegisterChannelEvent.class,
        PlayerRespawnEvent.class,
        PlayerShearEntityEvent.class,
        PlayerStatisticIncrementEvent.class,
        PlayerTeleportEvent.class,
        PlayerToggleFlightEvent.class,
        PlayerToggleSneakEvent.class,
        PlayerToggleSprintEvent.class,
        PlayerUnleashEntityEvent.class,
        PlayerUnregisterChannelEvent.class,
        PlayerVelocityEvent.class,
        PluginDisableEvent.class,
        PluginEnableEvent.class,
        PortalCreateEvent.class,
        PotionSplashEvent.class,
        PrepareItemCraftEvent.class,
        PrepareItemEnchantEvent.class,
        ProjectileHitEvent.class,
        ProjectileLaunchEvent.class,
        RemoteServerCommandEvent.class,
        ServerCommandEvent.class,
        ServerListPingEvent.class,
        ServiceEvent.class,
        ServiceRegisterEvent.class,
        ServiceUnregisterEvent.class,
        SheepDyeWoolEvent.class,
        SheepRegrowWoolEvent.class,
        SignChangeEvent.class,
        SlimeSplitEvent.class,
        SpawnChangeEvent.class,
        StructureGrowEvent.class,
        ThunderChangeEvent.class,
        VehicleBlockCollisionEvent.class,
        VehicleCollisionEvent.class,
        VehicleCreateEvent.class,
        VehicleDamageEvent.class,
        VehicleDestroyEvent.class,
        VehicleEnterEvent.class,
        VehicleEntityCollisionEvent.class,
        VehicleEvent.class,
        VehicleExitEvent.class,
        VehicleMoveEvent.class,
        VehicleUpdateEvent.class,
        WeatherChangeEvent.class,
        WeatherEvent.class,
        WorldInitEvent.class,
        WorldLoadEvent.class,
        WorldSaveEvent.class,
        WorldUnloadEvent.class
    )));
    private static final String TAB = "\n    ";
    private static final Map<Predicate<Event>, BiFunction<Event, StringBuilder, StringBuilder>> FORMATTER = Collections.unmodifiableMap(new HashMap<Predicate<Event>, BiFunction<Event, StringBuilder, StringBuilder>>() {{
        put(e -> e instanceof PlayerEvent, (e, sb) -> sb.append(ChatColor.YELLOW));
        put(e -> true, (e, sb) -> sb.append("Fired: ").append(e.getEventName()));
        EventDebug.putIfInstance(PlayerEvent.class, this, "Player", PlayerEvent::getPlayer);
        EventDebug.putIfInstance(BlockEvent.class, this, "Block", BlockEvent::getBlock);
        EventDebug.putIfInstance(WorldEvent.class, this, "World", WorldEvent::getWorld);
    }});
    
    @Override
    public void onEnable() {
        this.enabled = this.getConfig().getBoolean("enabled", true);
        EVENTS.stream().map(this::getDebugger).forEach(this::register);
    }
    
    private void register(Listener t) {
        this.getServer().getPluginManager().registerEvents(t, this);
    }
    
    public <T extends Event> Listener getDebugger(Class<T> e) {
        return new Listener() {
            
            @EventHandler(priority = EventPriority.MONITOR)
            public void onEvent(T event) {
                String message = EventDebug.makeTags(event);
                this.printPlayer(event, message);
                this.printConsole(event, message);
            }

            public void printPlayer(T event, String message) {
                if (!(event instanceof PlayerEvent)) {
                    return;
                }
                ((PlayerEvent) event).getPlayer().sendMessage(message);
            }
            
            public void printConsole(T event, String message) {
                EventDebug.this.getLogger().info(message);
            }
            
        };
    }
    
    private static <T extends Event> void putIfInstance(Class<T> clazz, Map<? extends Predicate<? extends Event>, ? extends BiFunction<? extends Event, ? extends StringBuilder, ? extends StringBuilder>> map, String prefix, Function<T, ?> mapper) {
        Predicate<Event> key = e -> clazz.isAssignableFrom(e.getClass());
        BiFunction<Event, StringBuilder, StringBuilder> val = (e, sb) -> sb.append(TAB).append(prefix).append(": ").append(mapper.apply(clazz.cast(e)));
        ((Map<Predicate<Event>, BiFunction<Event, StringBuilder, StringBuilder>>) map).put(key, val);
    }
    
    private static <T extends Event> void putIfInstance(Class<T> clazz, Map<Predicate<Event>, BiFunction<Event, StringBuilder, StringBuilder>> map, String prefix, Supplier<?> mapper) {
        EventDebug.putIfInstance(clazz, map, prefix, e -> mapper.get());
    }
    
    public static <T extends Event> String makeTags(T event) {
        StringBuilder sb = new StringBuilder();
        FORMATTER.entrySet().stream()
                .filter(ent -> ent.getKey().test(event))
                .forEach(ent -> ent.getValue().apply(event, sb));
        return sb.toString();
    }

}
