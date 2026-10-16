package androidx.compose.ui.layout;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
@JvmInline
public final class ScaleFactor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f27212b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f27213c = a((((long) Float.floatToRawIntBits(Float.NaN)) << 32) | (((long) Float.floatToRawIntBits(Float.NaN)) & 4294967295L));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f27214a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public static boolean b(long j3, Object obj) {
        return (obj instanceof ScaleFactor) && j3 == ((ScaleFactor) obj).e();
    }

    public static int c(long j3) {
        return Long.hashCode(j3);
    }

    public static String d(long j3) {
        return "ScaleFactor(" + Float.intBitsToFloat((int) (j3 >> 32)) + ", " + Float.intBitsToFloat((int) (j3 & 4294967295L)) + ')';
    }

    public final /* synthetic */ long e() {
        return this.f27214a;
    }

    public boolean equals(Object obj) {
        return b(this.f27214a, obj);
    }

    public int hashCode() {
        return c(this.f27214a);
    }

    public String toString() {
        return d(this.f27214a);
    }

    public static long a(long j3) {
        return j3;
    }
}
