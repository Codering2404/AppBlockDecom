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
public final class DpSize {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f29984b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f29985c = d(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f29986d = d(9205357640488583168L);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f29987a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return DpSize.f29986d;
        }

        public final long b() {
            return DpSize.f29985c;
        }

        private Companion() {
        }
    }

    private /* synthetic */ DpSize(long j3) {
        this.f29987a = j3;
    }

    public static final /* synthetic */ DpSize c(long j3) {
        return new DpSize(j3);
    }

    public static final long e(long j3, float f3, float f4) {
        return d((((long) Float.floatToRawIntBits(f3)) << 32) | (((long) Float.floatToRawIntBits(f4)) & 4294967295L));
    }

    public static /* synthetic */ long f(long j3, float f3, float f4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f3 = j(j3);
        }
        if ((i3 & 2) != 0) {
            f4 = i(j3);
        }
        return e(j3, f3, f4);
    }

    public static boolean g(long j3, Object obj) {
        return (obj instanceof DpSize) && j3 == ((DpSize) obj).m();
    }

    public static final boolean h(long j3, long j4) {
        return j3 == j4;
    }

    public static final float i(long j3) {
        return Dp.g(Float.intBitsToFloat((int) (j3 & 4294967295L)));
    }

    public static final float j(long j3) {
        return Dp.g(Float.intBitsToFloat((int) (j3 >> 32)));
    }

    public static int k(long j3) {
        return Long.hashCode(j3);
    }

    public static String l(long j3) {
        if (j3 == 9205357640488583168L) {
            return "DpSize.Unspecified";
        }
        return ((Object) Dp.k(j(j3))) + " x " + ((Object) Dp.k(i(j3)));
    }

    public boolean equals(Object obj) {
        return g(this.f29987a, obj);
    }

    public int hashCode() {
        return k(this.f29987a);
    }

    public final /* synthetic */ long m() {
        return this.f29987a;
    }

    public String toString() {
        return l(this.f29987a);
    }

    public static long d(long j3) {
        return j3;
    }
}
