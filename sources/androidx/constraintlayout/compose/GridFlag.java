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
public final class GridFlag {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f30568b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f30569c = c(false, false, 3, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f30570d = c(true, false, 2, null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f30571e = c(false, true, 1, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f30572a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private static int b(boolean z2, boolean z3) {
        return a((z2 ? 0 : 2) | (z3 ? 1 : 0));
    }

    static /* synthetic */ int c(boolean z2, boolean z3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        if ((i3 & 2) != 0) {
            z3 = false;
        }
        return b(z2, z3);
    }

    public static boolean d(int i3, Object obj) {
        return (obj instanceof GridFlag) && i3 == ((GridFlag) obj).h();
    }

    public static int e(int i3) {
        return Integer.hashCode(i3);
    }

    public static final boolean f(int i3) {
        return (i3 & 2) == 0;
    }

    public static String g(int i3) {
        return "GridFlag(isPlaceLayoutsOnSpansFirst = " + f(i3) + ')';
    }

    public boolean equals(Object obj) {
        return d(this.f30572a, obj);
    }

    public final /* synthetic */ int h() {
        return this.f30572a;
    }

    public int hashCode() {
        return e(this.f30572a);
    }

    public String toString() {
        return g(this.f30572a);
    }

    private static int a(int i3) {
        return i3;
    }
}
