package kotlin.collections;

import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class UArraySortingKt {
    /* JADX INFO: renamed from: partition--nroSd4, reason: not valid java name */
    private static final int m1475partitionnroSd4(long[] jArr, int i3, int i4) {
        long jL = ULongArray.l(jArr, (i3 + i4) / 2);
        while (i3 <= i4) {
            while (Long.compareUnsigned(ULongArray.l(jArr, i3), jL) < 0) {
                i3++;
            }
            while (Long.compareUnsigned(ULongArray.l(jArr, i4), jL) > 0) {
                i4--;
            }
            if (i3 <= i4) {
                long jL2 = ULongArray.l(jArr, i3);
                ULongArray.t(jArr, i3, ULongArray.l(jArr, i4));
                ULongArray.t(jArr, i4, jL2);
                i3++;
                i4--;
            }
        }
        return i3;
    }

    /* JADX INFO: renamed from: partition-4UcCI2c, reason: not valid java name */
    private static final int m1476partition4UcCI2c(byte[] bArr, int i3, int i4) {
        int i5;
        byte bL = UByteArray.l(bArr, (i3 + i4) / 2);
        while (i3 <= i4) {
            while (true) {
                i5 = bL & 255;
                if (Intrinsics.compare(UByteArray.l(bArr, i3) & 255, i5) >= 0) {
                    break;
                }
                i3++;
            }
            while (Intrinsics.compare(UByteArray.l(bArr, i4) & 255, i5) > 0) {
                i4--;
            }
            if (i3 <= i4) {
                byte bL2 = UByteArray.l(bArr, i3);
                UByteArray.t(bArr, i3, UByteArray.l(bArr, i4));
                UByteArray.t(bArr, i4, bL2);
                i3++;
                i4--;
            }
        }
        return i3;
    }

    /* JADX INFO: renamed from: partition-Aa5vz7o, reason: not valid java name */
    private static final int m1477partitionAa5vz7o(short[] sArr, int i3, int i4) {
        int i5;
        short sL = UShortArray.l(sArr, (i3 + i4) / 2);
        while (i3 <= i4) {
            while (true) {
                i5 = sL & 65535;
                if (Intrinsics.compare(UShortArray.l(sArr, i3) & 65535, i5) >= 0) {
                    break;
                }
                i3++;
            }
            while (Intrinsics.compare(UShortArray.l(sArr, i4) & 65535, i5) > 0) {
                i4--;
            }
            if (i3 <= i4) {
                short sL2 = UShortArray.l(sArr, i3);
                UShortArray.t(sArr, i3, UShortArray.l(sArr, i4));
                UShortArray.t(sArr, i4, sL2);
                i3++;
                i4--;
            }
        }
        return i3;
    }

    /* JADX INFO: renamed from: partition-oBK06Vg, reason: not valid java name */
    private static final int m1478partitionoBK06Vg(int[] iArr, int i3, int i4) {
        int iL = UIntArray.l(iArr, (i3 + i4) / 2);
        while (i3 <= i4) {
            while (Integer.compareUnsigned(UIntArray.l(iArr, i3), iL) < 0) {
                i3++;
            }
            while (Integer.compareUnsigned(UIntArray.l(iArr, i4), iL) > 0) {
                i4--;
            }
            if (i3 <= i4) {
                int iL2 = UIntArray.l(iArr, i3);
                UIntArray.t(iArr, i3, UIntArray.l(iArr, i4));
                UIntArray.t(iArr, i4, iL2);
                i3++;
                i4--;
            }
        }
        return i3;
    }

    /* JADX INFO: renamed from: quickSort--nroSd4, reason: not valid java name */
    private static final void m1479quickSortnroSd4(long[] jArr, int i3, int i4) {
        int iM1475partitionnroSd4 = m1475partitionnroSd4(jArr, i3, i4);
        int i5 = iM1475partitionnroSd4 - 1;
        if (i3 < i5) {
            m1479quickSortnroSd4(jArr, i3, i5);
        }
        if (iM1475partitionnroSd4 < i4) {
            m1479quickSortnroSd4(jArr, iM1475partitionnroSd4, i4);
        }
    }

    /* JADX INFO: renamed from: quickSort-4UcCI2c, reason: not valid java name */
    private static final void m1480quickSort4UcCI2c(byte[] bArr, int i3, int i4) {
        int iM1476partition4UcCI2c = m1476partition4UcCI2c(bArr, i3, i4);
        int i5 = iM1476partition4UcCI2c - 1;
        if (i3 < i5) {
            m1480quickSort4UcCI2c(bArr, i3, i5);
        }
        if (iM1476partition4UcCI2c < i4) {
            m1480quickSort4UcCI2c(bArr, iM1476partition4UcCI2c, i4);
        }
    }

    /* JADX INFO: renamed from: quickSort-Aa5vz7o, reason: not valid java name */
    private static final void m1481quickSortAa5vz7o(short[] sArr, int i3, int i4) {
        int iM1477partitionAa5vz7o = m1477partitionAa5vz7o(sArr, i3, i4);
        int i5 = iM1477partitionAa5vz7o - 1;
        if (i3 < i5) {
            m1481quickSortAa5vz7o(sArr, i3, i5);
        }
        if (iM1477partitionAa5vz7o < i4) {
            m1481quickSortAa5vz7o(sArr, iM1477partitionAa5vz7o, i4);
        }
    }

    /* JADX INFO: renamed from: quickSort-oBK06Vg, reason: not valid java name */
    private static final void m1482quickSortoBK06Vg(int[] iArr, int i3, int i4) {
        int iM1478partitionoBK06Vg = m1478partitionoBK06Vg(iArr, i3, i4);
        int i5 = iM1478partitionoBK06Vg - 1;
        if (i3 < i5) {
            m1482quickSortoBK06Vg(iArr, i3, i5);
        }
        if (iM1478partitionoBK06Vg < i4) {
            m1482quickSortoBK06Vg(iArr, iM1478partitionoBK06Vg, i4);
        }
    }

    /* JADX INFO: renamed from: sortArray--nroSd4, reason: not valid java name */
    public static final void m1483sortArraynroSd4(long[] jArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-array$0");
        m1479quickSortnroSd4(jArr, i3, i4 - 1);
    }

    /* JADX INFO: renamed from: sortArray-4UcCI2c, reason: not valid java name */
    public static final void m1484sortArray4UcCI2c(byte[] bArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-array$0");
        m1480quickSort4UcCI2c(bArr, i3, i4 - 1);
    }

    /* JADX INFO: renamed from: sortArray-Aa5vz7o, reason: not valid java name */
    public static final void m1485sortArrayAa5vz7o(short[] sArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-array$0");
        m1481quickSortAa5vz7o(sArr, i3, i4 - 1);
    }

    /* JADX INFO: renamed from: sortArray-oBK06Vg, reason: not valid java name */
    public static final void m1486sortArrayoBK06Vg(int[] iArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-array$0");
        m1482quickSortoBK06Vg(iArr, i3, i4 - 1);
    }
}
