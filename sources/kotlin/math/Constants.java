package kotlin.math;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
final class Constants {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Constants f140164a = new Constants();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final double f140165b = Math.log(2.0d);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final double f140166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final double f140167d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final double f140168e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final double f140169f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final double f140170g;

    static {
        double dUlp = Math.ulp(1.0d);
        f140166c = dUlp;
        double dSqrt = Math.sqrt(dUlp);
        f140167d = dSqrt;
        double dSqrt2 = Math.sqrt(dSqrt);
        f140168e = dSqrt2;
        double d3 = 1;
        f140169f = d3 / dSqrt;
        f140170g = d3 / dSqrt2;
    }

    private Constants() {
    }
}
