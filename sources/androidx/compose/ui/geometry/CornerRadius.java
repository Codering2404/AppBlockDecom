package androidx.compose.ui.geometry;

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
public final class CornerRadius {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f25589b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f25590c = b(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f25591a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return CornerRadius.f25590c;
        }

        private Companion() {
        }
    }

    public static boolean c(long j3, Object obj) {
        return (obj instanceof CornerRadius) && j3 == ((CornerRadius) obj).g();
    }

    public static final boolean d(long j3, long j4) {
        return j3 == j4;
    }

    public static int e(long j3) {
        return Long.hashCode(j3);
    }

    public static String f(long j3) {
        int i3 = (int) (j3 >> 32);
        int i4 = (int) (j3 & 4294967295L);
        if (Float.intBitsToFloat(i3) == Float.intBitsToFloat(i4)) {
            return "CornerRadius.circular(" + GeometryUtilsKt.a(Float.intBitsToFloat(i3), 1) + ')';
        }
        return "CornerRadius.elliptical(" + GeometryUtilsKt.a(Float.intBitsToFloat(i3), 1) + ", " + GeometryUtilsKt.a(Float.intBitsToFloat(i4), 1) + ')';
    }

    public boolean equals(Object obj) {
        return c(this.f25591a, obj);
    }

    public final /* synthetic */ long g() {
        return this.f25591a;
    }

    public int hashCode() {
        return e(this.f25591a);
    }

    public String toString() {
        return f(this.f25591a);
    }

    public static long b(long j3) {
        return j3;
    }
}
