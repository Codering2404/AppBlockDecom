package androidx.constraintlayout.compose;

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
public final class DebugFlags {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f30525b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f30526c = b(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f30527d = b(-1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f30528a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return DebugFlags.f30526c;
        }

        private Companion() {
        }
    }

    public static boolean c(int i3, Object obj) {
        return (obj instanceof DebugFlags) && i3 == ((DebugFlags) obj).i();
    }

    public static final boolean d(int i3) {
        return (i3 & 1) > 0;
    }

    public static final boolean e(int i3) {
        return (i3 & 4) > 0;
    }

    public static final boolean f(int i3) {
        return (i3 & 2) > 0;
    }

    public static int g(int i3) {
        return Integer.hashCode(i3);
    }

    public static String h(int i3) {
        return "DebugFlags(showBounds = " + d(i3) + ", showPaths = " + f(i3) + ", showKeyPositions = " + e(i3) + ')';
    }

    public boolean equals(Object obj) {
        return c(this.f30528a, obj);
    }

    public int hashCode() {
        return g(this.f30528a);
    }

    public final /* synthetic */ int i() {
        return this.f30528a;
    }

    public String toString() {
        return h(this.f30528a);
    }

    public static int b(int i3) {
        return i3;
    }
}
