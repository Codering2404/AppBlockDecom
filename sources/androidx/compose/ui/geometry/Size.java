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
public final class Size {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f25617b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f25618c = d(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f25619d = d(9205357640488583168L);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f25620a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return Size.f25619d;
        }

        public final long b() {
            return Size.f25618c;
        }

        private Companion() {
        }
    }

    private /* synthetic */ Size(long j3) {
        this.f25620a = j3;
    }

    public static final /* synthetic */ Size c(long j3) {
        return new Size(j3);
    }

    public static boolean e(long j3, Object obj) {
        return (obj instanceof Size) && j3 == ((Size) obj).m();
    }

    public static final boolean f(long j3, long j4) {
        return j3 == j4;
    }

    public static final float g(long j3) {
        return Float.intBitsToFloat((int) (j3 & 4294967295L));
    }

    public static final float h(long j3) {
        return Math.min(Float.intBitsToFloat((int) ((j3 >> 32) & 2147483647L)), Float.intBitsToFloat((int) (j3 & 2147483647L)));
    }

    public static final float i(long j3) {
        return Float.intBitsToFloat((int) (j3 >> 32));
    }

    public static int j(long j3) {
        return Long.hashCode(j3);
    }

    public static final boolean k(long j3) {
        long j4 = (~((((-9223372034707292160L) & j3) >>> 31) * ((long) (-1)))) & j3;
        return (((j4 & 4294967295L) & (j4 >>> 32)) == 0) | (j3 == 9205357640488583168L);
    }

    public static String l(long j3) {
        if (j3 == 9205357640488583168L) {
            return "Size.Unspecified";
        }
        return "Size(" + GeometryUtilsKt.a(Float.intBitsToFloat((int) (j3 >> 32)), 1) + ", " + GeometryUtilsKt.a(Float.intBitsToFloat((int) (j3 & 4294967295L)), 1) + ')';
    }

    public boolean equals(Object obj) {
        return e(this.f25620a, obj);
    }

    public int hashCode() {
        return j(this.f25620a);
    }

    public final /* synthetic */ long m() {
        return this.f25620a;
    }

    public String toString() {
        return l(this.f25620a);
    }

    public static long d(long j3) {
        return j3;
    }
}
