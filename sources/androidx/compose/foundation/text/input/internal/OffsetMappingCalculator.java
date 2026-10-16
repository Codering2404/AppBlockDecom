package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class OffsetMappingCalculator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f10409a = OpArray.a(10);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10410b;

    private final long a(int i3, boolean z2) {
        int i4;
        int iMin;
        int[] iArr = this.f10409a;
        int i5 = this.f10410b;
        if (i5 >= 0) {
            if (z2) {
                int i6 = 0;
                iMin = i3;
                while (i6 < i5) {
                    int i7 = i6 * 3;
                    int i8 = iArr[i7];
                    int i9 = iArr[i7 + 1];
                    int i10 = iArr[i7 + 2];
                    long jD = d(iMin, i8, i9, i10, z2);
                    long jD2 = d(i3, i8, i9, i10, z2);
                    int iMin2 = Math.min(TextRange.n(jD), TextRange.n(jD2));
                    int iMax = Math.max(TextRange.i(jD), TextRange.i(jD2));
                    i6++;
                    iMin = iMin2;
                    i3 = iMax;
                }
            } else {
                int i11 = i5 - 1;
                iMin = i3;
                while (-1 < i11) {
                    int i12 = i11 * 3;
                    int i13 = iArr[i12];
                    int i14 = iArr[i12 + 1];
                    int i15 = iArr[i12 + 2];
                    boolean z3 = z2;
                    long jD3 = d(iMin, i13, i14, i15, z3);
                    long jD4 = d(i3, i13, i14, i15, z3);
                    iMin = Math.min(TextRange.n(jD3), TextRange.n(jD4));
                    i3 = Math.max(TextRange.i(jD3), TextRange.i(jD4));
                    i11--;
                    z2 = z3;
                }
            }
            i4 = i3;
            i3 = iMin;
        } else {
            i4 = i3;
        }
        return TextRangeKt.b(i3, i4);
    }

    private final long d(int i3, int i4, int i5, int i6, boolean z2) {
        int i7 = z2 ? i5 : i6;
        if (z2) {
            i5 = i6;
        }
        return i3 < i4 ? TextRangeKt.a(i3) : i3 == i4 ? i7 == 0 ? TextRangeKt.b(i4, i5 + i4) : TextRangeKt.a(i4) : i3 < i4 + i7 ? i5 == 0 ? TextRangeKt.a(i4) : TextRangeKt.b(i4, i5 + i4) : TextRangeKt.a((i3 - i7) + i5);
    }

    public final long b(int i3) {
        return a(i3, false);
    }

    public final long c(int i3) {
        return a(i3, true);
    }

    public final void e(int i3, int i4, int i5) {
        if (!(i5 >= 0)) {
            InlineClassHelperKt.a("Expected newLen to be ≥ 0, was " + i5);
        }
        int iMin = Math.min(i3, i4);
        int iMax = Math.max(iMin, i4) - iMin;
        if (iMax >= 2 || iMax != i5) {
            int i6 = this.f10410b + 1;
            if (i6 > OpArray.e(this.f10409a)) {
                this.f10409a = OpArray.c(this.f10409a, Math.max(i6 * 2, OpArray.e(this.f10409a) * 2));
            }
            OpArray.g(this.f10409a, this.f10410b, iMin, iMax, i5);
            this.f10410b = i6;
        }
    }
}
