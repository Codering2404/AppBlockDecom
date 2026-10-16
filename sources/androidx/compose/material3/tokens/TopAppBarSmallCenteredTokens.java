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
public final class TopAppBarSmallCenteredTokens {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TopAppBarSmallCenteredTokens f23593a = new TopAppBarSmallCenteredTokens();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ShapeKeyTokens f23594b = ShapeKeyTokens.CornerFull;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f23595c = Dp.g((float) 30.0d);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23596d = ColorSchemeKeyTokens.Surface;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f23597e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f23598f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ShapeKeyTokens f23599g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23600h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23601i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final TypographyKeyTokens f23602j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23603k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final float f23604l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23605m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final float f23606n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23607o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final float f23608p;

    static {
        ElevationTokens elevationTokens = ElevationTokens.f22534a;
        f23597e = elevationTokens.a();
        f23598f = Dp.g((float) 64.0d);
        f23599g = ShapeKeyTokens.CornerNone;
        f23600h = ColorSchemeKeyTokens.SurfaceTint;
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.OnSurface;
        f23601i = colorSchemeKeyTokens;
        f23602j = TypographyKeyTokens.TitleLarge;
        f23603k = colorSchemeKeyTokens;
        float f3 = (float) 24.0d;
        f23604l = Dp.g(f3);
        f23605m = ColorSchemeKeyTokens.SurfaceContainer;
        f23606n = elevationTokens.c();
        f23607o = ColorSchemeKeyTokens.OnSurfaceVariant;
        f23608p = Dp.g(f3);
    }

    private TopAppBarSmallCenteredTokens() {
    }

    public final ColorSchemeKeyTokens a() {
        return f23596d;
    }

    public final ColorSchemeKeyTokens b() {
        return f23601i;
    }

    public final ColorSchemeKeyTokens c() {
        return f23603k;
    }

    public final ColorSchemeKeyTokens d() {
        return f23605m;
    }

    public final ColorSchemeKeyTokens e() {
        return f23607o;
    }
}
