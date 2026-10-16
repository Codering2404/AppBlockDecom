package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.unit.Density;
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
public final class InlineDensity {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f10997b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f10998c = b(Float.NaN, Float.NaN);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f10999a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return InlineDensity.f10998c;
        }

        private Companion() {
        }
    }

    public static long b(float f3, float f4) {
        return c((((long) Float.floatToRawIntBits(f4)) & 4294967295L) | (Float.floatToRawIntBits(f3) << 32));
    }

    public static long d(Density density) {
        return b(density.getDensity(), density.K1());
    }

    public static boolean e(long j3, Object obj) {
        return (obj instanceof InlineDensity) && j3 == ((InlineDensity) obj).k();
    }

    public static final boolean f(long j3, long j4) {
        return j3 == j4;
    }

    public static final float g(long j3) {
        return Float.intBitsToFloat((int) (j3 >> 32));
    }

    public static final float h(long j3) {
        return Float.intBitsToFloat((int) (j3 & 4294967295L));
    }

    public static int i(long j3) {
        return Long.hashCode(j3);
    }

    public static String j(long j3) {
        return "InlineDensity(density=" + g(j3) + ", fontScale=" + h(j3) + ')';
    }

    public boolean equals(Object obj) {
        return e(this.f10999a, obj);
    }

    public int hashCode() {
        return i(this.f10999a);
    }

    public final /* synthetic */ long k() {
        return this.f10999a;
    }

    public String toString() {
        return j(this.f10999a);
    }

    private static long c(long j3) {
        return j3;
    }
}
