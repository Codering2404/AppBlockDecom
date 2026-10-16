package androidx.compose.ui.graphics;

import com.facebook.internal.AnalyticsEvents;
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
public final class BlendMode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f25692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f25667b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f25668c = D(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f25669d = D(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f25670e = D(2);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f25671f = D(3);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f25672g = D(4);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f25673h = D(5);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f25674i = D(6);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f25675j = D(7);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f25676k = D(8);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f25677l = D(9);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f25678m = D(10);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f25679n = D(11);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f25680o = D(12);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f25681p = D(13);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int f25682q = D(14);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int f25683r = D(15);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int f25684s = D(16);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final int f25685t = D(17);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final int f25686u = D(18);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final int f25687v = D(19);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final int f25688w = D(20);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final int f25689x = D(21);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final int f25690y = D(22);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final int f25691z = D(23);
    private static final int A = D(24);
    private static final int B = D(25);
    private static final int C = D(26);
    private static final int D = D(27);
    private static final int E = D(28);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int A() {
            return BlendMode.f25675j;
        }

        public final int B() {
            return BlendMode.f25671f;
        }

        public final int C() {
            return BlendMode.f25679n;
        }

        public final int a() {
            return BlendMode.f25668c;
        }

        public final int b() {
            return BlendMode.D;
        }

        public final int c() {
            return BlendMode.f25687v;
        }

        public final int d() {
            return BlendMode.f25686u;
        }

        public final int e() {
            return BlendMode.f25684s;
        }

        public final int f() {
            return BlendMode.f25690y;
        }

        public final int g() {
            return BlendMode.f25670e;
        }

        public final int h() {
            return BlendMode.f25678m;
        }

        public final int i() {
            return BlendMode.f25674i;
        }

        public final int j() {
            return BlendMode.f25676k;
        }

        public final int k() {
            return BlendMode.f25672g;
        }

        public final int l() {
            return BlendMode.f25691z;
        }

        public final int m() {
            return BlendMode.f25688w;
        }

        public final int n() {
            return BlendMode.B;
        }

        public final int o() {
            return BlendMode.f25685t;
        }

        public final int p() {
            return BlendMode.E;
        }

        public final int q() {
            return BlendMode.f25681p;
        }

        public final int r() {
            return BlendMode.A;
        }

        public final int s() {
            return BlendMode.f25683r;
        }

        public final int t() {
            return BlendMode.f25680o;
        }

        public final int u() {
            return BlendMode.C;
        }

        public final int v() {
            return BlendMode.f25682q;
        }

        public final int w() {
            return BlendMode.f25689x;
        }

        public final int x() {
            return BlendMode.f25669d;
        }

        public final int y() {
            return BlendMode.f25677l;
        }

        public final int z() {
            return BlendMode.f25673h;
        }

        private Companion() {
        }
    }

    public static boolean E(int i3, Object obj) {
        return (obj instanceof BlendMode) && i3 == ((BlendMode) obj).I();
    }

    public static final boolean F(int i3, int i4) {
        return i3 == i4;
    }

    public static int G(int i3) {
        return Integer.hashCode(i3);
    }

    public static String H(int i3) {
        return F(i3, f25668c) ? "Clear" : F(i3, f25669d) ? "Src" : F(i3, f25670e) ? "Dst" : F(i3, f25671f) ? "SrcOver" : F(i3, f25672g) ? "DstOver" : F(i3, f25673h) ? "SrcIn" : F(i3, f25674i) ? "DstIn" : F(i3, f25675j) ? "SrcOut" : F(i3, f25676k) ? "DstOut" : F(i3, f25677l) ? "SrcAtop" : F(i3, f25678m) ? "DstAtop" : F(i3, f25679n) ? "Xor" : F(i3, f25680o) ? "Plus" : F(i3, f25681p) ? "Modulate" : F(i3, f25682q) ? "Screen" : F(i3, f25683r) ? "Overlay" : F(i3, f25684s) ? "Darken" : F(i3, f25685t) ? "Lighten" : F(i3, f25686u) ? "ColorDodge" : F(i3, f25687v) ? "ColorBurn" : F(i3, f25688w) ? "HardLight" : F(i3, f25689x) ? "Softlight" : F(i3, f25690y) ? "Difference" : F(i3, f25691z) ? "Exclusion" : F(i3, A) ? "Multiply" : F(i3, B) ? "Hue" : F(i3, C) ? "Saturation" : F(i3, D) ? "Color" : F(i3, E) ? "Luminosity" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }

    public final /* synthetic */ int I() {
        return this.f25692a;
    }

    public boolean equals(Object obj) {
        return E(this.f25692a, obj);
    }

    public int hashCode() {
        return G(this.f25692a);
    }

    public String toString() {
        return H(this.f25692a);
    }

    public static int D(int i3) {
        return i3;
    }
}
