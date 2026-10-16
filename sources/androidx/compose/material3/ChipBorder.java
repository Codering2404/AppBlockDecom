package androidx.compose.material3;

import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
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
public final class ChipBorder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f16313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f16314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f16315c;

    public /* synthetic */ ChipBorder(long j3, long j4, float f3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, f3);
    }

    public final State a(boolean z2, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1899621712, i3, -1, "androidx.compose.material3.ChipBorder.borderStroke (Chip.kt:2733)");
        }
        State stateP = SnapshotStateKt.p(BorderStrokeKt.a(this.f16315c, z2 ? this.f16313a : this.f16314b), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return stateP;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ChipBorder)) {
            return false;
        }
        ChipBorder chipBorder = (ChipBorder) obj;
        return Color.t(this.f16313a, chipBorder.f16313a) && Color.t(this.f16314b, chipBorder.f16314b) && Dp.i(this.f16315c, chipBorder.f16315c);
    }

    public int hashCode() {
        return (((Color.z(this.f16313a) * 31) + Color.z(this.f16314b)) * 31) + Dp.j(this.f16315c);
    }

    private ChipBorder(long j3, long j4, float f3) {
        this.f16313a = j3;
        this.f16314b = j4;
        this.f16315c = f3;
    }
}
