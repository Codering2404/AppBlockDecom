package androidx.compose.ui.util;

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
public final class MathHelpersKt {
    public static final float a(float f3) {
        float fIntBitsToFloat = Float.intBitsToFloat(((int) ((((long) Float.floatToRawIntBits(f3)) & 8589934591L) / ((long) 3))) + 709952852);
        float f4 = fIntBitsToFloat - ((fIntBitsToFloat - (f3 / (fIntBitsToFloat * fIntBitsToFloat))) * 0.33333334f);
        return f4 - ((f4 - (f3 / (f4 * f4))) * 0.33333334f);
    }

    public static final float b(float f3, float f4, float f5) {
        return ((1 - f5) * f3) + (f5 * f4);
    }

    public static final int c(int i3, int i4, float f3) {
        return i3 + ((int) Math.round(((double) (i4 - i3)) * ((double) f3)));
    }
}
