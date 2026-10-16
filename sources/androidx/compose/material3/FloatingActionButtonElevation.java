package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
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
public class FloatingActionButtonElevation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f17761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f17762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f17763c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f17764d;

    public /* synthetic */ FloatingActionButtonElevation(float f3, float f4, float f5, float f6, DefaultConstructorMarker defaultConstructorMarker) {
        this(f3, f4, f5, f6);
    }

    private final State e(InteractionSource interactionSource, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1845106002, i3, -1, "androidx.compose.material3.FloatingActionButtonElevation.animateElevation (FloatingActionButton.kt:525)");
        }
        int i4 = i3 & 14;
        int i5 = i4 ^ 6;
        boolean z2 = (i5 > 4 && composer.Z(interactionSource)) || (i3 & 6) == 4;
        Object objG = composer.G();
        if (z2 || objG == Composer.f23746a.a()) {
            Object floatingActionButtonElevationAnimatable = new FloatingActionButtonElevationAnimatable(this.f17761a, this.f17762b, this.f17764d, this.f17763c, null);
            composer.w(floatingActionButtonElevationAnimatable);
            objG = floatingActionButtonElevationAnimatable;
        }
        FloatingActionButtonElevationAnimatable floatingActionButtonElevationAnimatable2 = (FloatingActionButtonElevationAnimatable) objG;
        boolean zI = composer.I(floatingActionButtonElevationAnimatable2) | ((((i3 & 112) ^ 48) > 32 && composer.Z(this)) || (i3 & 48) == 32);
        Object objG2 = composer.G();
        if (zI || objG2 == Composer.f23746a.a()) {
            objG2 = new FloatingActionButtonElevation$animateElevation$1$1(floatingActionButtonElevationAnimatable2, this, null);
            composer.w(objG2);
        }
        EffectsKt.g(this, (Function2) objG2, composer, (i3 >> 3) & 14);
        boolean zI2 = composer.I(floatingActionButtonElevationAnimatable2) | ((i5 > 4 && composer.Z(interactionSource)) || (i3 & 6) == 4);
        Object objG3 = composer.G();
        if (zI2 || objG3 == Composer.f23746a.a()) {
            objG3 = new FloatingActionButtonElevation$animateElevation$2$1(interactionSource, floatingActionButtonElevationAnimatable2, null);
            composer.w(objG3);
        }
        EffectsKt.g(interactionSource, (Function2) objG3, composer, i4);
        State stateC = floatingActionButtonElevationAnimatable2.c();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return stateC;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof FloatingActionButtonElevation)) {
            return false;
        }
        FloatingActionButtonElevation floatingActionButtonElevation = (FloatingActionButtonElevation) obj;
        if (Dp.i(this.f17761a, floatingActionButtonElevation.f17761a) && Dp.i(this.f17762b, floatingActionButtonElevation.f17762b) && Dp.i(this.f17763c, floatingActionButtonElevation.f17763c)) {
            return Dp.i(this.f17764d, floatingActionButtonElevation.f17764d);
        }
        return false;
    }

    public final State f(InteractionSource interactionSource, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-424810125, i3, -1, "androidx.compose.material3.FloatingActionButtonElevation.shadowElevation (FloatingActionButton.kt:516)");
        }
        State stateE = e(interactionSource, composer, i3 & 126);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return stateE;
    }

    public final float g() {
        return this.f17761a;
    }

    public int hashCode() {
        return (((((Dp.j(this.f17761a) * 31) + Dp.j(this.f17762b)) * 31) + Dp.j(this.f17763c)) * 31) + Dp.j(this.f17764d);
    }

    private FloatingActionButtonElevation(float f3, float f4, float f5, float f6) {
        this.f17761a = f3;
        this.f17762b = f4;
        this.f17763c = f5;
        this.f17764d = f6;
    }
}
