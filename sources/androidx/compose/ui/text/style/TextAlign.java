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
public final class TextAlign {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f29616b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f29617c = i(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f29618d = i(2);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f29619e = i(3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f29620f = i(4);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f29621g = i(5);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f29622h = i(6);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f29623i = i(Integer.MIN_VALUE);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f29624a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return TextAlign.f29619e;
        }

        public final int b() {
            return TextAlign.f29622h;
        }

        public final int c() {
            return TextAlign.f29620f;
        }

        public final int d() {
            return TextAlign.f29617c;
        }

        public final int e() {
            return TextAlign.f29618d;
        }

        public final int f() {
            return TextAlign.f29621g;
        }

        public final int g() {
            return TextAlign.f29623i;
        }

        private Companion() {
        }
    }

    private /* synthetic */ TextAlign(int i3) {
        this.f29624a = i3;
    }

    public static final /* synthetic */ TextAlign h(int i3) {
        return new TextAlign(i3);
    }

    public static boolean j(int i3, Object obj) {
        return (obj instanceof TextAlign) && i3 == ((TextAlign) obj).n();
    }

    public static final boolean k(int i3, int i4) {
        return i3 == i4;
    }

    public static int l(int i3) {
        return Integer.hashCode(i3);
    }

    public static String m(int i3) {
        return k(i3, f29617c) ? "Left" : k(i3, f29618d) ? "Right" : k(i3, f29619e) ? "Center" : k(i3, f29620f) ? "Justify" : k(i3, f29621g) ? "Start" : k(i3, f29622h) ? "End" : k(i3, f29623i) ? "Unspecified" : "Invalid";
    }

    public boolean equals(Object obj) {
        return j(this.f29624a, obj);
    }

    public int hashCode() {
        return l(this.f29624a);
    }

    public final /* synthetic */ int n() {
        return this.f29624a;
    }

    public String toString() {
        return m(this.f29624a);
    }

    public static int i(int i3) {
        return i3;
    }
}
