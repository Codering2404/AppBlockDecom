package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Size;
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
public final class IntSizeKt {
    public static final long a(int i3, int i4) {
        return IntSize.c((((long) i4) & 4294967295L) | (((long) i3) << 32));
    }

    public static final long b(long j3) {
        return IntOffset.f((((j3 << 32) >> 33) & 4294967295L) | ((j3 >> 33) << 32));
    }

    public static final long c(long j3) {
        int iRound = Math.round(Float.intBitsToFloat((int) (j3 >> 32)));
        return IntSize.c((((long) Math.round(Float.intBitsToFloat((int) (j3 & 4294967295L)))) & 4294967295L) | (((long) iRound) << 32));
    }

    public static final long d(long j3) {
        int iIntBitsToFloat = (int) Float.intBitsToFloat((int) (j3 >> 32));
        return IntSize.c((((long) ((int) Float.intBitsToFloat((int) (j3 & 4294967295L)))) & 4294967295L) | (((long) iIntBitsToFloat) << 32));
    }

    public static final long e(long j3) {
        return Size.d((((long) Float.floatToRawIntBits((int) (j3 & 4294967295L))) & 4294967295L) | (Float.floatToRawIntBits((int) (j3 >> 32)) << 32));
    }
}
