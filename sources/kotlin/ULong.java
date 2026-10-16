package kotlin;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
@JvmInline
public final class ULong implements Comparable<ULong> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f139796b = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f139797a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private /* synthetic */ ULong(long j3) {
        this.f139797a = j3;
    }

    public static final /* synthetic */ ULong a(long j3) {
        return new ULong(j3);
    }

    public static boolean c(long j3, Object obj) {
        return (obj instanceof ULong) && j3 == ((ULong) obj).g();
    }

    public static final boolean d(long j3, long j4) {
        return j3 == j4;
    }

    public static int e(long j3) {
        return Long.hashCode(j3);
    }

    public static String f(long j3) {
        return UnsignedKt.f(j3, 10);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ULong uLong) {
        return UnsignedKt.d(g(), uLong.g());
    }

    public boolean equals(Object obj) {
        return c(this.f139797a, obj);
    }

    public final /* synthetic */ long g() {
        return this.f139797a;
    }

    public int hashCode() {
        return e(this.f139797a);
    }

    public String toString() {
        return f(this.f139797a);
    }

    public static long b(long j3) {
        return j3;
    }
}
