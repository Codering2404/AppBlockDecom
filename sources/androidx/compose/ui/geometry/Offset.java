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
public final class Offset {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f25596b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f25597c = e(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f25598d = e(9187343241974906880L);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f25599e = e(9205357640488583168L);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f25600a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return Offset.f25598d;
        }

        public final long b() {
            return Offset.f25599e;
        }

        public final long c() {
            return Offset.f25597c;
        }

        private Companion() {
        }
    }

    private /* synthetic */ Offset(long j3) {
        this.f25600a = j3;
    }

    public static final /* synthetic */ Offset d(long j3) {
        return new Offset(j3);
    }

    public static final long f(long j3, float f3, float f4) {
        return e((((long) Float.floatToRawIntBits(f3)) << 32) | (((long) Float.floatToRawIntBits(f4)) & 4294967295L));
    }

    public static /* synthetic */ long g(long j3, float f3, float f4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f3 = Float.intBitsToFloat((int) (j3 >> 32));
        }
        if ((i3 & 2) != 0) {
            f4 = Float.intBitsToFloat((int) (4294967295L & j3));
        }
        return f(j3, f3, f4);
    }

    public static final long h(long j3, float f3) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j3 >> 32)) / f3;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j3 & 4294967295L)) / f3;
        return e((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L));
    }

    public static boolean i(long j3, Object obj) {
        return (obj instanceof Offset) && j3 == ((Offset) obj).u();
    }

    public static final boolean j(long j3, long j4) {
        return j3 == j4;
    }

    public static final float k(long j3) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j3 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j3 & 4294967295L));
        return (float) Math.sqrt((fIntBitsToFloat * fIntBitsToFloat) + (fIntBitsToFloat2 * fIntBitsToFloat2));
    }

    public static final float l(long j3) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j3 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j3 & 4294967295L));
        return (fIntBitsToFloat * fIntBitsToFloat) + (fIntBitsToFloat2 * fIntBitsToFloat2);
    }

    public static final float m(long j3) {
        return Float.intBitsToFloat((int) (j3 >> 32));
    }

    public static final float n(long j3) {
        return Float.intBitsToFloat((int) (j3 & 4294967295L));
    }

    public static int o(long j3) {
        return Long.hashCode(j3);
    }

    public static final long p(long j3, long j4) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j3 >> 32)) - Float.intBitsToFloat((int) (j4 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j3 & 4294967295L)) - Float.intBitsToFloat((int) (j4 & 4294967295L));
        return e((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L));
    }

    public static final long q(long j3, long j4) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j3 >> 32)) + Float.intBitsToFloat((int) (j4 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j3 & 4294967295L)) + Float.intBitsToFloat((int) (j4 & 4294967295L));
        return e((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L));
    }

    public static final long r(long j3, float f3) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j3 >> 32)) * f3;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j3 & 4294967295L)) * f3;
        return e((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L));
    }

    public static String s(long j3) {
        if ((9223372034707292159L & j3) == 9205357640488583168L) {
            return "Offset.Unspecified";
        }
        return "Offset(" + GeometryUtilsKt.a(Float.intBitsToFloat((int) (j3 >> 32)), 1) + ", " + GeometryUtilsKt.a(Float.intBitsToFloat((int) (j3 & 4294967295L)), 1) + ')';
    }

    public static final long t(long j3) {
        return e(j3 ^ (-9223372034707292160L));
    }

    public boolean equals(Object obj) {
        return i(this.f25600a, obj);
    }

    public int hashCode() {
        return o(this.f25600a);
    }

    public String toString() {
        return s(this.f25600a);
    }

    public final /* synthetic */ long u() {
        return this.f25600a;
    }

    public static long e(long j3) {
        return j3;
    }
}
