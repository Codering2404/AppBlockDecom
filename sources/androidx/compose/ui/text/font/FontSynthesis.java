package androidx.compose.ui.text.font;

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
public final class FontSynthesis {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f29215b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f29216c = f(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f29217d = f(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f29218e = f(2);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f29219f = f(65535);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f29220a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return FontSynthesis.f29219f;
        }

        public final int b() {
            return FontSynthesis.f29216c;
        }

        public final int c() {
            return FontSynthesis.f29218e;
        }

        public final int d() {
            return FontSynthesis.f29217d;
        }

        private Companion() {
        }
    }

    private /* synthetic */ FontSynthesis(int i3) {
        this.f29220a = i3;
    }

    public static final /* synthetic */ FontSynthesis e(int i3) {
        return new FontSynthesis(i3);
    }

    public static boolean g(int i3, Object obj) {
        return (obj instanceof FontSynthesis) && i3 == ((FontSynthesis) obj).m();
    }

    public static final boolean h(int i3, int i4) {
        return i3 == i4;
    }

    public static int i(int i3) {
        return Integer.hashCode(i3);
    }

    public static final boolean j(int i3) {
        return (i3 & 2) != 0;
    }

    public static final boolean k(int i3) {
        return (i3 & 1) != 0;
    }

    public static String l(int i3) {
        return h(i3, f29216c) ? "None" : h(i3, f29217d) ? "Weight" : h(i3, f29218e) ? "Style" : h(i3, f29219f) ? "All" : "Invalid";
    }

    public boolean equals(Object obj) {
        return g(this.f29220a, obj);
    }

    public int hashCode() {
        return i(this.f29220a);
    }

    public final /* synthetic */ int m() {
        return this.f29220a;
    }

    public String toString() {
        return l(this.f29220a);
    }

    public static int f(int i3) {
        return i3;
    }
}
