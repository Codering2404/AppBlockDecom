package androidx.compose.ui.unit;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class TextUnitKt {
    public static final long a(float f3, long j3) {
        return l(j3, f3);
    }

    public static final void b(long j3) {
        if (TextUnit.f(j3) == 0) {
            InlineClassHelperKt.a("Cannot perform operation for Unspecified type.");
        }
    }

    public static final void c(long j3, long j4) {
        if (!((TextUnit.f(j3) == 0 || TextUnit.f(j4) == 0) ? false : true)) {
            InlineClassHelperKt.a("Cannot perform operation for Unspecified type.");
        }
        if (TextUnitType.g(TextUnit.g(j3), TextUnit.g(j4))) {
            return;
        }
        InlineClassHelperKt.a("Cannot perform operation for " + ((Object) TextUnitType.i(TextUnit.g(j3))) + " and " + ((Object) TextUnitType.i(TextUnit.g(j4))));
    }

    public static final long d(double d3) {
        return l(8589934592L, (float) d3);
    }

    public static final long e(float f3) {
        return l(8589934592L, f3);
    }

    public static final long f(int i3) {
        return l(8589934592L, i3);
    }

    public static final long g(double d3) {
        return l(4294967296L, (float) d3);
    }

    public static final long h(float f3) {
        return l(4294967296L, f3);
    }

    public static final long i(int i3) {
        return l(4294967296L, i3);
    }

    public static final boolean j(long j3) {
        return TextUnit.f(j3) == 0;
    }

    public static final long k(long j3, long j4, float f3) {
        c(j3, j4);
        return l(TextUnit.f(j3), MathHelpersKt.b(TextUnit.h(j3), TextUnit.h(j4), f3));
    }

    public static final long l(long j3, float f3) {
        return TextUnit.c(j3 | (((long) Float.floatToRawIntBits(f3)) & 4294967295L));
    }
}
