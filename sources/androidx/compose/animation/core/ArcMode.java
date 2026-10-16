package androidx.compose.animation.core;

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
public final class ArcMode {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f3871b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f3872c = b(5);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f3873d = b(4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f3874e = b(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f3875a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return ArcMode.f3874e;
        }

        private Companion() {
        }
    }

    public static boolean c(int i3, Object obj) {
        return (obj instanceof ArcMode) && i3 == ((ArcMode) obj).g();
    }

    public static final boolean d(int i3, int i4) {
        return i3 == i4;
    }

    public static int e(int i3) {
        return Integer.hashCode(i3);
    }

    public static String f(int i3) {
        return "ArcMode(value=" + i3 + ')';
    }

    public boolean equals(Object obj) {
        return c(this.f3875a, obj);
    }

    public final /* synthetic */ int g() {
        return this.f3875a;
    }

    public int hashCode() {
        return e(this.f3875a);
    }

    public String toString() {
        return f(this.f3875a);
    }

    public static int b(int i3) {
        return i3;
    }
}
