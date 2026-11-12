package spawnercontrol.wg.mixin;

import net.minecraft.block.entity.MobSpawnerBlockEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MobSpawnerBlockEntity.class)
public class MobSpawnerLogicMixin {

    @Inject(method = "serverTick", at = @At("HEAD"), cancellable = true)
    private static void cancelUnwantedSpawners(ServerWorld world, BlockPos pos, net.minecraft.block.BlockState state, MobSpawnerBlockEntity blockEntity, CallbackInfo ci) {
        // TODO: Replace with your specific iron farm spawner coordinates!
        // Example: boolean isAllowed = (pos.getX() == 100 && pos.getY() == 64 && pos.getZ() == -200);
        boolean isAllowedSpawner = false; 

        if (!isAllowedSpawner) {
            ci.cancel();
        }
    }
}
