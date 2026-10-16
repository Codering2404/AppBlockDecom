package androidx.compose.ui.unit;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@JvmInline
public final class Velocity {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f30015b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f30016c = c(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f30017a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return Velocity.f30016c;
        }

        private Companion() {
        }
    }

    private /* synthetic */ Velocity(long j3) {
        this.f30017a = j3;
    }

    public static final /* synthetic */ Velocity b(long j3) {
        return new Velocity(j3);
    }

    public static final long d(long j3, float f3, float f4) {
        return c((((long) Float.floatToRawIntBits(f3)) << 32) | (((long) Float.floatToRawIntBits(f4)) & 4294967295L));
    }

    public static /* synthetic */ long e(long j3, float f3, float f4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f3 = Float.intBitsToFloat((int) (j3 >> 32));
        }
        if ((i3 & 2) != 0) {
            f4 = Float.intBitsToFloat((int) (4294967295L & j3));
        }
        return d(j3, f3, f4);
    }

    public static boolean f(long j3, Object obj) {
        return (obj instanceof Velocity) && j3 == ((Velocity) obj).o();
    }

    public static final boolean g(long j3, long j4) {
        return j3 == j4;
    }

    public static final float h(long j3) {
        return Float.intBitsToFloat((int) (j3 >> 32));
    }

    public static final float i(long j3) {
        return Float.intBitsToFloat((int) (j3 & 4294967295L));
    }

    public static int j(long j3) {
        return Long.hashCode(j3);
    }

    public static final long k(long j3, long j4) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j3 >> 32)) - Float.intBitsToFloat((int) (j4 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j3 & 4294967295L)) - Float.intBitsToFloat((int) (j4 & 4294967295L));
        return c((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L));
    }

    public static final long l(long j3, long j4) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j3 >> 32)) + Float.intBitsToFloat((int) (j4 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j3 & 4294967295L)) + Float.intBitsToFloat((int) (j4 & 4294967295L));
        return c((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L));
    }

    public static final long m(long j3, float f3) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j3 >> 32)) * f3;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j3 & 4294967295L)) * f3;
        return c((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L));
    }

    public static String n(long j3) {
        return '(' + h(j3) + ", " + i(j3) + ") px/sec";
    }

    public boolean equals(Object obj) {
        return f(this.f30017a, obj);
    }

    public int hashCode() {
        return j(this.f30017a);
    }

    public final /* synthetic */ long o() {
        return this.f30017a;
    }

    public String toString() {
        return n(this.f30017a);
    }

    public static long c(long j3) {
        return j3;
    }
}
