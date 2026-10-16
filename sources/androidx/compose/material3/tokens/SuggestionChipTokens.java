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
public final class SuggestionChipTokens {
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
    public static final SuggestionChipTokens f23441a = new SuggestionChipTokens();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f23442b = Dp.g((float) 32.0d);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ShapeKeyTokens f23443c = ShapeKeyTokens.CornerSmall;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23444d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f23445e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f23446f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23447g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23448h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final float f23449i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23450j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final float f23451k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final float f23452l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final float f23453m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final float f23454n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final float f23455o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final float f23456p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23457q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final float f23458r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23459s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23460t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final float f23461u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23462v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23463w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23464x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23465y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final TypographyKeyTokens f23466z;

    static {
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.OnSurface;
        f23444d = colorSchemeKeyTokens;
        f23445e = 0.38f;
        ElevationTokens elevationTokens = ElevationTokens.f22534a;
        f23446f = elevationTokens.e();
        ColorSchemeKeyTokens colorSchemeKeyTokens2 = ColorSchemeKeyTokens.OnSurfaceVariant;
        f23447g = colorSchemeKeyTokens2;
        f23448h = ColorSchemeKeyTokens.SurfaceContainerLow;
        f23449i = elevationTokens.b();
        f23450j = colorSchemeKeyTokens;
        f23451k = elevationTokens.a();
        f23452l = 0.12f;
        f23453m = elevationTokens.b();
        f23454n = elevationTokens.c();
        f23455o = elevationTokens.b();
        f23456p = elevationTokens.a();
        f23457q = colorSchemeKeyTokens;
        f23458r = 0.12f;
        f23459s = colorSchemeKeyTokens2;
        f23460t = ColorSchemeKeyTokens.Outline;
        f23461u = Dp.g((float) 1.0d);
        f23462v = ColorSchemeKeyTokens.Secondary;
        f23463w = colorSchemeKeyTokens2;
        f23464x = colorSchemeKeyTokens2;
        f23465y = colorSchemeKeyTokens2;
        f23466z = TypographyKeyTokens.LabelLarge;
        A = colorSchemeKeyTokens2;
        B = colorSchemeKeyTokens;
        C = 0.38f;
        ColorSchemeKeyTokens colorSchemeKeyTokens3 = ColorSchemeKeyTokens.Primary;
        D = colorSchemeKeyTokens3;
        E = colorSchemeKeyTokens3;
        F = colorSchemeKeyTokens3;
        G = colorSchemeKeyTokens3;
        H = Dp.g((float) 18.0d);
        I = colorSchemeKeyTokens3;
    }

    private SuggestionChipTokens() {
    }

    public final float a() {
        return f23442b;
    }

    public final ShapeKeyTokens b() {
        return f23443c;
    }

    public final ColorSchemeKeyTokens c() {
        return f23444d;
    }

    public final float d() {
        return f23445e;
    }

    public final ColorSchemeKeyTokens e() {
        return B;
    }

    public final float f() {
        return C;
    }

    public final float g() {
        return f23446f;
    }

    public final ColorSchemeKeyTokens h() {
        return f23448h;
    }

    public final float i() {
        return f23449i;
    }

    public final ColorSchemeKeyTokens j() {
        return f23450j;
    }

    public final float k() {
        return f23451k;
    }

    public final float l() {
        return f23453m;
    }

    public final float m() {
        return f23454n;
    }

    public final float n() {
        return f23455o;
    }

    public final float o() {
        return f23456p;
    }

    public final ColorSchemeKeyTokens p() {
        return f23457q;
    }

    public final float q() {
        return f23458r;
    }

    public final ColorSchemeKeyTokens r() {
        return f23460t;
    }

    public final float s() {
        return f23461u;
    }

    public final ColorSchemeKeyTokens t() {
        return f23465y;
    }

    public final TypographyKeyTokens u() {
        return f23466z;
    }

    public final ColorSchemeKeyTokens v() {
        return G;
    }

    public final float w() {
        return H;
    }
}
