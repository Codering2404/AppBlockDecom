package kotlin.math;

import com.google.android.gms.common.api.Api;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
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
public class MathKt__MathJVMKt extends MathKt__MathHKt {
    public static int a(int i3) {
        return Integer.signum(i3);
    }

    public static int b(long j3) {
        return Long.signum(j3);
    }

    public static int c(double d3) {
        if (Double.isNaN(d3)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        if (d3 > 2.147483647E9d) {
            return Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        if (d3 < -2.147483648E9d) {
            return Integer.MIN_VALUE;
        }
        return (int) Math.round(d3);
    }

    public static int d(float f3) {
        if (Float.isNaN(f3)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(f3);
    }

    public static long e(double d3) {
        if (Double.isNaN(d3)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(d3);
    }

    public static long f(float f3) {
        return e(f3);
    }
}
