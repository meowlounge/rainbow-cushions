package dev.prodbyeagle.rainbowCushions.mixin.client;

import dev.prodbyeagle.rainbowCushions.client.RainbowCushionsCushionRenderState;
import net.minecraft.client.renderer.entity.state.CushionRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(CushionRenderState.class)
public abstract class CushionRenderStateMixin implements RainbowCushionsCushionRenderState {
    @Unique
    private boolean rainbowCushions$jebCushion;

    @Unique
    private int rainbowCushions$color = -1;

    @Override
    public boolean rainbowCushions$isJebCushion() {
        return this.rainbowCushions$jebCushion;
    }

    @Override
    public void rainbowCushions$setJebCushion(boolean jebCushion) {
        this.rainbowCushions$jebCushion = jebCushion;
    }

    @Override
    public int rainbowCushions$getColor() {
        return this.rainbowCushions$color;
    }

    @Override
    public void rainbowCushions$setColor(int color) {
        this.rainbowCushions$color = color;
    }
}
