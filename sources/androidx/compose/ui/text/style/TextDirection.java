package androidx.compose.ui.text.style;

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
public final class TextDirection {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f29630b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f29631c = h(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f29632d = h(2);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f29633e = h(3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f29634f = h(4);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f29635g = h(5);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f29636h = h(Integer.MIN_VALUE);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f29637a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return TextDirection.f29633e;
        }

        public final int b() {
            return TextDirection.f29634f;
        }

        public final int c() {
            return TextDirection.f29635g;
        }

        public final int d() {
            return TextDirection.f29631c;
        }

        public final int e() {
            return TextDirection.f29632d;
        }

        public final int f() {
            return TextDirection.f29636h;
        }

        private Companion() {
        }
    }

    private /* synthetic */ TextDirection(int i3) {
        this.f29637a = i3;
    }

    public static final /* synthetic */ TextDirection g(int i3) {
        return new TextDirection(i3);
    }

    public static boolean i(int i3, Object obj) {
        return (obj instanceof TextDirection) && i3 == ((TextDirection) obj).m();
    }

    public static final boolean j(int i3, int i4) {
        return i3 == i4;
    }

    public static int k(int i3) {
        return Integer.hashCode(i3);
    }

    public static String l(int i3) {
        return j(i3, f29631c) ? "Ltr" : j(i3, f29632d) ? "Rtl" : j(i3, f29633e) ? "Content" : j(i3, f29634f) ? "ContentOrLtr" : j(i3, f29635g) ? "ContentOrRtl" : j(i3, f29636h) ? "Unspecified" : "Invalid";
    }

    public boolean equals(Object obj) {
        return i(this.f29637a, obj);
    }

    public int hashCode() {
        return k(this.f29637a);
    }

    public final /* synthetic */ int m() {
        return this.f29637a;
    }

    public String toString() {
        return l(this.f29637a);
    }

    public static int h(int i3) {
        return i3;
    }
}
