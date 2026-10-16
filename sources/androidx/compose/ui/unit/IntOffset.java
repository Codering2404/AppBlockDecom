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
public final class IntOffset {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f29988b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f29989c = f(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f29990d = f(9223372034707292159L);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f29991a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return IntOffset.f29990d;
        }

        public final long b() {
            return IntOffset.f29989c;
        }

        private Companion() {
        }
    }

    private /* synthetic */ IntOffset(long j3) {
        this.f29991a = j3;
    }

    public static final /* synthetic */ IntOffset c(long j3) {
        return new IntOffset(j3);
    }

    public static final int d(long j3) {
        return k(j3);
    }

    public static final int e(long j3) {
        return l(j3);
    }

    public static final long g(long j3, int i3, int i4) {
        return f((((long) i3) << 32) | (((long) i4) & 4294967295L));
    }

    public static /* synthetic */ long h(long j3, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i3 = (int) (j3 >> 32);
        }
        if ((i5 & 2) != 0) {
            i4 = (int) (4294967295L & j3);
        }
        return g(j3, i3, i4);
    }

    public static boolean i(long j3, Object obj) {
        return (obj instanceof IntOffset) && j3 == ((IntOffset) obj).r();
    }

    public static final boolean j(long j3, long j4) {
        return j3 == j4;
    }

    public static final int k(long j3) {
        return (int) (j3 >> 32);
    }

    public static final int l(long j3) {
        return (int) (j3 & 4294967295L);
    }

    public static int m(long j3) {
        return Long.hashCode(j3);
    }

    public static final long n(long j3, long j4) {
        return f((((long) (((int) (j3 >> 32)) - ((int) (j4 >> 32)))) << 32) | (((long) (((int) (j3 & 4294967295L)) - ((int) (j4 & 4294967295L)))) & 4294967295L));
    }

    public static final long o(long j3, long j4) {
        return f((((long) (((int) (j3 >> 32)) + ((int) (j4 >> 32)))) << 32) | (((long) (((int) (j3 & 4294967295L)) + ((int) (j4 & 4294967295L)))) & 4294967295L));
    }

    public static String p(long j3) {
        return '(' + k(j3) + ", " + l(j3) + ')';
    }

    public static final long q(long j3) {
        int i3 = -((int) (j3 >> 32));
        return f((((long) (-((int) (j3 & 4294967295L)))) & 4294967295L) | (((long) i3) << 32));
    }

    public boolean equals(Object obj) {
        return i(this.f29991a, obj);
    }

    public int hashCode() {
        return m(this.f29991a);
    }

    public final /* synthetic */ long r() {
        return this.f29991a;
    }

    public String toString() {
        return p(this.f29991a);
    }

    public static long f(long j3) {
        return j3;
    }
}
