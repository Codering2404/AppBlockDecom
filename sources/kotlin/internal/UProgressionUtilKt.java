package kotlin.internal;

import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class UProgressionUtilKt {
    private static final int a(int i3, int i4, int i5) {
        int iRemainderUnsigned = Integer.remainderUnsigned(i3, i5);
        int iRemainderUnsigned2 = Integer.remainderUnsigned(i4, i5);
        int iCompareUnsigned = Integer.compareUnsigned(iRemainderUnsigned, iRemainderUnsigned2);
        int iB = UInt.b(iRemainderUnsigned - iRemainderUnsigned2);
        return iCompareUnsigned >= 0 ? iB : UInt.b(iB + i5);
    }

    private static final long b(long j3, long j4, long j5) {
        long jRemainderUnsigned = Long.remainderUnsigned(j3, j5);
        long jRemainderUnsigned2 = Long.remainderUnsigned(j4, j5);
        int iCompareUnsigned = Long.compareUnsigned(jRemainderUnsigned, jRemainderUnsigned2);
        long jB = ULong.b(jRemainderUnsigned - jRemainderUnsigned2);
        return iCompareUnsigned >= 0 ? jB : ULong.b(jB + j5);
    }

    public static final long c(long j3, long j4, long j5) {
        if (j5 > 0) {
            return Long.compareUnsigned(j3, j4) >= 0 ? j4 : ULong.b(j4 - b(j4, j3, ULong.b(j5)));
        }
        if (j5 < 0) {
            return Long.compareUnsigned(j3, j4) <= 0 ? j4 : ULong.b(j4 + b(j3, j4, ULong.b(-j5)));
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    public static final int d(int i3, int i4, int i5) {
        if (i5 > 0) {
            if (Integer.compareUnsigned(i3, i4) < 0) {
                return UInt.b(i4 - a(i4, i3, UInt.b(i5)));
            }
        } else {
            if (i5 >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            }
            if (Integer.compareUnsigned(i3, i4) > 0) {
                return UInt.b(i4 + a(i3, i4, UInt.b(-i5)));
            }
        }
        return i4;
    }
}
