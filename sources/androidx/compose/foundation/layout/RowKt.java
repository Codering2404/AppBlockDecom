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
public final class RowKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final MeasurePolicy f7093a = new RowMeasurePolicy(Arrangement.f6574a.g(), Alignment.f25072a.l());

    public static final long a(boolean z2, int i3, int i4, int i5, int i6) {
        return !z2 ? ConstraintsKt.a(i3, i5, i4, i6) : Constraints.f29963b.b(i3, i5, i4, i6);
    }

    public static final MeasurePolicy b(Arrangement.Horizontal horizontal, Alignment.Vertical vertical, Composer composer, int i3) {
        MeasurePolicy measurePolicy;
        if (ComposerKt.M()) {
            ComposerKt.U(-837807694, i3, -1, "androidx.compose.foundation.layout.rowMeasurePolicy (Row.kt:121)");
        }
        if (Intrinsics.areEqual(horizontal, Arrangement.f6574a.g()) && Intrinsics.areEqual(vertical, Alignment.f25072a.l())) {
            composer.a0(-848964613);
            composer.U();
            measurePolicy = f7093a;
        } else {
            composer.a0(-848913742);
            boolean z2 = ((((i3 & 14) ^ 6) > 4 && composer.Z(horizontal)) || (i3 & 6) == 4) | ((((i3 & 112) ^ 48) > 32 && composer.Z(vertical)) || (i3 & 48) == 32);
            Object objG = composer.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new RowMeasurePolicy(horizontal, vertical);
                composer.w(objG);
            }
            measurePolicy = (RowMeasurePolicy) objG;
            composer.U();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return measurePolicy;
    }
}
