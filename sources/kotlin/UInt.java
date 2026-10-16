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
public final class UInt implements Comparable<UInt> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f139791b = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f139792a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private /* synthetic */ UInt(int i3) {
        this.f139792a = i3;
    }

    public static final /* synthetic */ UInt a(int i3) {
        return new UInt(i3);
    }

    public static boolean c(int i3, Object obj) {
        return (obj instanceof UInt) && i3 == ((UInt) obj).f();
    }

    public static int d(int i3) {
        return Integer.hashCode(i3);
    }

    public static String e(int i3) {
        return String.valueOf(((long) i3) & 4294967295L);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UInt uInt) {
        return UnsignedKt.b(f(), uInt.f());
    }

    public boolean equals(Object obj) {
        return c(this.f139792a, obj);
    }

    public final /* synthetic */ int f() {
        return this.f139792a;
    }

    public int hashCode() {
        return d(this.f139792a);
    }

    public String toString() {
        return e(this.f139792a);
    }

    public static int b(int i3) {
        return i3;
    }
}
