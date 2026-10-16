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
public final class DpOffset {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f29975b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f29976c = c(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f29977d = c(9205357640488583168L);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f29978a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return DpOffset.f29976c;
        }

        private Companion() {
        }
    }

    private /* synthetic */ DpOffset(long j3) {
        this.f29978a = j3;
    }

    public static final /* synthetic */ DpOffset b(long j3) {
        return new DpOffset(j3);
    }

    public static boolean d(long j3, Object obj) {
        return (obj instanceof DpOffset) && j3 == ((DpOffset) obj).j();
    }

    public static final boolean e(long j3, long j4) {
        return j3 == j4;
    }

    public static final float f(long j3) {
        return Dp.g(Float.intBitsToFloat((int) (j3 >> 32)));
    }

    public static final float g(long j3) {
        return Dp.g(Float.intBitsToFloat((int) (j3 & 4294967295L)));
    }

    public static int h(long j3) {
        return Long.hashCode(j3);
    }

    public static String i(long j3) {
        if (j3 == 9205357640488583168L) {
            return "DpOffset.Unspecified";
        }
        return '(' + ((Object) Dp.k(f(j3))) + ", " + ((Object) Dp.k(g(j3))) + ')';
    }

    public boolean equals(Object obj) {
        return d(this.f29978a, obj);
    }

    public int hashCode() {
        return h(this.f29978a);
    }

    public final /* synthetic */ long j() {
        return this.f29978a;
    }

    public String toString() {
        return i(this.f29978a);
    }

    public static long c(long j3) {
        return j3;
    }
}
