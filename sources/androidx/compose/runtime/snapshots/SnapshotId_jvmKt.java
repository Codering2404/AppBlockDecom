package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;

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
public final class SnapshotId_jvmKt {
    public static final int a(long[] jArr, long j3) {
        int length = jArr.length - 1;
        int i3 = 0;
        while (i3 <= length) {
            int i4 = (i3 + length) >>> 1;
            long j4 = jArr[i4];
            if (j3 > j4) {
                i3 = i4 + 1;
            } else {
                if (j3 >= j4) {
                    return i4;
                }
                length = i4 - 1;
            }
        }
        return -(i3 + 1);
    }

    public static final long[] b(int i3) {
        return new long[i3];
    }

    public static final long c(int i3) {
        return i3;
    }

    public static final long[] d(long[] jArr, int i3, long j3) {
        int length = jArr.length;
        long[] jArr2 = new long[length + 1];
        ArraysKt.copyInto(jArr, jArr2, 0, 0, i3);
        ArraysKt.copyInto(jArr, jArr2, i3 + 1, i3, length);
        jArr2[i3] = j3;
        return jArr2;
    }

    public static final long[] e(long[] jArr, int i3) {
        int length = jArr.length;
        int i4 = length - 1;
        if (i4 == 0) {
            return null;
        }
        long[] jArr2 = new long[i4];
        if (i3 > 0) {
            ArraysKt.copyInto(jArr, jArr2, 0, 0, i3);
        }
        if (i3 < i4) {
            ArraysKt.copyInto(jArr, jArr2, i3, i3 + 1, length);
        }
        return jArr2;
    }
}
