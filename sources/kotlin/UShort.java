package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class UShort implements Comparable<UShort> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f139802b = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final short f139803a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private /* synthetic */ UShort(short s2) {
        this.f139803a = s2;
    }

    public static final /* synthetic */ UShort a(short s2) {
        return new UShort(s2);
    }

    public static boolean c(short s2, Object obj) {
        return (obj instanceof UShort) && s2 == ((UShort) obj).f();
    }

    public static int d(short s2) {
        return Short.hashCode(s2);
    }

    public static String e(short s2) {
        return String.valueOf(s2 & 65535);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UShort uShort) {
        return Intrinsics.compare(f() & 65535, uShort.f() & 65535);
    }

    public boolean equals(Object obj) {
        return c(this.f139803a, obj);
    }

    public final /* synthetic */ short f() {
        return this.f139803a;
    }

    public int hashCode() {
        return d(this.f139803a);
    }

    public String toString() {
        return e(this.f139803a);
    }

    public static short b(short s2) {
        return s2;
    }
}
