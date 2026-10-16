package androidx.compose.ui.spatial;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class RectList {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long[] f28570a = new long[192];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long[] f28571b = new long[192];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f28572c;

    public static /* synthetic */ void e(RectList rectList, int i3, int i4, int i5, int i6, int i7, int i8, boolean z2, boolean z3, int i9, Object obj) {
        boolean z4;
        RectList rectList2;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15 = (i9 & 32) != 0 ? -1 : i8;
        boolean z5 = (i9 & 64) != 0 ? false : z2;
        if ((i9 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            z4 = false;
            i10 = i3;
            i11 = i4;
            i12 = i5;
            i13 = i6;
            i14 = i7;
            rectList2 = rectList;
        } else {
            z4 = z3;
            rectList2 = rectList;
            i10 = i3;
            i11 = i4;
            i12 = i5;
            i13 = i6;
            i14 = i7;
        }
        rectList2.d(i10, i11, i12, i13, i14, i15, z5, z4);
    }

    private final void i(int i3, int i4, long[] jArr) {
        int iMax = Math.max(i3 * 2, i4 + 3);
        long[] jArrCopyOf = Arrays.copyOf(jArr, iMax);
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
        this.f28570a = jArrCopyOf;
        long[] jArrCopyOf2 = Arrays.copyOf(this.f28571b, iMax);
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf2, "copyOf(...)");
        this.f28571b = jArrCopyOf2;
    }

    private final void k(long j3, int i3, int i4) {
        int i5;
        char c3;
        char c4;
        long[] jArr = this.f28570a;
        long[] jArr2 = this.f28571b;
        int iC = c();
        jArr2[0] = j3;
        int i6 = 1;
        while (i6 > 0) {
            i6--;
            long j4 = jArr2[i6];
            int i7 = 67108863;
            int i8 = ((int) j4) & 67108863;
            char c5 = 26;
            int i9 = ((int) (j4 >> 26)) & 67108863;
            char c6 = '4';
            char c7 = 511;
            int i10 = ((int) (j4 >> 52)) & 511;
            int i11 = i10 == 511 ? iC : i10 + i9;
            if (i9 < 0) {
                return;
            }
            while (i9 < jArr.length - 2 && i9 < i11) {
                int i12 = i9 + 2;
                long j5 = jArr[i12];
                int i13 = i7;
                char c8 = c5;
                if ((((int) (j5 >> c8)) & i13) == i8) {
                    long j6 = jArr[i9];
                    int i14 = i9 + 1;
                    c3 = c6;
                    long j7 = jArr[i14];
                    i5 = i8;
                    jArr[i9] = (((long) (((int) j6) + i4)) & 4294967295L) | (((long) (((int) (j6 >> 32)) + i3)) << 32);
                    jArr[i14] = (((long) (((int) j7) + i4)) & 4294967295L) | (((long) (((int) (j7 >> 32)) + i3)) << 32);
                    jArr[i12] = 2305843009213693952L | j5;
                    c4 = 511;
                    if ((((int) (j5 >> c3)) & 511) > 0) {
                        jArr2[i6] = (((long) ((i9 + 3) & i13)) << c8) | ((-4503599560261633L) & j5);
                        i6++;
                    }
                } else {
                    i5 = i8;
                    c3 = c6;
                    c4 = c7;
                }
                i9 += 3;
                i7 = i13;
                c5 = c8;
                c7 = c4;
                c6 = c3;
                i8 = i5;
            }
        }
    }

    public final void a() {
        long[] jArr = this.f28570a;
        int i3 = this.f28572c;
        for (int i4 = 0; i4 < jArr.length - 2 && i4 < i3; i4 += 3) {
            int i5 = i4 + 2;
            jArr[i5] = jArr[i5] & (-2305843009213693953L);
        }
    }

    public final void b() {
        long[] jArr = this.f28570a;
        int i3 = this.f28572c;
        long[] jArr2 = this.f28571b;
        int i4 = 0;
        for (int i5 = 0; i5 < jArr.length - 2 && i4 < jArr2.length - 2 && i5 < i3; i5 += 3) {
            int i6 = i5 + 2;
            if (jArr[i6] != 2305843009213693951L) {
                jArr2[i4] = jArr[i5];
                jArr2[i4 + 1] = jArr[i5 + 1];
                jArr2[i4 + 2] = jArr[i6];
                i4 += 3;
            }
        }
        this.f28572c = i4;
        this.f28570a = jArr2;
        this.f28571b = jArr;
    }

    public final int c() {
        return this.f28572c / 3;
    }

    public final void d(int i3, int i4, int i5, int i6, int i7, int i8, boolean z2, boolean z3) {
        long[] jArr = this.f28570a;
        int i9 = this.f28572c;
        int i10 = i9 + 3;
        this.f28572c = i10;
        int length = jArr.length;
        if (length <= i10) {
            i(length, i9, jArr);
        }
        long[] jArr2 = this.f28570a;
        jArr2[i9] = (((long) i4) << 32) | (((long) i5) & 4294967295L);
        jArr2[i9 + 1] = (((long) i6) << 32) | (((long) i7) & 4294967295L);
        int i11 = i8 & 67108863;
        jArr2[i9 + 2] = ((z3 ? 1L : 0L) << 63) | ((z2 ? 1L : 0L) << 62) | (((long) 1) << 61) | (((long) 0) << 52) | (((long) i11) << 26) | ((long) (i3 & 67108863));
        if (i8 < 0) {
            return;
        }
        for (int i12 = i9 - 3; i12 >= 0; i12 -= 3) {
            int i13 = i12 + 2;
            long j3 = jArr2[i13];
            if ((((int) j3) & 67108863) == i11) {
                jArr2[i13] = (j3 & (-2301339409586323457L)) | (((long) ((i9 - i12) & 511)) << 52);
                return;
            }
        }
    }

    public final void f(int i3) {
        int i4 = i3 & 67108863;
        long[] jArr = this.f28570a;
        int i5 = this.f28572c;
        for (int i6 = 0; i6 < jArr.length - 2 && i6 < i5; i6 += 3) {
            int i7 = i6 + 2;
            long j3 = jArr[i7];
            if ((((int) j3) & 67108863) == i4) {
                jArr[i7] = 2305843009213693952L | j3;
                return;
            }
        }
    }

    public final boolean g(int i3, int i4, int i5, int i6, int i7) {
        int i8 = i3 & 67108863;
        long[] jArr = this.f28570a;
        int i9 = this.f28572c;
        for (int i10 = 0; i10 < jArr.length - 2 && i10 < i9; i10 += 3) {
            int i11 = i10 + 2;
            long j3 = jArr[i11];
            if ((((int) j3) & 67108863) == i8) {
                long j4 = jArr[i10];
                jArr[i10] = (((long) i5) & 4294967295L) | (((long) i4) << 32);
                int i12 = i10;
                jArr[i10 + 1] = (((long) i7) & 4294967295L) | (((long) i6) << 32);
                jArr[i11] = 2305843009213693952L | j3;
                int i13 = i4 - ((int) (j4 >> 32));
                int i14 = i5 - ((int) j4);
                if ((i13 != 0) | (i14 != 0)) {
                    k(((-4503599560261633L) & j3) | (((long) ((i12 + 3) & 67108863)) << 26), i13, i14);
                }
                return true;
            }
        }
        return false;
    }

    public final boolean h(int i3) {
        int i4 = i3 & 67108863;
        long[] jArr = this.f28570a;
        int i5 = this.f28572c;
        for (int i6 = 0; i6 < jArr.length - 2 && i6 < i5; i6 += 3) {
            int i7 = i6 + 2;
            if ((((int) jArr[i7]) & 67108863) == i4) {
                jArr[i6] = -1;
                jArr[i6 + 1] = -1;
                jArr[i7] = 2305843009213693951L;
                return true;
            }
        }
        return false;
    }

    public final boolean j(int i3, int i4, int i5, int i6, int i7) {
        int i8 = i3 & 67108863;
        long[] jArr = this.f28570a;
        int i9 = this.f28572c;
        for (int i10 = 0; i10 < jArr.length - 2 && i10 < i9; i10 += 3) {
            int i11 = i10 + 2;
            long j3 = jArr[i11];
            if ((((int) j3) & 67108863) == i8) {
                jArr[i10] = (((long) i4) << 32) | (((long) i5) & 4294967295L);
                jArr[i10 + 1] = (((long) i6) << 32) | (((long) i7) & 4294967295L);
                jArr[i11] = 2305843009213693952L | j3;
                return true;
            }
        }
        return false;
    }

    public final boolean l(int i3, Function4 function4) {
        int i4 = i3 & 67108863;
        long[] jArr = this.f28570a;
        int i5 = this.f28572c;
        for (int i6 = 0; i6 < jArr.length - 2 && i6 < i5; i6 += 3) {
            if ((((int) jArr[i6 + 2]) & 67108863) == i4) {
                long j3 = jArr[i6];
                long j4 = jArr[i6 + 1];
                function4.invoke(Integer.valueOf((int) (j3 >> 32)), Integer.valueOf((int) j3), Integer.valueOf((int) (j4 >> 32)), Integer.valueOf((int) j4));
                return true;
            }
        }
        return false;
    }
}
