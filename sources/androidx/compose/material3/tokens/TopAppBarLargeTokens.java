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
public final class TopAppBarLargeTokens {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TopAppBarLargeTokens f23569a = new TopAppBarLargeTokens();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23570b = ColorSchemeKeyTokens.Surface;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f23571c = ElevationTokens.f22534a.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f23572d = Dp.g((float) 152.0d);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ShapeKeyTokens f23573e = ShapeKeyTokens.CornerNone;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23574f = ColorSchemeKeyTokens.SurfaceTint;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23575g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final TypographyKeyTokens f23576h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23577i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final float f23578j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23579k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final float f23580l;

    static {
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.OnSurface;
        f23575g = colorSchemeKeyTokens;
        f23576h = TypographyKeyTokens.HeadlineMedium;
        f23577i = colorSchemeKeyTokens;
        float f3 = (float) 24.0d;
        f23578j = Dp.g(f3);
        f23579k = ColorSchemeKeyTokens.OnSurfaceVariant;
        f23580l = Dp.g(f3);
    }

    private TopAppBarLargeTokens() {
    }

    public final ColorSchemeKeyTokens a() {
        return f23570b;
    }

    public final float b() {
        return f23572d;
    }

    public final ColorSchemeKeyTokens c() {
        return f23575g;
    }

    public final TypographyKeyTokens d() {
        return f23576h;
    }

    public final ColorSchemeKeyTokens e() {
        return f23577i;
    }

    public final ColorSchemeKeyTokens f() {
        return f23579k;
    }
}
