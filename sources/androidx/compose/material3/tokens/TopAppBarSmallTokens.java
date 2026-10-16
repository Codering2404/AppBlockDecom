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
public final class TopAppBarSmallTokens {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TopAppBarSmallTokens f23609a = new TopAppBarSmallTokens();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23610b = ColorSchemeKeyTokens.Surface;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f23611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f23612d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ShapeKeyTokens f23613e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23614f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final TypographyKeyTokens f23615g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23616h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final float f23617i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23618j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final float f23619k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23620l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final float f23621m;

    static {
        ElevationTokens elevationTokens = ElevationTokens.f22534a;
        f23611c = elevationTokens.a();
        f23612d = Dp.g((float) 64.0d);
        f23613e = ShapeKeyTokens.CornerNone;
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.OnSurface;
        f23614f = colorSchemeKeyTokens;
        f23615g = TypographyKeyTokens.TitleLarge;
        f23616h = colorSchemeKeyTokens;
        float f3 = (float) 24.0d;
        f23617i = Dp.g(f3);
        f23618j = ColorSchemeKeyTokens.SurfaceContainer;
        f23619k = elevationTokens.c();
        f23620l = ColorSchemeKeyTokens.OnSurfaceVariant;
        f23621m = Dp.g(f3);
    }

    private TopAppBarSmallTokens() {
    }

    public final ColorSchemeKeyTokens a() {
        return f23610b;
    }

    public final float b() {
        return f23612d;
    }

    public final ColorSchemeKeyTokens c() {
        return f23614f;
    }

    public final TypographyKeyTokens d() {
        return f23615g;
    }

    public final ColorSchemeKeyTokens e() {
        return f23616h;
    }

    public final ColorSchemeKeyTokens f() {
        return f23618j;
    }

    public final ColorSchemeKeyTokens g() {
        return f23620l;
    }
}
