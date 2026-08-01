package io.github.koko0221.mikusleekryouri.datagen;

import io.github.koko0221.mikusleekryouri.block.LeekCropBlock;
import io.github.koko0221.mikusleekryouri.registry.ModBlocks;
import io.github.koko0221.mikusleekryouri.registry.ModItems;
import net.minecraft.advancements.predicates.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import java.util.List;
import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {

    public ModBlockLootTableProvider(HolderLookup.Provider lookupProvider) {
        super(Set.of(), FeatureFlags.DEFAULT_FLAGS, lookupProvider);
    }

    @Override
    protected void generate() {
        LeekCropBlock cropBlock = (LeekCropBlock) ModBlocks.LEEK_CROP.get();

        // 蔥本體：只有長到最大階段才掉；種子：受幸運影響，比照小麥
        this.add(
                cropBlock,
                block -> createCropDrops(
                        block,
                        ModItems.LEEK.get(),
                        ModItems.LEEK_SEEDS.get(),
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(
                                        StatePropertiesPredicate.Builder.properties()
                                                .hasProperty(CropBlock.AGE, cropBlock.getMaxAge())
                                )
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return List.of(ModBlocks.LEEK_CROP.get());
    }
}
