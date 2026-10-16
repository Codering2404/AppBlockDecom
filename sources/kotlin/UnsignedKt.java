package kotlin;

import com.google.android.gms.common.api.Api;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

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
public final class UnsignedKt {
    public static final int a(double d3) {
        if (Double.isNaN(d3) || d3 <= c(0)) {
            return 0;
        }
        if (d3 >= c(-1)) {
            return -1;
        }
        return d3 <= 2.147483647E9d ? UInt.b((int) d3) : UInt.b(UInt.b((int) (d3 - ((double) Api.BaseClientBuilder.API_PRIORITY_OTHER))) + UInt.b(Api.BaseClientBuilder.API_PRIORITY_OTHER));
    }

    public static final int b(int i3, int i4) {
        return Intrinsics.compare(i3 ^ Integer.MIN_VALUE, i4 ^ Integer.MIN_VALUE);
    }

    public static final double c(int i3) {
        return ((double) (Integer.MAX_VALUE & i3)) + (((double) ((i3 >>> 31) << 30)) * ((double) 2));
    }

    public static final int d(long j3, long j4) {
        return Intrinsics.compare(j3 ^ Long.MIN_VALUE, j4 ^ Long.MIN_VALUE);
    }

    public static final double e(long j3) {
        return ((j3 >>> 11) * ((double) 2048)) + (j3 & 2047);
    }

    public static final String f(long j3, int i3) {
        if (j3 >= 0) {
            String string = Long.toString(j3, CharsKt.checkRadix(i3));
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
        long j4 = i3;
        long j5 = ((j3 >>> 1) / j4) << 1;
        long j6 = j3 - (j5 * j4);
        if (j6 >= j4) {
            j6 -= j4;
            j5++;
        }
        StringBuilder sb = new StringBuilder();
        String string2 = Long.toString(j5, CharsKt.checkRadix(i3));
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        sb.append(string2);
        String string3 = Long.toString(j6, CharsKt.checkRadix(i3));
        Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
        sb.append(string3);
        return sb.toString();
    }
}
