package androidx.compose.foundation.layout;

import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@JvmInline
public final class WindowInsetsSides {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f7284b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f7285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f7286d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f7287e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f7288f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f7289g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f7290h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f7291i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f7292j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f7293k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f7294l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f7295m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f7296n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f7297a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return WindowInsetsSides.f7285c;
        }

        public final int b() {
            return WindowInsetsSides.f7287e;
        }

        public final int c() {
            return WindowInsetsSides.f7286d;
        }

        public final int d() {
            return WindowInsetsSides.f7288f;
        }

        public final int e() {
            return WindowInsetsSides.f7292j;
        }

        public final int f() {
            return WindowInsetsSides.f7290h;
        }

        public final int g() {
            return WindowInsetsSides.f7295m;
        }

        public final int h() {
            return WindowInsetsSides.f7293k;
        }

        public final int i() {
            return WindowInsetsSides.f7294l;
        }

        public final int j() {
            return WindowInsetsSides.f7289g;
        }

        public final int k() {
            return WindowInsetsSides.f7291i;
        }

        public final int l() {
            return WindowInsetsSides.f7296n;
        }

        private Companion() {
        }
    }

    static {
        int iM = m(8);
        f7285c = iM;
        int iM2 = m(4);
        f7286d = iM2;
        int iM3 = m(2);
        f7287e = iM3;
        int iM4 = m(1);
        f7288f = iM4;
        f7289g = r(iM, iM4);
        f7290h = r(iM2, iM3);
        int iM5 = m(16);
        f7291i = iM5;
        int iM6 = m(32);
        f7292j = iM6;
        int iR = r(iM, iM3);
        f7293k = iR;
        int iR2 = r(iM2, iM4);
        f7294l = iR2;
        f7295m = r(iR, iR2);
        f7296n = r(iM5, iM6);
    }

    public static boolean n(int i3, Object obj) {
        return (obj instanceof WindowInsetsSides) && i3 == ((WindowInsetsSides) obj).t();
    }

    public static final boolean o(int i3, int i4) {
        return i3 == i4;
    }

    public static final boolean p(int i3, int i4) {
        return (i3 & i4) != 0;
    }

    public static int q(int i3) {
        return Integer.hashCode(i3);
    }

    public static final int r(int i3, int i4) {
        return m(i3 | i4);
    }

    public static String s(int i3) {
        return "WindowInsetsSides(" + u(i3) + ')';
    }

    private static final String u(int i3) {
        StringBuilder sb = new StringBuilder();
        int i4 = f7289g;
        if ((i3 & i4) == i4) {
            v(sb, "Start");
        }
        int i5 = f7293k;
        if ((i3 & i5) == i5) {
            v(sb, "Left");
        }
        int i6 = f7291i;
        if ((i3 & i6) == i6) {
            v(sb, "Top");
        }
        int i7 = f7290h;
        if ((i3 & i7) == i7) {
            v(sb, "End");
        }
        int i8 = f7294l;
        if ((i3 & i8) == i8) {
            v(sb, "Right");
        }
        int i9 = f7292j;
        if ((i3 & i9) == i9) {
            v(sb, "Bottom");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private static final void v(StringBuilder sb, String str) {
        if (sb.length() > 0) {
            sb.append('+');
        }
        sb.append(str);
    }

    public boolean equals(Object obj) {
        return n(this.f7297a, obj);
    }

    public int hashCode() {
        return q(this.f7297a);
    }

    public final /* synthetic */ int t() {
        return this.f7297a;
    }

    public String toString() {
        return s(this.f7297a);
    }

    private static int m(int i3) {
        return i3;
    }
}
