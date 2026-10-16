package androidx.compose.material;

import androidx.appcompat.app.jE.vxrlPPpdv;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class DefaultRadioButtonColors implements RadioButtonColors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f12590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f12591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f12592c;

    public /* synthetic */ DefaultRadioButtonColors(long j3, long j4, long j5, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, j5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DefaultRadioButtonColors.class != obj.getClass()) {
            return false;
        }
        DefaultRadioButtonColors defaultRadioButtonColors = (DefaultRadioButtonColors) obj;
        return Color.t(this.f12590a, defaultRadioButtonColors.f12590a) && Color.t(this.f12591b, defaultRadioButtonColors.f12591b) && Color.t(this.f12592c, defaultRadioButtonColors.f12592c);
    }

    public int hashCode() {
        return (((Color.z(this.f12590a) * 31) + Color.z(this.f12591b)) * 31) + Color.z(this.f12592c);
    }

    private DefaultRadioButtonColors(long j3, long j4, long j5) {
        this.f12590a = j3;
        this.f12591b = j4;
        this.f12592c = j5;
    }

    @Override // androidx.compose.material.RadioButtonColors
    public State a(boolean z2, boolean z3, Composer composer, int i3) {
        long j3;
        Composer composer2;
        State stateP;
        composer.a0(1243421834);
        if (ComposerKt.M()) {
            ComposerKt.U(1243421834, i3, -1, vxrlPPpdv.BQDGBdDrAd);
        }
        if (!z2) {
            j3 = this.f12592c;
        } else if (!z3) {
            j3 = this.f12591b;
        } else {
            j3 = this.f12590a;
        }
        long j4 = j3;
        if (z2) {
            composer.a0(1872507307);
            composer2 = composer;
            stateP = SingleValueAnimationKt.a(j4, AnimationSpecKt.n(100, 0, null, 6, null), null, null, composer2, 48, 12);
            composer2.U();
        } else {
            composer2 = composer;
            composer2.a0(1872610010);
            stateP = SnapshotStateKt.p(Color.n(j4), composer2, 0);
            composer2.U();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer2.U();
        return stateP;
    }
}
