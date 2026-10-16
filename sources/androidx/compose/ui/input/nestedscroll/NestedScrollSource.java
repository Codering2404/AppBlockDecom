package androidx.compose.ui.input.nestedscroll;

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
public final class NestedScrollSource {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f26772b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f26773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f26774d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f26775e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f26776f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f26777g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f26778h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f26779a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return NestedScrollSource.f26774d;
        }

        public final int b() {
            return NestedScrollSource.f26773c;
        }

        private Companion() {
        }
    }

    static {
        int iC = c(1);
        f26773c = iC;
        int iC2 = c(2);
        f26774d = iC2;
        f26775e = iC;
        f26776f = iC2;
        f26777g = c(3);
        f26778h = iC;
    }

    public static boolean d(int i3, Object obj) {
        return (obj instanceof NestedScrollSource) && i3 == ((NestedScrollSource) obj).h();
    }

    public static final boolean e(int i3, int i4) {
        return i3 == i4;
    }

    public static int f(int i3) {
        return Integer.hashCode(i3);
    }

    public static String g(int i3) {
        return e(i3, f26773c) ? "UserInput" : e(i3, f26774d) ? "SideEffect" : e(i3, f26777g) ? "Relocate" : "Invalid";
    }

    public boolean equals(Object obj) {
        return d(this.f26779a, obj);
    }

    public final /* synthetic */ int h() {
        return this.f26779a;
    }

    public int hashCode() {
        return f(this.f26779a);
    }

    public String toString() {
        return g(this.f26779a);
    }

    public static int c(int i3) {
        return i3;
    }
}
