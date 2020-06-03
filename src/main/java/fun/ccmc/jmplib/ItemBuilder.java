package fun.ccmc.jmplib;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *     Builder style class for ItemStacks
 * </p>
 *
 * @author jmp
 */
public class ItemBuilder {
    private final ItemStack itemStack;
    private final ItemMeta itemMeta;

    /**
     * ItemBuilder constructor from {@link Material}
     *
     * @param material the {@link Material} to use
     */
    public ItemBuilder(Material material) {
        this.itemStack = new ItemStack(material);
        this.itemMeta = itemStack.getItemMeta();
    }

    /**
     * ItemBuilder constructor from {@link ItemStack}
     *
     * @param itemStack the {@link ItemStack} to use
     */
    public ItemBuilder(ItemStack itemStack) {
        this.itemStack = itemStack;
        this.itemMeta = itemStack.getItemMeta();
    }

    /**
     * ItemBuilder constructor from base64 Player Head URL
     *
     * @param base64 the {@link String} containing the base64 URL
     */
    public ItemBuilder(String base64) {
        this.itemStack = SkullCreator.itemFromBase64(base64);
        this.itemMeta = itemStack.getItemMeta();
    }

    /**
     * Set the Display Name of the ItemStack
     *
     * @param displayName The display name to use. Will be colorized using the {@literal &} color code
     * @return The ItemBuilder instance
     */
    public ItemBuilder setName(String displayName) {
        itemMeta.setDisplayName(TextUtil.colorize(displayName));
        return this;
    }

    /**
     * Set the lore of the ItemStack from one or multiple strings
     *
     * @param lore The String(s) to use for lore. Will be colorized using the {@literal &} color code
     * @return The ItemBuilder instance
     */
    public ItemBuilder setLore(String... lore) {
        itemMeta.setLore(TextUtil.colorize(Arrays.stream(lore).collect(Collectors.toList())));
        return this;
    }

    /**
     * Set the lore of the ItemStack from a List of Strings
     *
     * @param lore The {@link List} of {@link String} to use as lore. Will be colorized using the {@literal &} color code
     * @return The ItemBuilder instance
     */
    public ItemBuilder setLore(List<String> lore) {
        itemMeta.setLore(TextUtil.colorize(lore));
        return this;
    }

    /**
     * Clear the lore of the ItemStack by setting it to an empty {@link ArrayList}
     *
     * @return The ItemBuilder instance
     */
    public ItemBuilder clearLore() {
        itemMeta.setLore(new ArrayList<>());
        return this;
    }

    /**
     * Build the ItemStack created by this ItemBuilder instance
     *
     * @return The built {@link ItemStack}
     */
    public ItemStack build() {
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
