package androidx.compose.material.ripple;

import android.view.View;
import android.view.ViewGroup;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class PlatformRipple extends Ripple {
    public /* synthetic */ PlatformRipple(boolean z2, float f3, State state, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, f3, state);
    }

    @Override // androidx.compose.material.ripple.Ripple
    public RippleIndicationInstance c(InteractionSource interactionSource, boolean z2, float f3, State state, State state2, Composer composer, int i3) {
        composer.a0(331259447);
        if (ComposerKt.M()) {
            ComposerKt.U(331259447, i3, -1, "androidx.compose.material.ripple.PlatformRipple.rememberUpdatedRippleInstance (Ripple.android.kt:92)");
        }
        ViewGroup viewGroupE = Ripple_androidKt.e((View) composer.q(AndroidCompositionLocals_androidKt.j()));
        boolean Z = ((((i3 & 14) ^ 6) > 4 && composer.Z(interactionSource)) || (i3 & 6) == 4) | ((((458752 & i3) ^ 196608) > 131072 && composer.Z(this)) || (i3 & 196608) == 131072) | composer.Z(viewGroupE);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            Object androidRippleIndicationInstance = new AndroidRippleIndicationInstance(z2, f3, state, state2, viewGroupE, null);
            composer.w(androidRippleIndicationInstance);
            objG = androidRippleIndicationInstance;
        }
        AndroidRippleIndicationInstance androidRippleIndicationInstance2 = (AndroidRippleIndicationInstance) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return androidRippleIndicationInstance2;
    }

    private PlatformRipple(boolean z2, float f3, State state) {
        super(z2, f3, state, null);
    }
}
