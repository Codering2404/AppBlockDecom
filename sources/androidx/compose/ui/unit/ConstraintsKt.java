package androidx.compose.ui.unit;

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
public final class ConstraintsKt {
    public static final long a(int i3, int i4, int i5, int i6) {
        if (!((i5 >= 0) & (i4 >= i3) & (i6 >= i5) & (i3 >= 0))) {
            InlineClassHelperKt.a("maxWidth must be >= than minWidth,\nmaxHeight must be >= than minHeight,\nminWidth and minHeight must be >= 0");
        }
        return h(i3, i4, i5, i6);
    }

    public static /* synthetic */ long b(int i3, int i4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i3 = 0;
        }
        if ((i7 & 2) != 0) {
            i4 = Integer.MAX_VALUE;
        }
        if ((i7 & 4) != 0) {
            i5 = 0;
        }
        if ((i7 & 8) != 0) {
            i6 = Integer.MAX_VALUE;
        }
        return a(i3, i4, i5, i6);
    }

    public static final int c(int i3) {
        if (i3 < 8191) {
            return 13;
        }
        if (i3 < 32767) {
            return 15;
        }
        if (i3 < 65535) {
            return 16;
        }
        return i3 < 262143 ? 18 : 255;
    }

    public static final long d(long j3, long j4) {
        int i3 = (int) (j4 >> 32);
        int iN = Constraints.n(j3);
        int iL = Constraints.l(j3);
        if (i3 < iN) {
            i3 = iN;
        }
        if (i3 <= iL) {
            iL = i3;
        }
        int i4 = (int) (j4 & 4294967295L);
        int iM = Constraints.m(j3);
        int iK = Constraints.k(j3);
        if (i4 < iM) {
            i4 = iM;
        }
        if (i4 <= iK) {
            iK = i4;
        }
        return IntSize.c((((long) iL) << 32) | (((long) iK) & 4294967295L));
    }

    public static final long e(long j3, long j4) {
        int iN = Constraints.n(j3);
        int iL = Constraints.l(j3);
        int iM = Constraints.m(j3);
        int iK = Constraints.k(j3);
        int iN2 = Constraints.n(j4);
        if (iN2 < iN) {
            iN2 = iN;
        }
        if (iN2 > iL) {
            iN2 = iL;
        }
        int iL2 = Constraints.l(j4);
        if (iL2 >= iN) {
            iN = iL2;
        }
        if (iN <= iL) {
            iL = iN;
        }
        int iM2 = Constraints.m(j4);
        if (iM2 < iM) {
            iM2 = iM;
        }
        if (iM2 > iK) {
            iM2 = iK;
        }
        int iK2 = Constraints.k(j4);
        if (iK2 >= iM) {
            iM = iK2;
        }
        if (iM <= iK) {
            iK = iM;
        }
        return a(iN2, iL, iM2, iK);
    }

    public static final int f(long j3, int i3) {
        int iM = Constraints.m(j3);
        int iK = Constraints.k(j3);
        if (i3 < iM) {
            i3 = iM;
        }
        return i3 > iK ? iK : i3;
    }

    public static final int g(long j3, int i3) {
        int iN = Constraints.n(j3);
        int iL = Constraints.l(j3);
        if (i3 < iN) {
            i3 = iN;
        }
        return i3 > iL ? iL : i3;
    }

    public static final long h(int i3, int i4, int i5, int i6) {
        int i7 = i6 == Integer.MAX_VALUE ? i5 : i6;
        int iC = c(i7);
        int i8 = i4 == Integer.MAX_VALUE ? i3 : i4;
        int iC2 = c(i8);
        if (iC + iC2 > 31) {
            k(i8, i7);
        }
        int i9 = i4 + 1;
        int i10 = i6 + 1;
        int i11 = iC2 - 13;
        return Constraints.b((((long) (i9 & (~(i9 >> 31)))) << 33) | ((long) ((i11 >> 1) + (i11 & 1))) | (((long) i3) << 2) | (((long) i5) << (iC2 + 2)) | (((long) (i10 & (~(i10 >> 31)))) << (iC2 + 33)));
    }

    public static final long i(long j3, int i3, int i4) {
        int iN = Constraints.n(j3) + i3;
        if (iN < 0) {
            iN = 0;
        }
        int iL = Constraints.l(j3);
        if (iL != Integer.MAX_VALUE && (iL = iL + i3) < 0) {
            iL = 0;
        }
        int iM = Constraints.m(j3) + i4;
        if (iM < 0) {
            iM = 0;
        }
        int iK = Constraints.k(j3);
        return a(iN, iL, iM, (iK == Integer.MAX_VALUE || (iK = iK + i4) >= 0) ? iK : 0);
    }

    public static /* synthetic */ long j(long j3, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i3 = 0;
        }
        if ((i5 & 2) != 0) {
            i4 = 0;
        }
        return i(j3, i3, i4);
    }

    public static final void k(int i3, int i4) {
        throw new IllegalArgumentException("Can't represent a width of " + i3 + " and height of " + i4 + " in Constraints");
    }

    public static final Void l(int i3) {
        throw new IllegalArgumentException("Can't represent a size of " + i3 + " in Constraints");
    }
}
