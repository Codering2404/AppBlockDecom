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
public final class SearchViewTokens {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SearchViewTokens f23329a = new SearchViewTokens();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23330b = ColorSchemeKeyTokens.SurfaceContainerHigh;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f23331c = ElevationTokens.f22534a.d();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23332d = ColorSchemeKeyTokens.Outline;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ShapeKeyTokens f23333e = ShapeKeyTokens.CornerExtraLarge;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f23334f = Dp.g((float) 56.0d);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ShapeKeyTokens f23335g = ShapeKeyTokens.CornerNone;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final float f23336h = Dp.g((float) 72.0d);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23337i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final TypographyKeyTokens f23338j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23339k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23340l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final TypographyKeyTokens f23341m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23342n;

    static {
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.OnSurface;
        f23337i = colorSchemeKeyTokens;
        TypographyKeyTokens typographyKeyTokens = TypographyKeyTokens.BodyLarge;
        f23338j = typographyKeyTokens;
        f23339k = colorSchemeKeyTokens;
        ColorSchemeKeyTokens colorSchemeKeyTokens2 = ColorSchemeKeyTokens.OnSurfaceVariant;
        f23340l = colorSchemeKeyTokens2;
        f23341m = typographyKeyTokens;
        f23342n = colorSchemeKeyTokens2;
    }

    private SearchViewTokens() {
    }

    public final ColorSchemeKeyTokens a() {
        return f23332d;
    }

    public final ShapeKeyTokens b() {
        return f23333e;
    }

    public final ShapeKeyTokens c() {
        return f23335g;
    }
}
