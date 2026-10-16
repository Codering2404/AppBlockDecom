package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
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
public final class ButtonElevation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f16092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f16093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f16094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f16095d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f16096e;

    public /* synthetic */ ButtonElevation(float f3, float f4, float f5, float f6, float f7, DefaultConstructorMarker defaultConstructorMarker) {
        this(f3, f4, f5, f6, f7);
    }

    private final State d(boolean z2, InteractionSource interactionSource, Composer composer, int i3) {
        Animatable animatable;
        if (ComposerKt.M()) {
            ComposerKt.U(-1312510462, i3, -1, "androidx.compose.material3.ButtonElevation.animateElevation (Button.kt:938)");
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
            objG2 = new ButtonElevation$animateElevation$1$1(interactionSource, snapshotStateList, null);
            composer.w(objG2);
        }
        EffectsKt.g(interactionSource, (Function2) objG2, composer, (i3 >> 3) & 14);
        Interaction interaction = (Interaction) CollectionsKt.lastOrNull((List) snapshotStateList);
        float f3 = !z2 ? this.f16096e : interaction instanceof PressInteraction.Press ? this.f16093b : interaction instanceof HoverInteraction.Enter ? this.f16095d : interaction instanceof FocusInteraction.Focus ? this.f16094c : this.f16092a;
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
            Object buttonElevation$animateElevation$2$1 = new ButtonElevation$animateElevation$2$1(animatable, f3, z2, this, interaction, null);
            composer.w(buttonElevation$animateElevation$2$1);
            objG4 = buttonElevation$animateElevation$2$1;
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

    public final State e(boolean z2, InteractionSource interactionSource, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-2045116089, i3, -1, "androidx.compose.material3.ButtonElevation.shadowElevation (Button.kt:930)");
        }
        State stateD = d(z2, interactionSource, composer, i3 & 1022);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return stateD;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ButtonElevation)) {
            return false;
        }
        ButtonElevation buttonElevation = (ButtonElevation) obj;
        return Dp.i(this.f16092a, buttonElevation.f16092a) && Dp.i(this.f16093b, buttonElevation.f16093b) && Dp.i(this.f16094c, buttonElevation.f16094c) && Dp.i(this.f16095d, buttonElevation.f16095d) && Dp.i(this.f16096e, buttonElevation.f16096e);
    }

    public int hashCode() {
        return (((((((Dp.j(this.f16092a) * 31) + Dp.j(this.f16093b)) * 31) + Dp.j(this.f16094c)) * 31) + Dp.j(this.f16095d)) * 31) + Dp.j(this.f16096e);
    }

    private ButtonElevation(float f3, float f4, float f5, float f6, float f7) {
        this.f16092a = f3;
        this.f16093b = f4;
        this.f16094c = f5;
        this.f16095d = f6;
        this.f16096e = f7;
    }
}
