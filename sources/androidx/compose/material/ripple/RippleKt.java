package androidx.compose.material.ripple;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.unit.Dp;
import com.applovin.impl.mediation.nativeAds.xNe.qRMDmh;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class RippleKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final TweenSpec f15404a = new TweenSpec(15, 0, EasingKt.e(), 2, null);

    public static final DelegatableNode c(InteractionSource interactionSource, boolean z2, float f3, ColorProducer colorProducer, Function0 function0) {
        return Ripple_androidKt.d(interactionSource, z2, f3, colorProducer, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnimationSpec d(Interaction interaction) {
        return interaction instanceof HoverInteraction.Enter ? f15404a : interaction instanceof FocusInteraction.Focus ? new TweenSpec(45, 0, EasingKt.e(), 2, null) : interaction instanceof DragInteraction.Start ? new TweenSpec(45, 0, EasingKt.e(), 2, null) : f15404a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnimationSpec e(Interaction interaction) {
        return interaction instanceof HoverInteraction.Enter ? f15404a : interaction instanceof FocusInteraction.Focus ? f15404a : interaction instanceof DragInteraction.Start ? new TweenSpec(150, 0, EasingKt.e(), 2, null) : f15404a;
    }

    public static final Indication f(boolean z2, float f3, long j3, Composer composer, int i3, int i4) {
        boolean z3 = true;
        if ((i4 & 1) != 0) {
            z2 = true;
        }
        if ((i4 & 2) != 0) {
            f3 = Dp.f29970b.c();
        }
        if ((i4 & 4) != 0) {
            j3 = Color.f25715b.k();
        }
        if (ComposerKt.M()) {
            ComposerKt.U(1635163520, i3, -1, qRMDmh.lAfifPJOUhOoE);
        }
        State stateP = SnapshotStateKt.p(Color.n(j3), composer, (i3 >> 6) & 14);
        boolean z4 = (((i3 & 14) ^ 6) > 4 && composer.b(z2)) || (i3 & 6) == 4;
        if ((((i3 & 112) ^ 48) <= 32 || !composer.c(f3)) && (i3 & 48) != 32) {
            z3 = false;
        }
        boolean z5 = z4 | z3;
        Object objG = composer.G();
        if (z5 || objG == Composer.f23746a.a()) {
            objG = new PlatformRipple(z2, f3, stateP, null);
            composer.w(objG);
        }
        PlatformRipple platformRipple = (PlatformRipple) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return platformRipple;
    }
}
