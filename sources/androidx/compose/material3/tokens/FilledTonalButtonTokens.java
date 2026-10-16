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
public final class FilledTonalButtonTokens {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FilledTonalButtonTokens f22778a = new FilledTonalButtonTokens();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22779b = ColorSchemeKeyTokens.SecondaryContainer;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f22780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f22781d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ShapeKeyTokens f22782e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22783f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final float f22784g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22785h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final float f22786i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22787j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final float f22788k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22789l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22790m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final TypographyKeyTokens f22791n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final float f22792o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22793p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22794q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22795r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22796s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22797t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final float f22798u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22799v;

    static {
        ElevationTokens elevationTokens = ElevationTokens.f22534a;
        f22780c = elevationTokens.a();
        f22781d = Dp.g((float) 40.0d);
        f22782e = ShapeKeyTokens.CornerFull;
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.OnSurface;
        f22783f = colorSchemeKeyTokens;
        f22784g = elevationTokens.a();
        f22785h = colorSchemeKeyTokens;
        f22786i = elevationTokens.a();
        ColorSchemeKeyTokens colorSchemeKeyTokens2 = ColorSchemeKeyTokens.OnSecondaryContainer;
        f22787j = colorSchemeKeyTokens2;
        f22788k = elevationTokens.b();
        f22789l = colorSchemeKeyTokens2;
        f22790m = colorSchemeKeyTokens2;
        f22791n = TypographyKeyTokens.LabelLarge;
        f22792o = elevationTokens.a();
        f22793p = colorSchemeKeyTokens2;
        f22794q = colorSchemeKeyTokens;
        f22795r = colorSchemeKeyTokens2;
        f22796s = colorSchemeKeyTokens2;
        f22797t = colorSchemeKeyTokens2;
        f22798u = Dp.g((float) 18.0d);
        f22799v = colorSchemeKeyTokens2;
    }

    private FilledTonalButtonTokens() {
    }

    public final ColorSchemeKeyTokens a() {
        return f22779b;
    }

    public final float b() {
        return f22780c;
    }

    public final ShapeKeyTokens c() {
        return f22782e;
    }

    public final ColorSchemeKeyTokens d() {
        return f22783f;
    }

    public final ColorSchemeKeyTokens e() {
        return f22785h;
    }

    public final float f() {
        return f22786i;
    }

    public final float g() {
        return f22788k;
    }

    public final ColorSchemeKeyTokens h() {
        return f22790m;
    }

    public final float i() {
        return f22792o;
    }
}
