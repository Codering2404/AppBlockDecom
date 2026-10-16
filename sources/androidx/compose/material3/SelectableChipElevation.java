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
public final class SelectableChipElevation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f19809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f19810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f19811c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f19812d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f19813e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f19814f;

    public /* synthetic */ SelectableChipElevation(float f3, float f4, float f5, float f6, float f7, float f8, DefaultConstructorMarker defaultConstructorMarker) {
        this(f3, f4, f5, f6, f7, f8);
    }

    private final State c(boolean z2, InteractionSource interactionSource, Composer composer, int i3) {
        Animatable animatable;
        if (ComposerKt.M()) {
            ComposerKt.U(664514136, i3, -1, "androidx.compose.material3.SelectableChipElevation.animateElevation (Chip.kt:2318)");
        }
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            objG = SnapshotStateKt.f();
            composer.w(objG);
        }
        SnapshotStateList snapshotStateList = (SnapshotStateList) objG;
        Object objG2 = composer.G();
        if (objG2 == companion.a()) {
            objG2 = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
            composer.w(objG2);
        }
        MutableState mutableState = (MutableState) objG2;
        boolean z3 = true;
        boolean z4 = (((i3 & 112) ^ 48) > 32 && composer.Z(interactionSource)) || (i3 & 48) == 32;
        Object objG3 = composer.G();
        if (z4 || objG3 == companion.a()) {
            objG3 = new SelectableChipElevation$animateElevation$1$1(interactionSource, snapshotStateList, null);
            composer.w(objG3);
        }
        EffectsKt.g(interactionSource, (Function2) objG3, composer, (i3 >> 3) & 14);
        Interaction interaction = (Interaction) CollectionsKt.lastOrNull((List) snapshotStateList);
        float f3 = !z2 ? this.f19814f : interaction instanceof PressInteraction.Press ? this.f19810b : interaction instanceof HoverInteraction.Enter ? this.f19812d : interaction instanceof FocusInteraction.Focus ? this.f19811c : interaction instanceof DragInteraction.Start ? this.f19813e : this.f19809a;
        Object objG4 = composer.G();
        if (objG4 == companion.a()) {
            Object animatable2 = new Animatable(Dp.d(f3), VectorConvertersKt.e(Dp.f29970b), null, null, 12, null);
            composer.w(animatable2);
            objG4 = animatable2;
        }
        Animatable animatable3 = (Animatable) objG4;
        Dp dpD = Dp.d(f3);
        boolean zI = composer.I(animatable3) | composer.c(f3);
        if ((((i3 & 14) ^ 6) <= 4 || !composer.b(z2)) && (i3 & 6) != 4) {
            z3 = false;
        }
        boolean zI2 = zI | z3 | composer.I(interaction);
        Object objG5 = composer.G();
        if (zI2 || objG5 == companion.a()) {
            animatable = animatable3;
            Object selectableChipElevation$animateElevation$2$1 = new SelectableChipElevation$animateElevation$2$1(animatable, f3, z2, interaction, mutableState, null);
            composer.w(selectableChipElevation$animateElevation$2$1);
            objG5 = selectableChipElevation$animateElevation$2$1;
        } else {
            animatable = animatable3;
        }
        EffectsKt.g(dpD, (Function2) objG5, composer, 0);
        State stateG = animatable.g();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return stateG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Interaction d(MutableState mutableState) {
        return (Interaction) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(MutableState mutableState, Interaction interaction) {
        mutableState.setValue(interaction);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SelectableChipElevation)) {
            return false;
        }
        SelectableChipElevation selectableChipElevation = (SelectableChipElevation) obj;
        return Dp.i(this.f19809a, selectableChipElevation.f19809a) && Dp.i(this.f19810b, selectableChipElevation.f19810b) && Dp.i(this.f19811c, selectableChipElevation.f19811c) && Dp.i(this.f19812d, selectableChipElevation.f19812d) && Dp.i(this.f19814f, selectableChipElevation.f19814f);
    }

    public final State f(boolean z2, InteractionSource interactionSource, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1888175651, i3, -1, "androidx.compose.material3.SelectableChipElevation.shadowElevation (Chip.kt:2310)");
        }
        State stateC = c(z2, interactionSource, composer, i3 & 1022);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return stateC;
    }

    public int hashCode() {
        return (((((((Dp.j(this.f19809a) * 31) + Dp.j(this.f19810b)) * 31) + Dp.j(this.f19811c)) * 31) + Dp.j(this.f19812d)) * 31) + Dp.j(this.f19814f);
    }

    private SelectableChipElevation(float f3, float f4, float f5, float f6, float f7, float f8) {
        this.f19809a = f3;
        this.f19810b = f4;
        this.f19811c = f5;
        this.f19812d = f6;
        this.f19813e = f7;
        this.f19814f = f8;
    }
}
