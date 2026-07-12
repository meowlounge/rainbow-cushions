package dev.prodbyeagle.rainbowCushions.mixin.client;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.prodbyeagle.rainbowCushions.client.RainbowCushionsCushionRenderState;
import net.minecraft.client.color.ColorLerper;
import net.minecraft.client.model.Model;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.CushionRenderer;
import net.minecraft.client.renderer.entity.state.CushionRenderState;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.texture.UvMapping;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.decoration.Cushion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CushionRenderer.class)
public abstract class CushionRendererMixin {
    @Unique
    private static final Identifier RAINBOW_CUSHIONS_WHITE_CUSHION_TEXTURE =
            Identifier.withDefaultNamespace("textures/entity/cushion/white_cushion.png");

    @Inject(
            method = "extractRenderState(Lnet/minecraft/world/entity/decoration/Cushion;Lnet/minecraft/client/renderer/entity/state/CushionRenderState;F)V",
            at = @At("TAIL")
    )
    private void rainbowCushions$extractJebCushionState(Cushion cushion, CushionRenderState state, float tickDelta, CallbackInfo ci) {
        RainbowCushionsCushionRenderState rainbowState = (RainbowCushionsCushionRenderState) state;
        boolean isJebCushion = cushion.hasCustomName() && "jeb_".equals(cushion.getName().getString());

        rainbowState.rainbowCushions$setJebCushion(isJebCushion);
        if (isJebCushion) {
            state.texture = RAINBOW_CUSHIONS_WHITE_CUSHION_TEXTURE;
            rainbowState.rainbowCushions$setColor(ColorLerper.getLerpedColor(ColorLerper.Type.SHEEP, cushion.tickCount + tickDelta));
        } else {
            rainbowState.rainbowCushions$setColor(ColorLerper.Type.SHEEP.getColor(cushion.getColor()));
        }
    }

    @Redirect(
            method = "submit(Lnet/minecraft/client/renderer/entity/state/CushionRenderState;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/SubmitNodeCollector;Lnet/minecraft/client/renderer/state/level/CameraRenderState;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/renderer/SubmitNodeCollector;submitModel(Lnet/minecraft/client/model/Model;Ljava/lang/Object;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/rendertype/RenderType;III)V"
            )
    )
    private <S> void rainbowCushions$submitJebCushionModel(
            SubmitNodeCollector collector,
            Model<? super S> model,
            S state,
            PoseStack poseStack,
            RenderType renderType,
            int lightCoords,
            int overlayCoords,
            int outlineColor
    ) {
        if (state instanceof RainbowCushionsCushionRenderState rainbowState && rainbowState.rainbowCushions$isJebCushion()) {
            collector.submitModel(model, state, poseStack, renderType, lightCoords, OverlayTexture.NO_OVERLAY, rainbowState.rainbowCushions$getColor(), (UvMapping) null, outlineColor);
        } else {
            collector.submitModel(model, state, poseStack, renderType, lightCoords, overlayCoords, outlineColor);
        }
    }
}
