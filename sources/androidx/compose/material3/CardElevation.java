package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
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
@Metadata
public final class CardElevation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f16180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f16181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f16182c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f16183d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f16184e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f16185f;

    public /* synthetic */ CardElevation(float f3, float f4, float f5, float f6, float f7, float f8, DefaultConstructorMarker defaultConstructorMarker) {
        this(f3, f4, f5, f6, f7, f8);
    }

    private final State e(boolean z2, InteractionSource interactionSource, Composer composer, int i3) {
        Animatable animatable;
        if (ComposerKt.M()) {
            ComposerKt.U(-1421890746, i3, -1, "androidx.compose.material3.CardElevation.animateElevation (Card.kt:670)");
        }
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            objG = SnapshotStateKt.f();
            composer.w(objG);
        }
        SnapshotStateList snapshotStateList = (SnapshotStateList) objG;
        boolean z3 = true;
        boolean z4 = (((i3 & 112) ^ 48) > 32 && composer.Z(interactionSource)) || (i3 & 48) == 32;
        Object objG2 = composer.G();
        if (z4 || objG2 == companion.a()) {
            objG2 = new CardElevation$animateElevation$1$1(interactionSource, snapshotStateList, null);
            composer.w(objG2);
        }
        EffectsKt.g(interactionSource, (Function2) objG2, composer, (i3 >> 3) & 14);
        Interaction interaction = (Interaction) CollectionsKt.lastOrNull((List) snapshotStateList);
        float f3 = !z2 ? this.f16185f : interaction instanceof PressInteraction.Press ? this.f16181b : interaction instanceof HoverInteraction.Enter ? this.f16183d : interaction instanceof FocusInteraction.Focus ? this.f16182c : interaction instanceof DragInteraction.Start ? this.f16184e : this.f16180a;
        Object objG3 = composer.G();
        if (objG3 == companion.a()) {
            Object animatable2 = new Animatable(Dp.d(f3), VectorConvertersKt.e(Dp.f29970b), null, null, 12, null);
            composer.w(animatable2);
            objG3 = animatable2;
        }
        Animatable animatable3 = (Animatable) objG3;
        Dp dpD = Dp.d(f3);
        boolean zI = composer.I(animatable3) | composer.c(f3) | ((((i3 & 14) ^ 6) > 4 && composer.b(z2)) || (i3 & 6) == 4);
        if ((((i3 & 896) ^ 384) <= 256 || !composer.Z(this)) && (i3 & 384) != 256) {
            z3 = false;
        }
        boolean zI2 = zI | z3 | composer.I(interaction);
        Object objG4 = composer.G();
        if (zI2 || objG4 == companion.a()) {
            animatable = animatable3;
            Object cardElevation$animateElevation$2$1 = new CardElevation$animateElevation$2$1(animatable, f3, z2, this, interaction, null);
            composer.w(cardElevation$animateElevation$2$1);
            objG4 = cardElevation$animateElevation$2$1;
        } else {
            animatable = animatable3;
        }
        EffectsKt.g(dpD, (Function2) objG4, composer, 0);
        State stateG = animatable.g();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return stateG;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CardElevation)) {
            return false;
        }
        CardElevation cardElevation = (CardElevation) obj;
        return Dp.i(this.f16180a, cardElevation.f16180a) && Dp.i(this.f16181b, cardElevation.f16181b) && Dp.i(this.f16182c, cardElevation.f16182c) && Dp.i(this.f16183d, cardElevation.f16183d) && Dp.i(this.f16185f, cardElevation.f16185f);
    }

    public final State f(boolean z2, InteractionSource interactionSource, Composer composer, int i3) {
        composer.a0(-1763481333);
        if (ComposerKt.M()) {
            ComposerKt.U(-1763481333, i3, -1, "androidx.compose.material3.CardElevation.shadowElevation (Card.kt:659)");
        }
        composer.a0(-734838460);
        if (interactionSource != null) {
            composer.U();
            State stateE = e(z2, interactionSource, composer, i3 & 1022);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            composer.U();
            return stateE;
        }
        Object objG = composer.G();
        if (objG == Composer.f23746a.a()) {
            objG = SnapshotStateKt__SnapshotStateKt.e(Dp.d(this.f16180a), null, 2, null);
            composer.w(objG);
        }
        MutableState mutableState = (MutableState) objG;
        composer.U();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return mutableState;
    }

    public int hashCode() {
        return (((((((Dp.j(this.f16180a) * 31) + Dp.j(this.f16181b)) * 31) + Dp.j(this.f16182c)) * 31) + Dp.j(this.f16183d)) * 31) + Dp.j(this.f16185f);
    }

    private CardElevation(float f3, float f4, float f5, float f6, float f7, float f8) {
        this.f16180a = f3;
        this.f16181b = f4;
        this.f16182c = f5;
        this.f16183d = f6;
        this.f16184e = f7;
        this.f16185f = f8;
    }
}
