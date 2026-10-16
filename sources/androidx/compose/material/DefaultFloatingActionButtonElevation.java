package androidx.compose.material;

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
final class DefaultFloatingActionButtonElevation implements FloatingActionButtonElevation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f12572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f12573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f12574c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f12575d;

    public /* synthetic */ DefaultFloatingActionButtonElevation(float f3, float f4, float f5, float f6, DefaultConstructorMarker defaultConstructorMarker) {
        this(f3, f4, f5, f6);
    }

    @Override // androidx.compose.material.FloatingActionButtonElevation
    public State a(InteractionSource interactionSource, Composer composer, int i3) {
        composer.a0(-478475335);
        if (ComposerKt.M()) {
            ComposerKt.U(-478475335, i3, -1, "androidx.compose.material.DefaultFloatingActionButtonElevation.elevation (FloatingActionButton.kt:271)");
        }
        int i4 = i3 & 14;
        int i5 = i4 ^ 6;
        boolean z2 = (i5 > 4 && composer.Z(interactionSource)) || (i3 & 6) == 4;
        Object objG = composer.G();
        if (z2 || objG == Composer.f23746a.a()) {
            Object floatingActionButtonElevationAnimatable = new FloatingActionButtonElevationAnimatable(this.f12572a, this.f12573b, this.f12574c, this.f12575d, null);
            composer.w(floatingActionButtonElevationAnimatable);
            objG = floatingActionButtonElevationAnimatable;
        }
        FloatingActionButtonElevationAnimatable floatingActionButtonElevationAnimatable2 = (FloatingActionButtonElevationAnimatable) objG;
        boolean zI = composer.I(floatingActionButtonElevationAnimatable2) | ((((i3 & 112) ^ 48) > 32 && composer.Z(this)) || (i3 & 48) == 32);
        Object objG2 = composer.G();
        if (zI || objG2 == Composer.f23746a.a()) {
            objG2 = new DefaultFloatingActionButtonElevation$elevation$1$1(floatingActionButtonElevationAnimatable2, this, null);
            composer.w(objG2);
        }
        EffectsKt.g(this, (Function2) objG2, composer, (i3 >> 3) & 14);
        boolean zI2 = composer.I(floatingActionButtonElevationAnimatable2) | ((i5 > 4 && composer.Z(interactionSource)) || (i3 & 6) == 4);
        Object objG3 = composer.G();
        if (zI2 || objG3 == Composer.f23746a.a()) {
            objG3 = new DefaultFloatingActionButtonElevation$elevation$2$1(interactionSource, floatingActionButtonElevationAnimatable2, null);
            composer.w(objG3);
        }
        EffectsKt.g(interactionSource, (Function2) objG3, composer, i4);
        State stateC = floatingActionButtonElevationAnimatable2.c();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return stateC;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DefaultFloatingActionButtonElevation)) {
            return false;
        }
        DefaultFloatingActionButtonElevation defaultFloatingActionButtonElevation = (DefaultFloatingActionButtonElevation) obj;
        if (Dp.i(this.f12572a, defaultFloatingActionButtonElevation.f12572a) && Dp.i(this.f12573b, defaultFloatingActionButtonElevation.f12573b) && Dp.i(this.f12574c, defaultFloatingActionButtonElevation.f12574c)) {
            return Dp.i(this.f12575d, defaultFloatingActionButtonElevation.f12575d);
        }
        return false;
    }

    public int hashCode() {
        return (((((Dp.j(this.f12572a) * 31) + Dp.j(this.f12573b)) * 31) + Dp.j(this.f12574c)) * 31) + Dp.j(this.f12575d);
    }

    private DefaultFloatingActionButtonElevation(float f3, float f4, float f5, float f6) {
        this.f12572a = f3;
        this.f12573b = f4;
        this.f12574c = f5;
        this.f12575d = f6;
    }
}
