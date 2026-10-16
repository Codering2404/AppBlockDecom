package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class ColumnKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final MeasurePolicy f6657a = new ColumnMeasurePolicy(Arrangement.f6574a.h(), Alignment.f25072a.k());

    public static final MeasurePolicy a(Arrangement.Vertical vertical, Alignment.Horizontal horizontal, Composer composer, int i3) {
        MeasurePolicy measurePolicy;
        if (ComposerKt.M()) {
            ComposerKt.U(1089876336, i3, -1, "androidx.compose.foundation.layout.columnMeasurePolicy (Column.kt:108)");
        }
        if (Intrinsics.areEqual(vertical, Arrangement.f6574a.h()) && Intrinsics.areEqual(horizontal, Alignment.f25072a.k())) {
            composer.a0(346089448);
            composer.U();
            measurePolicy = f6657a;
        } else {
            composer.a0(346143295);
            boolean z2 = ((((i3 & 14) ^ 6) > 4 && composer.Z(vertical)) || (i3 & 6) == 4) | ((((i3 & 112) ^ 48) > 32 && composer.Z(horizontal)) || (i3 & 48) == 32);
            Object objG = composer.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new ColumnMeasurePolicy(vertical, horizontal);
                composer.w(objG);
            }
            measurePolicy = (ColumnMeasurePolicy) objG;
            composer.U();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return measurePolicy;
    }

    public static final long b(boolean z2, int i3, int i4, int i5, int i6) {
        return !z2 ? ConstraintsKt.a(i4, i6, i3, i5) : Constraints.f29963b.a(i4, i6, i3, i5);
    }
}
