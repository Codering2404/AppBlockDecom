package androidx.compose.ui.text;

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
public final class PlaceholderVerticalAlign {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f28756b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f28757c = h(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f28758d = h(2);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f28759e = h(3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f28760f = h(4);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f28761g = h(5);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f28762h = h(6);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f28763i = h(7);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f28764a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return PlaceholderVerticalAlign.f28757c;
        }

        public final int b() {
            return PlaceholderVerticalAlign.f28759e;
        }

        public final int c() {
            return PlaceholderVerticalAlign.f28760f;
        }

        public final int d() {
            return PlaceholderVerticalAlign.f28762h;
        }

        public final int e() {
            return PlaceholderVerticalAlign.f28763i;
        }

        public final int f() {
            return PlaceholderVerticalAlign.f28761g;
        }

        public final int g() {
            return PlaceholderVerticalAlign.f28758d;
        }

        private Companion() {
        }
    }

    public static boolean i(int i3, Object obj) {
        return (obj instanceof PlaceholderVerticalAlign) && i3 == ((PlaceholderVerticalAlign) obj).m();
    }

    public static final boolean j(int i3, int i4) {
        return i3 == i4;
    }

    public static int k(int i3) {
        return Integer.hashCode(i3);
    }

    public static String l(int i3) {
        return j(i3, f28757c) ? "AboveBaseline" : j(i3, f28758d) ? "Top" : j(i3, f28759e) ? "Bottom" : j(i3, f28760f) ? "Center" : j(i3, f28761g) ? "TextTop" : j(i3, f28762h) ? "TextBottom" : j(i3, f28763i) ? "TextCenter" : "Invalid";
    }

    public boolean equals(Object obj) {
        return i(this.f28764a, obj);
    }

    public int hashCode() {
        return k(this.f28764a);
    }

    public final /* synthetic */ int m() {
        return this.f28764a;
    }

    public String toString() {
        return l(this.f28764a);
    }

    public static int h(int i3) {
        return i3;
    }
}
