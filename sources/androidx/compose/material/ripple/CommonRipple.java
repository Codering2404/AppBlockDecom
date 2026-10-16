package androidx.compose.material.ripple;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import kotlin.Deprecated;
import kotlin.Metadata;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
@Metadata
public final class CommonRipple extends Ripple {
    @Override // androidx.compose.material.ripple.Ripple
    public RippleIndicationInstance c(InteractionSource interactionSource, boolean z2, float f3, State state, State state2, Composer composer, int i3) {
        composer.a0(-1768051227);
        if (ComposerKt.M()) {
            ComposerKt.U(-1768051227, i3, -1, "androidx.compose.material.ripple.CommonRipple.rememberUpdatedRippleInstance (CommonRipple.kt:59)");
        }
        boolean z3 = ((((i3 & 14) ^ 6) > 4 && composer.Z(interactionSource)) || (i3 & 6) == 4) | ((((458752 & i3) ^ 196608) > 131072 && composer.Z(this)) || (i3 & 196608) == 131072);
        Object objG = composer.G();
        if (z3 || objG == Composer.f23746a.a()) {
            CommonRippleIndicationInstance commonRippleIndicationInstance = new CommonRippleIndicationInstance(z2, f3, state, state2, null);
            composer.w(commonRippleIndicationInstance);
            objG = commonRippleIndicationInstance;
        }
        CommonRippleIndicationInstance commonRippleIndicationInstance2 = (CommonRippleIndicationInstance) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return commonRippleIndicationInstance2;
    }
}
