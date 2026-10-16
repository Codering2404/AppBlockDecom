package androidx.compose.material3;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class RadioButtonColors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f19325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f19326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f19327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f19328d;

    public /* synthetic */ RadioButtonColors(long j3, long j4, long j5, long j6, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, j5, j6);
    }

    public static /* synthetic */ RadioButtonColors b(RadioButtonColors radioButtonColors, long j3, long j4, long j5, long j6, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = radioButtonColors.f19325a;
        }
        long j7 = j3;
        if ((i3 & 2) != 0) {
            j4 = radioButtonColors.f19326b;
        }
        long j8 = j4;
        if ((i3 & 4) != 0) {
            j5 = radioButtonColors.f19327c;
        }
        return radioButtonColors.a(j7, j8, j5, (i3 & 8) != 0 ? radioButtonColors.f19328d : j6);
    }

    public final RadioButtonColors a(long j3, long j4, long j5, long j6) {
        return new RadioButtonColors(j3 != 16 ? j3 : this.f19325a, j4 != 16 ? j4 : this.f19326b, j5 != 16 ? j5 : this.f19327c, j6 != 16 ? j6 : this.f19328d, null);
    }

    public final State c(boolean z2, boolean z3, Composer composer, int i3) {
        State stateP;
        if (ComposerKt.M()) {
            ComposerKt.U(-1840145292, i3, -1, "androidx.compose.material3.RadioButtonColors.radioColor (RadioButton.kt:228)");
        }
        long j3 = (z2 && z3) ? this.f19325a : (!z2 || z3) ? (z2 || !z3) ? this.f19328d : this.f19327c : this.f19326b;
        if (z2) {
            composer.a0(350067971);
            stateP = SingleValueAnimationKt.a(j3, AnimationSpecKt.n(100, 0, null, 6, null), null, null, composer, 48, 12);
            composer.U();
        } else {
            composer.a0(350170674);
            stateP = SnapshotStateKt.p(Color.n(j3), composer, 0);
            composer.U();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return stateP;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RadioButtonColors)) {
            return false;
        }
        RadioButtonColors radioButtonColors = (RadioButtonColors) obj;
        return Color.t(this.f19325a, radioButtonColors.f19325a) && Color.t(this.f19326b, radioButtonColors.f19326b) && Color.t(this.f19327c, radioButtonColors.f19327c) && Color.t(this.f19328d, radioButtonColors.f19328d);
    }

    public int hashCode() {
        return (((((Color.z(this.f19325a) * 31) + Color.z(this.f19326b)) * 31) + Color.z(this.f19327c)) * 31) + Color.z(this.f19328d);
    }

    private RadioButtonColors(long j3, long j4, long j5, long j6) {
        this.f19325a = j3;
        this.f19326b = j4;
        this.f19327c = j5;
        this.f19328d = j6;
    }
}
