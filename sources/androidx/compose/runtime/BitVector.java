package androidx.compose.runtime;

import com.google.android.gms.common.api.Api;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.Arrays;
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
public final class BitVector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f23719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f23720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long[] f23721c = SlotTableKt.f24196a;

    public final boolean a(int i3) {
        int i4;
        if (i3 < 64) {
            return ((1 << i3) & this.f23719a) != 0;
        }
        if (i3 < 128) {
            return ((1 << (i3 - 64)) & this.f23720b) != 0;
        }
        long[] jArr = this.f23721c;
        int length = jArr.length;
        if (length != 0 && (i3 / 64) - 2 < length) {
            return ((1 << (i3 % 64)) & jArr[i4]) != 0;
        }
        return false;
    }

    public final int b() {
        return (this.f23721c.length + 2) * 64;
    }

    public final int c(int i3) {
        int iNumberOfTrailingZeros;
        if (i3 < 64 && (iNumberOfTrailingZeros = Long.numberOfTrailingZeros(((~this.f23719a) >>> i3) << i3)) < 64) {
            return iNumberOfTrailingZeros;
        }
        if (i3 < 128) {
            int i4 = i3 - 64;
            int iNumberOfTrailingZeros2 = Long.numberOfTrailingZeros(((~this.f23720b) >>> i4) << i4);
            if (iNumberOfTrailingZeros2 < 64) {
                return iNumberOfTrailingZeros2 + 64;
            }
        }
        int iMax = Math.max(i3, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
        int i5 = (iMax / 64) - 2;
        long[] jArr = this.f23721c;
        int length = jArr.length;
        for (int i6 = i5; i6 < length; i6++) {
            long j3 = ~jArr[i6];
            if (i6 == i5) {
                int i7 = iMax % 64;
                j3 = (j3 >>> i7) << i7;
            }
            int iNumberOfTrailingZeros3 = Long.numberOfTrailingZeros(j3);
            if (iNumberOfTrailingZeros3 < 64) {
                return (i6 * 64) + ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD + iNumberOfTrailingZeros3;
            }
        }
        return Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public final void d(int i3, boolean z2) {
        if (i3 < 64) {
            this.f23719a = ((z2 ? 1L : 0L) << i3) | ((~(1 << i3)) & this.f23719a);
            return;
        }
        if (i3 < 128) {
            this.f23720b = ((z2 ? 1L : 0L) << i3) | ((~(1 << (i3 - 64))) & this.f23720b);
            return;
        }
        int i4 = i3 / 64;
        int i5 = i4 - 2;
        int i6 = i3 % 64;
        long j3 = 1 << i6;
        long[] jArrCopyOf = this.f23721c;
        if (i5 >= jArrCopyOf.length) {
            jArrCopyOf = Arrays.copyOf(jArrCopyOf, i4 - 1);
            Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
            this.f23721c = jArrCopyOf;
        }
        jArrCopyOf[i5] = ((z2 ? 1L : 0L) << i6) | ((~j3) & jArrCopyOf[i5]);
    }

    public final void e(int i3, int i4) {
        long j3 = i3 < i4 ? -1L : 0L;
        this.f23719a = (((((long) (i3 < 64 ? 1 : 0)) * j3) >>> (64 - (Math.min(64, i4) - i3))) << i3) | this.f23719a;
        if (i4 > 64) {
            int iMax = Math.max(i3, 64);
            this.f23720b = (((j3 * ((long) (iMax < 128 ? 1 : 0))) >>> (128 - (Math.min(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, i4) - iMax))) << iMax) | this.f23720b;
            if (i4 > 128) {
                for (int iMax2 = Math.max(iMax, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD); iMax2 < i4; iMax2++) {
                    d(iMax2, true);
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BitVector [");
        int iB = b();
        boolean z2 = true;
        for (int i3 = 0; i3 < iB; i3++) {
            if (a(i3)) {
                if (!z2) {
                    sb.append(", ");
                }
                sb.append(i3);
                z2 = false;
            }
        }
        sb.append(']');
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
