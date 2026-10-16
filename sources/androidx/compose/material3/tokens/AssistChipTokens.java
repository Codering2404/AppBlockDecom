package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class AssistChipTokens {
    private static final ColorSchemeKeyTokens A;
    private static final ColorSchemeKeyTokens B;
    private static final float C;
    private static final ColorSchemeKeyTokens D;
    private static final ColorSchemeKeyTokens E;
    private static final ColorSchemeKeyTokens F;
    private static final ColorSchemeKeyTokens G;
    private static final float H;
    private static final ColorSchemeKeyTokens I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AssistChipTokens f22294a = new AssistChipTokens();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f22295b = Dp.g((float) 32.0d);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ShapeKeyTokens f22296c = ShapeKeyTokens.CornerSmall;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22297d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f22298e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f22299f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22300g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22301h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final float f22302i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22303j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final float f22304k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final float f22305l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final float f22306m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final float f22307n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final float f22308o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final float f22309p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22310q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final float f22311r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22312s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22313t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final float f22314u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22315v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22316w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22317x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22318y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final TypographyKeyTokens f22319z;

    static {
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.OnSurface;
        f22297d = colorSchemeKeyTokens;
        f22298e = 0.38f;
        ElevationTokens elevationTokens = ElevationTokens.f22534a;
        f22299f = elevationTokens.e();
        f22300g = colorSchemeKeyTokens;
        f22301h = ColorSchemeKeyTokens.SurfaceContainerLow;
        f22302i = elevationTokens.b();
        f22303j = colorSchemeKeyTokens;
        f22304k = elevationTokens.a();
        f22305l = 0.12f;
        f22306m = elevationTokens.b();
        f22307n = elevationTokens.c();
        f22308o = elevationTokens.b();
        f22309p = elevationTokens.a();
        f22310q = colorSchemeKeyTokens;
        f22311r = 0.12f;
        f22312s = colorSchemeKeyTokens;
        f22313t = ColorSchemeKeyTokens.Outline;
        f22314u = Dp.g((float) 1.0d);
        f22315v = ColorSchemeKeyTokens.Secondary;
        f22316w = colorSchemeKeyTokens;
        f22317x = colorSchemeKeyTokens;
        f22318y = colorSchemeKeyTokens;
        f22319z = TypographyKeyTokens.LabelLarge;
        A = colorSchemeKeyTokens;
        B = colorSchemeKeyTokens;
        C = 0.38f;
        ColorSchemeKeyTokens colorSchemeKeyTokens2 = ColorSchemeKeyTokens.Primary;
        D = colorSchemeKeyTokens2;
        E = colorSchemeKeyTokens2;
        F = colorSchemeKeyTokens2;
        G = colorSchemeKeyTokens2;
        H = Dp.g((float) 18.0d);
        I = colorSchemeKeyTokens2;
    }

    private AssistChipTokens() {
    }

    public final float a() {
        return f22295b;
    }

    public final ShapeKeyTokens b() {
        return f22296c;
    }

    public final ColorSchemeKeyTokens c() {
        return B;
    }

    public final float d() {
        return C;
    }

    public final ColorSchemeKeyTokens e() {
        return f22297d;
    }

    public final float f() {
        return f22298e;
    }

    public final float g() {
        return f22299f;
    }

    public final ColorSchemeKeyTokens h() {
        return f22301h;
    }

    public final float i() {
        return f22302i;
    }

    public final ColorSchemeKeyTokens j() {
        return f22303j;
    }

    public final float k() {
        return f22304k;
    }

    public final float l() {
        return f22305l;
    }

    public final float m() {
        return f22306m;
    }

    public final float n() {
        return f22307n;
    }

    public final float o() {
        return f22308o;
    }

    public final float p() {
        return f22309p;
    }

    public final ColorSchemeKeyTokens q() {
        return f22310q;
    }

    public final float r() {
        return f22311r;
    }

    public final ColorSchemeKeyTokens s() {
        return f22313t;
    }

    public final float t() {
        return f22314u;
    }

    public final ColorSchemeKeyTokens u() {
        return G;
    }

    public final float v() {
        return H;
    }

    public final ColorSchemeKeyTokens w() {
        return f22318y;
    }

    public final TypographyKeyTokens x() {
        return f22319z;
    }
}
