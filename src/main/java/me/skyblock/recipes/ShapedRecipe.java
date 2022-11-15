package me.skyblock.recipes;

import me.skyblock.items.SItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShapedRecipe {
    private static final List<org.bukkit.inventory.ShapedRecipe> CACHED_RECIPES = new ArrayList<>();

    private final Map<Integer, SItemStack> ingredientMap = new HashMap<>();
    public ShapedRecipe(SItem result, boolean usesExchangables) {

    }
    public void setCraftCoord(int x, SItemStack item) {
        ingredientMap.put(x, item);
    }
    public void setResult(SItemStack result) {
        ingredientMap.put(10, result);
    }
}
